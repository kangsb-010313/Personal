package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{

		//서버 소켓 생성
		ServerSocket serverSocket = new ServerSocket();
		
		//바인드
		serverSocket.bind(new InetSocketAddress("192.168.1.42", 10001));
	
		//서버 시작
		System.out.println("<서버 시작>");
		System.out.println("==========================");
		System.out.println("[연결 대기 중]");
		
		//socket 종이컵전화기
		Socket socket = serverSocket.accept();
		
		//읽기 스트림 준비
		
		//쓰기 스트림 준비
		
		//반복
		//메시지 받기
		//메시지 보내기
		
		//서버 종료
		System.out.println("==========================");
		System.out.println("<서버 종료>");
		
		//자원 정리
		
		socket.close();
		serverSocket.close();
		
	}
	
	
}
