package com.scratchpad.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ObjectStream {
	Socket listener;
  
  public ObjectStream() throws UnknownHostException, IOException{
	  listener   = new Socket("127.0.0.1", 11110);
  }

	
	public void startServer() throws IOException {
       //final Socket listener = new Socket("127.0.0.1", 11111);
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                	ObjectInputStream is = new ObjectInputStream(listener.getInputStream());
                	int[] Array = (int[])is.readObject();
                	for (int e : Array) {
                	 System.out.print(e + " ");
                	}
                } catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} finally {
				}
            }
});
        t.start();

}
	
	public void makeConnection() {
	    try {
	    	System.out.println("In makeConnection");
	        int numberArray [] = new int[]{3,6,1,5,8};
	        ObjectOutputStream os =new ObjectOutputStream(listener.getOutputStream());
	        os.writeObject(numberArray);
            System.out.println("Done in client");
	    }catch (Exception e) {
	         System.out.println(e.getMessage());
	    }
	}

	public void start() throws IOException, InterruptedException {
		System.out.println("Starting server");
		startServer();
		//Thread.sleep(1000);
		System.out.println("Starting connection");
		makeConnection();
	}



}
