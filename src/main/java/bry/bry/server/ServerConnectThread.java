package bry.bry.server;

import bry.bry.LogStuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class ServerConnectThread implements Runnable {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;
    private int port;


    public ServerConnectThread(int port) {
        this.port = port;
    }

    @Override
    public void run() {


        try {
            openServer(port);
        } catch (IOException e) {
            LogStuff.putToErrorOut(e.getMessage());
        }
    }

    public void openServer(int port) throws IOException {
        try {
            out.println("opening new server socket");

            serverSocket = new ServerSocket(port);
            out.println("new server socket with port: " + serverSocket.getLocalPort() + " and address: " + serverSocket.getInetAddress());

            clientSocket = serverSocket.accept();

            System.out.println("new server client with port: " + clientSocket.getPort() + " and address: " + clientSocket.getInetAddress());

            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (Exception e) {
            LogStuff.putToErrorOut(e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public void stopServer() throws IOException {

        writer.close();
        reader.close();
        clientSocket.close();
        serverSocket.close();
        out.println("SERVER SOCKET with: "+ clientSocket.getInetAddress() +" TERMINATED");
    }



}