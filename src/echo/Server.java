package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{

		//서버 소켓 생성
		ServerSocket serverSocket = new ServerSocket();
		
		//바인드
		serverSocket.bind(new InetSocketAddress("192.0.0.2", 10001));
	
		//서버 시작
		System.out.println("<서버 시작>");
		System.out.println("==========================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		//socket 종이컵전화기
		Socket socket = serverSocket.accept();
		System.out.println("클라이언트가 연결되었습니다.");
		
		//읽기 스트림 준비
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//쓰기 스트림 준비
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//반복
		//메시지 받기
		String msg = br.readLine();
		
		System.out.println("받은메세지: " + msg);
		
		//메시지 보내기
		bw.write(msg);
		bw.newLine();
		bw.flush();
		
		
		//서버 종료
		System.out.println("==========================");
		System.out.println("<서버 종료>");
		
		//자원 정리
		bw.close();
		br.close();
		socket.close();
		serverSocket.close();
		
	}
	
	
}
