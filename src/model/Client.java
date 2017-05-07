package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{

	private Socket socket;
	
	public Client(Socket s) {
		// TODO Auto-generated constructor stub
		socket = s;	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		try {
		
			Scanner in = new Scanner(socket.getInputStream());
			
			PrintWriter out = new PrintWriter(socket.getOutputStream());
		
			while (true) {
				if(in.hasNext()){
					String input = in.nextLine();
					System.out.println("Client said"+input);
					out.println("you said:"+input);
					out.flush();
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
