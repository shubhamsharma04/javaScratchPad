package com.scratchpad.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientServer {

	public void startServer() throws IOException {
       final ServerSocket listener = new ServerSocket(11111);
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    String command = null;
                    while (true) {
                    	System.out.println("About to accept");
                        Socket socket = listener.accept();
                        System.out.println("Got a connection from: " + socket.getLocalPort());
                        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                        StringBuilder str = new StringBuilder(inputStream.readUTF());
                        //command = in.readLine();
                        System.out.println("GOT HERE. Msg received : "+str); //Not being printed out
                        if (str != null && !"".equals(str.toString())) {
                        	command = str.toString();
                            if ("connection".equals(command)) {
                            	System.out.println("Got connection message");
                            	 DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                     	        outputStream.writeUTF("connection");
                     	        outputStream.close();
                     	       inputStream.close();
                            }
                        }
                        System.out.println("Done");
                    }
                } catch (IOException e) {
					e.printStackTrace();
				} finally {
				}
            }
});
        t.start();

}
	
	public void makeConnection() {
	    try {
	    	System.out.println("In makeConnection");
	        Socket socket = new Socket("127.0.0.1", 11111);
	        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
	        outputStream.writeUTF("connection");
	        InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
	        StringBuilder str;
	        do {
                str = new StringBuilder(dataInputStream.readUTF()); 
                System.out.println("str is : "+str);
	            } while (!str.toString().equals("connection"));
	        System.out.println("Successfully saved all hosts to: ");
	        outputStream.close();
            dataInputStream.close();
            socket.close();
            System.out.println("Done in client");
	    }catch (Exception e) {
	         System.out.println(e.getMessage());
	    }
	}

	public void start() throws IOException, InterruptedException {
		System.out.println("Starting server");
		startServer();
		Thread.sleep(1000);
		System.out.println("Starting connection");
		makeConnection();
	}

}
