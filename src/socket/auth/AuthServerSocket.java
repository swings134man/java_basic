package socket.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AuthServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345); // 포트번호 12345로 서버 소켓 생성

        while (true) {
            Socket socket = serverSocket.accept(); // 클라이언트 연결 대기
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 소켓에서 입력 스트림 받기

            String id = reader.readLine(); // 클라이언트에서 전송한 ID 읽기
            String password = reader.readLine(); // 클라이언트에서 전송한 Password 읽기

            boolean isAuthenticated = authenticate(id, password); // 인증 검증

            OutputStream outputStream = socket.getOutputStream(); // 소켓에서 출력 스트림 받기

            if (isAuthenticated) {
                outputStream.write("인증 성공\n".getBytes()); // 인증 성공 메시지 보내기

                // 인증 성공 시 클라이언트와 채팅
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in)); // 콘솔에서 입력 스트림 받기
                String inputLine;
                while ((inputLine = inputReader.readLine()) != null) {
                    System.out.println(inputLine);
                    outputStream.write(inputLine.getBytes()); // 클라이언트로 입력된 문자열 전송
                    outputStream.write("\n".getBytes());
                }
            } else {
                outputStream.write("인증 실패\n".getBytes()); // 인증 실패 메시지 보내기
            }

            socket.close(); // 소켓 닫기
        }//main

    }
    // Auth
    // 인증 검증 메서드
    private static boolean authenticate (String id, String password){
        // 여기에 인증 검증 로직을 작성합니다.
        return id.equals("test") && password.equals("test1234");
    }
}
