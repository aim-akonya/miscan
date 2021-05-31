package com.aim.app.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestHandler extends Thread {

	private Socket socket;

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {

		try {
			System.out.println("Connection Established with host "+ this.socket.getInetAddress().getHostAddress());

			// Get input and output streams
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());

			// write out our header to the client
			out.println("Echo Server 1.0");
			
			out.flush();

			// Echo lines back to the client until the client closes the connection or we
			// receive an empty line
			String line = in.readLine();
			while (line != null && line.length() > 0) {
				out.println("Echo: " + line);
				out.flush();
				line = in.readLine();
			}

			// close the connection
			in.close();
			out.close();
			socket.close();

			System.out.println("Connection closed");

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
