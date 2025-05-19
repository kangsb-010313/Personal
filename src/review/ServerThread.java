package review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread{

	//필드
	private Socket socket;

	
	//생성자
	public ServerThread() {
	}

	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	
	//메소드 gs
	
	//메소드 일반
	@Override
	public void run() {
		
		try {
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			//----------------------------
			while(true) {
				
				String msg = br.readLine();
				
				if(msg == null) {
					break;
				}
				
				System.out.println("받은메세지: " + msg);
				
				bw.write(msg);
				bw.newLine();
				bw.flush();
				
			}
			
		} catch (IOException e) {
			System.out.println(e.toString());
		
		}
		

	}//run
	
	
}
