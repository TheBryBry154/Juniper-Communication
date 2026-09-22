package bry.bry.client;

import bry.bry.LogStuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientStuff {

    private static Socket clientSocket;
    private static PrintWriter writer;
    private static BufferedReader reader;

    public static void openClient(String ip, int port) throws IOException {

        LogStuff.putToLogOut("Starting Client");
        clientSocket = new Socket(ip, port);
        LogStuff.putToLogOut("new client with port: " + clientSocket.getPort() + " and address: " + clientSocket.getInetAddress());
        writer = new PrintWriter(clientSocket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Connected: " + clientSocket.isConnected());
    }

    public static void sendMessage(String msg) throws IOException {

        writer.println(msg);

    }

    public static String getOutput() throws IOException {

        return reader.readLine();

    }

    public static Socket getClientSocket() {
        return clientSocket;
    }


    public static void stopClient() throws IOException {
        clientSocket.close();
        writer.close();
        reader.close();
        System.out.println("CLIENT TERMINATED");
    }









    }




