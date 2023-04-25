package socket.auth;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class AuthClientSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345); // 서버에 연결
        OutputStream outputStream = socket.getOutputStream(); // 소켓에서 출력 스트림 받기

        Scanner scanner = new Scanner(System.in);
        System.out.print("ID 입력: ");
        String id = scanner.nextLine(); // ID 입력받기
        System.out.print("Password 입력: ");
        String password = scanner.nextLine(); // Password 입력받기

        outputStream.write(id.getBytes()); // ID 소켓에 쓰기
        outputStream.write("\n".getBytes());
        outputStream.write(password.getBytes()); // Password 소켓에 쓰기
        outputStream.write("\n".getBytes());

        InputStream inputStream = socket.getInputStream(); // 소켓에서 입력 스트림 받기
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String message = reader.readLine(); // 서버로부터 인증 결과 읽기
        System.out.println(message);

        if (message.equals("인증 성공")) {
            // 인증 성공 시 서버와 채팅
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in)); // 콘솔에서 입력 스트림 받기
            String inputLine;
            while ((inputLine = inputReader.readLine()) != null) {
                System.out.println(inputLine);
                outputStream.write(inputLine.getBytes()); // 서버로 입력된 문자열 전송
                outputStream.write("\n".getBytes());
            }
        }

        socket.close(); // 소켓 닫기
    }
}
