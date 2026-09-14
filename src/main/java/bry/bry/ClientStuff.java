package bry.bry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

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


    public static void echoTest(String ipAdr, Boolean on) throws IOException {


        Scanner keyboard = new Scanner(System.in);

        while (on) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(InetAddress.getByName(ipAdr), 154));
                socket.close();
            } catch (IOException e) {
                System.out.println(e);
                break;
            }


            sendMessage(keyboard.nextLine());
            System.out.println(getOutput());


        }


    }
}