package edu.ncsu.csc.microcloud.daemon.child;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChildDaemon {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		Socket client = new Socket("localhost", 9000);
		System.out.println("connected");
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		try{
			System.out.println(reader.readLine());
		}finally{
			reader.close();
			client.close();
		}
	}

}
