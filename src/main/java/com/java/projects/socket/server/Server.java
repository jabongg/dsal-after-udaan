package com.java.projects.socket.server;

import com.java.projects.socket.Message;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream inputStream = null;

    // constructor with port
    public Server(int port) {
        // starts  server and waits for connection
        try {
            server = new ServerSocket(port);
            System.out.println("server started");

            System.out.println("waiting for the client...");
            socket = server.accept();
            System.out.println("client accepted!");

            // takes input from the client socket
            inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";
            // reads message from client until "over" is sent
            while (!line.equals("over")) {
                line = inputStream.readUTF();
                System.out.println(line);
            }

            System.out.println("Closing socket connection.");
            socket.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
}
