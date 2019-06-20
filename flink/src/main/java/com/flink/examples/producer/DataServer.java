package com.flink.examples.producer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;

public class DataServer
{
	public static void main(String[] args) throws IOException
	{

		ServerSocket listener = new ServerSocket(6066);
		try{
		    System.out.println("Waiting for client on port " +
                listener.getLocalPort() + "...");
				Socket socket = listener.accept();
				System.out.println("Got new connection: " + socket.toString());
				
				BufferedReader br = new BufferedReader(new FileReader("D:\\workspace2\\DaMedico\\flink\\src\\main\\resources\\avg.txt"));
				
				try {
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					String line;
					while ((line = br.readLine()) != null){
						
						System.out.println(line);
						Thread.sleep(50);
					}
					
				} finally{
					socket.close();
				}
			
		} catch(Exception e ){
			e.printStackTrace();
		} finally{
			
			listener.close();
		}
	}
}

