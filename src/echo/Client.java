package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException{
		
		//소켓 생성 종이컵전화기
		Socket socket = new Socket();
		
		//클라이언트 시작
		System.out.println("클라이언트 시작>");
		System.out.println("=================================");
		
		//서버에 연결 요청
		System.out.println("[서버에 연결을 요청합니다.]");
		socket.connect(new InetSocketAddress("192.168.1.42", 10001));
		//쓰기 스트림 준비
		
		//읽기 스트림 준비
		
		//스캐너 준비
		
		
		//반복
		//메세지 키보드로 입력받기
		
		//메세지 보내기
		
		//메세지 받기
		
		
		//클라이언트 종료
		System.out.println("================================");
		System.out.println("<클라이언트 종료>");
		
		//자원 정리
		socket.close();
	}
	
}
