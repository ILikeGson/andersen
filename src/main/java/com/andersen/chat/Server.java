package com.andersen.chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class Server {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;

    public static void main(String[] args) throws IOException {
        String message = "";
        try {
        while (!Objects.equals(message, "exit")) {
                server = new ServerSocket(4346);
                clientSocket = server.accept();
                bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                message = bufferedReader.readLine();
                bufferedWriter.write("hi!\nYour message: " + message);
                bufferedWriter.flush();
            }
        } finally {
            clientSocket.close();
            bufferedReader.close();
            bufferedWriter.close();
            server.close();
        }
    }
}
