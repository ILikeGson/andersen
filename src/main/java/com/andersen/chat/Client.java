package com.andersen.chat;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class Client {
    private static Socket clientSocket;
    private static BufferedReader consoleReader;
    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        try {
            String message = "";
            while(Objects.equals(message, "exit")) {
                clientSocket = new Socket("localhost", 4346);
                consoleReader = new BufferedReader(new InputStreamReader(System.in));
                reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                message = consoleReader.readLine();
                writer.write(message);
                writer.flush();
                System.out.println(reader.readLine());
            }
        } finally {
            clientSocket.close();
            reader.close();
            consoleReader.close();
            writer.close();
        }
    }
}
