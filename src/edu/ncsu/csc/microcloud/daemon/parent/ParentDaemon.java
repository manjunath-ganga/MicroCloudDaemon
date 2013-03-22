package edu.ncsu.csc.microcloud.daemon.parent;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ParentDaemon {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		ServerSocket listener = null;
		try{
			listener = new ServerSocket(9000);
			System.out.println("Waiting for connections");
			while(true){
				Socket socket = listener.accept();
				try{
					System.out.println(socket.getInetAddress());
					PrintWriter outputStream = new PrintWriter(socket.getOutputStream(), true);
					outputStream.println(socket.getInetAddress());
				}finally{
					socket.close();
				}
			}
		}finally{
			listener.close();
		}

	}

}
