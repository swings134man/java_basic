package socket.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.SocketHandler;

/************
 * @info : Java - socket chat Client
 * @name : ConsoleChatClient
 * @date : 2023/03/09 11:04 PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description :
 ************/
public class ConsoleChatClient {


    public static void main(String[] args) {
        Socket sock = null;

        try {
            sock = new Socket("localhost", 9999);
            System.out.println("sock 연결됨 = " + sock);
            OutputStream toServer = sock.getOutputStream(); // 글 보내기

            // 서버에서 값을 받기위한 쓰레드
            ServerHandler serverHandler = new ServerHandler(sock);
            serverHandler.start();

            byte[] buf = new byte[1024];
            int conut;
            while ((conut = System.in.read(buf)) != -1){
                toServer.write(buf, 0, conut);
                toServer.flush();
            }
        }catch (Exception e) {
            System.out.println("연결종료 : " + e);
        }finally {
            try {
                if(sock != null){
                    sock.close();
                }
            }catch (Exception e) {

            }
        }
    }//mian
}//class


class ServerHandler extends Thread {
    Socket socket = null;

    public ServerHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        InputStream fromServer = null;

        try {
            fromServer = socket.getInputStream();

            byte[] buf = new byte[1024];
            int count;

            while ((count = fromServer.read(buf)) != -1) {
                System.out.write(buf, 0, count);
            }
        }catch (Exception e) {
            System.out.println("연결종료 : " + e);
        }finally {
            try {
             if(fromServer != null){
                 fromServer.close();
             }
             if(socket != null){
                 socket.close();
             }
            }catch (IOException e) {
            }
        }

    }
}
