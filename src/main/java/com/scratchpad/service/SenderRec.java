package com.scratchpad.service;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.springframework.stereotype.Service;

@Service
public class SenderRec {


    public static void start(String argv[]) {

        try {
            PipedOutputStream pout = new PipedOutputStream();
            PipedInputStream pin = new PipedInputStream(pout);

            Sender s = new Sender(pout, true);
            Receiver r = new Receiver(pin, true);
            System.out.println("Starting threads");
            r.start();
            s.start();
        } catch (Exception e) {}
    }
	
}

class Sender extends Thread {
    ObjectOutputStream oos;
    boolean primitive;

    public Sender(OutputStream os, boolean primitive) {
        try {
            oos = new ObjectOutputStream(os);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        this.primitive = primitive;
    }

    public void run() {
    	 System.out.println("Sender is starting");
        while (true) {
            try {
                System.out.println("Integer is being sent");
                oos.writeInt(10);
                oos.close();
                Thread.sleep(1000);
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }
    }
}

class Receiver extends Thread {
    ObjectInputStream ois;
    boolean primitive;

    public Receiver(InputStream is, boolean primitive) {
        try {
            ois = new ObjectInputStream(is);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        this.primitive = primitive;
    }

    public void run() {
        System.out.println("Receiver is starting");
        while (true) {
            try {
                int x = ois.readInt();
                System.out.print("An int was read: " + x);
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }
    }
}
