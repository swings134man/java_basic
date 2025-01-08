package com.lucas.socket.test_connection;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

/************
 * @info : Socket Server Side
 * @name : ServerSideSocket
 * @date : 2023/04/24 9:42 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class ServerSideSocket {
    public static void main(String[] args) throws IOException {
        System.out.println("서버 실행 중...");

        // ServerSocket(port, backlog)
        // => port: 포트번호
        // => backlog: 대기열의 크기
        ServerSocket serverSocket = new ServerSocket(8888, 3);
        System.out.println("=> 서버 소켓 생성 완료!");

        // 대기열에 기다리고 있는 클라이언트가 없다면, 리턴하지 않는다.
        Socket socket = serverSocket.accept();
        InputStream in0 = socket.getInputStream();
        OutputStream out0 = socket.getOutputStream();

        // 처음 2번의 값으로 id, pw 판별.
        Scanner authFromCli = new Scanner(in0);
        String id = authFromCli.nextLine();
        System.out.println(id);
        String pw = authFromCli.nextLine();
        System.out.println(pw);

        PrintStream out1 = new PrintStream(out0);
        if(!id.equals("admin") && !pw.equals("1234")) {
            out1.println("Bye!");
            authFromCli.close();
            in0.close();
            out1.close();
            out0.close();
            socket.close();
            serverSocket.close();
        }
        out1.println("인증성공");
        out1.close();
        authFromCli.close();
        System.out.println("=> 클라이언트 연결 승인!");


        // TO Client
        while (true){
            Scanner in = new Scanner(in0);
            // TO out
            PrintStream out = new PrintStream(out0);

            String str = in.nextLine(); // 클라이언트로부터 문자열을 한 줄 읽는다.

            System.out.println("From Client >> " + str);

            if(str.equals("time")){
                out.println(LocalDateTime.now());
            }else if(str.equals("close")){
                out.println("Bye!");
                in.close();
                in0.close();
                out.close();
                out0.close();
                socket.close();
                serverSocket.close();
                break;
            }else {
                out.println(str); // 클라이언트가 보낸 문자열을 그대로 돌려준다.
            }
        }
    }//main
}//class
