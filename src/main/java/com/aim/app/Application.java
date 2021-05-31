package com.aim.app;

import com.aim.app.sockets.SocketServer;

public class Application {

	public static void main(String[] args)  {
		
		SocketServer server = new SocketServer(8080);
		
		server.startServer();

	}
}
