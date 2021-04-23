package com.qhm.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class Client {
    public static void main(String[] args) throws IOException {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}
