package com.java.projects.socket.client;

import com.java.projects.socket.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream inputStream = null;
    private DataOutputStream outputStream = null;


    // constructor to put ip address and port
    public Client(String ipAddress, int port) {
        // establish a connection
        try {
            socket = new Socket(ipAddress, port);
            System.out.println("Connected!");

            // takes input from the terminal
            inputStream = new DataInputStream(System.in); // we can take the input from file also

            // sends output to the socket.
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // string to read the message from the input
        String line = "";
        // keep reading until "Over" is input
        while (!line.equals("over")) {
            try {
                line = inputStream.readLine();
                outputStream.writeUTF(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // close the connection
        try {
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 5000);
    }
}
