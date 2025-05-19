package review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException{
		
		//소켓 생성 (종이컵 전화기)
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("=======================================");
		
		//서버에 연결 요청
		System.out.println("[서버에 연결을 요청합니다.]");
		socket.connect(new InetSocketAddress("192.0.0.2", 10001));
		
		//쓰기 스트림 준비
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//읽기 스트림 준비
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		
		//스캐너 준비
		Scanner sc = new Scanner(System.in);
		//---------반복
		while(true) {
			
			//메세지 키보드로 입력받기
			String msg = sc.nextLine();
			
			if("/q".equals(msg)) {
				break;
			}
			
			//메세지 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
			
			//메세지 받기
			String reMsg = br.readLine();
			System.out.println("server:[" + reMsg + "]");
			
		}
		
		//클라이언트 종료
		System.out.println("=======================================");
		System.out.println("<클라이언트 종료>");
		
		//닫기
		sc.close();
		br.close();
		bw.close();
		socket.close();
		
	}
}
