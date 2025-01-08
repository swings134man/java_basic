package com.lucas.socket.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/************
 * @info : Java - Socket Chat Server
 * @name : ConsoleChatServer
 * @date : 2023/03/09 11:04 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class ConsoleChatServer extends Thread{

    protected Socket sock;
    private static ArrayList<Socket> clientsList = new ArrayList<>(5);


    public ConsoleChatServer(Socket sock) {
        this.sock = sock;
    }

    //Thread - input, output
    public void run() {
        InputStream fromClient = null;
        OutputStream toClient = null;

        try {
            System.out.println(sock + "연결됨");

            fromClient = sock.getInputStream();

            byte[] buf = new byte[1024]; // Client가 보낸 input
            int count; // 읽은 갯수
            while ((count = fromClient.read(buf)) != -1) { //종료되면 -1, 아니면 대기상태. -> 또한 buf로 글을 읽음.
                for (Socket s: ConsoleChatServer.clientsList) {
                    if(sock != s){ // 자기자신에게는(글쓴이)에게는 안보내기위해.
                        toClient = s.getOutputStream(); // 글을 쓰기위해. -> 글을 보내기위해 server -> client
                        toClient.write(buf, 0, count);
                        toClient.flush();
                    }
                }
                System.out.write(buf, 0, count);
            }
        }catch (Exception e) {
            System.out.println(sock + ": 에러 = " + e);
        }finally {
            try{
                if(sock != null) {
                    sock.close();
                    remove(sock); // 접속 후 나가버린 클라이언트의 경우 List에서 제거.
                }
            }catch (Exception e){}
        }

    }

    // User 제거 - ArrayList에서 제거
    private void remove(Socket socket) {
        for (Socket s: ConsoleChatServer.clientsList) {
            if(s == socket){
                ConsoleChatServer.clientsList.remove(socket);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("serverSocket 생성 = " + serverSocket);

        // 무한루프
        while (true) {
            Socket client = serverSocket.accept(); // 접속허용.
            clientsList.add(client); // 클라이언트 리스트 추가.

            ConsoleChatServer myServer = new ConsoleChatServer(client);
            myServer.start();
        }
    }//main
}//class
