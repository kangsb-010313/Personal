package review;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{
		
		//서버 소켓 생성
		ServerSocket serverSocket = new ServerSocket();
		
		//바인드
		//mac으로 학원 wifi 접속 시 ip 주소 --> 192.168.1.42
		//mac 192.0.0.2
		serverSocket.bind(new InetSocketAddress("192.0.0.2", 10001));
		
		//서버 시작
		System.out.println("<서버 시작>");
		System.out.println("=======================================");
		
		//-------반복
		
		while(true) {
		
			System.out.println("[연결을 기다리고 있습니다.]");
			Socket socket = serverSocket.accept();
			System.out.println("[클라이언트가 연결되었습니다.]");
			
			Thread st = new ServerThread(socket);
			st.start();
		}
		
		
	}
}
