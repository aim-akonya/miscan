package com.aim.app.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends Thread {

	private ServerSocket serverSocket;
	private int port;
	private boolean running = false;

	public SocketServer(int port) {
		this.port = port;
	}

	public void startServer() {

		try {
			this.serverSocket = new ServerSocket(port);
			this.start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void stopServer() {
		this.running = false;
		this.interrupt();
	}

	@Override
	public void run() {
		this.running = true;
		while (running) {

			try {
				System.out.println("Listening for a connection");

				// call accept to receive the next connection
				Socket socket = serverSocket.accept();

				// pass request to the handler thread for processing
				RequestHandler requestHandler = new RequestHandler(socket);

				requestHandler.start();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
