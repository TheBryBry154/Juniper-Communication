package bry.bry.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class ServerStuff {




    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static PrintWriter writer;
    private static BufferedReader reader;

    public static void openServer(int port) throws IOException {

        out.println("opening server");

        serverSocket = new ServerSocket(port);
        out.println("new server with port: " + serverSocket.getLocalPort() + " and address: " + serverSocket.getInetAddress());

         clientSocket = serverSocket.accept();

        System.out.println("new server client with port: " + clientSocket.getPort() + " and address: " + clientSocket.getInetAddress());

        writer = new PrintWriter(clientSocket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));



        String inputLine;
        while ((inputLine = reader.readLine()) != null) {



            if (".".equals(inputLine)) {
                out.println("good bye");
                 break;
            }
            writer.println(inputLine);
           //  out.println(inputLine);
        }
            stopServer();
        }


    public static ServerSocket getServerSocket() {
        return serverSocket;
    }

    public static void stopServer() throws IOException {

        writer.close();
        reader.close();
        clientSocket.close();
        serverSocket.close();
        out.println("SERVER TERMINATED");
    }






}
