package bry.bry.server;

import bry.bry.LogStuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.EventListener;

import static java.lang.System.out;

public class ServerStuff {




    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static PrintWriter writer;
    private static BufferedReader reader;

    public static void openServer(int port) throws IOException {

        ServerConnectThread thread = new ServerConnectThread(port);

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
        openServer(154);
    }






}
