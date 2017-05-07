package model;

import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) {

		try {
			final int port = 1030;
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("waiting for the client ....");
			while (true) {
				Socket server =  serverSocket.accept();
				System.out.println("client connetcted from" + server.getLocalAddress().getHostName());
				Client chat = new Client(server);
				Thread thread = new Thread(chat);
				thread.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}