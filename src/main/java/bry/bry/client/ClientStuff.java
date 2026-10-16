package bry.bry.client;

import bry.bry.LogStuff;
import bry.bry.windows.DevicePanes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class ClientStuff {

    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;

    public static HashMap<String, Client> nameToClientMap = new HashMap<>();

    public void openClient(String name, String ip, int port) throws IOException {
        if (!nameToClientMap.containsKey(name)) {
            LogStuff.putToLogOut("Starting Client");
            clientSocket = new Socket(ip, port);
            LogStuff.putToLogOut("new client with port: " + clientSocket.getPort() + " and address: " + clientSocket.getInetAddress());
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            Client client = new Client(name, ip, clientSocket, writer, reader);
            nameToClientMap.put(name, client);


            System.out.println("Connected: " + clientSocket.isConnected());
            DevicePanes.deviceNameAndConnectStatus.put(name, clientSocket.isConnected());
        }
    }

    public void sendMessage(String msg) throws IOException {

        writer.println(msg);

    }

    public String getOutput() throws IOException {

        return reader.readLine();

    }

    public Socket getClientSocket() {
        return clientSocket;
    }


    public static void stopClient(String name) throws IOException {

        Client client = nameToClientMap.get(name);

        client.getClientSocket().close();
        client.getWriter().close();
        client.getReader().close();
        System.out.println("CLIENT: "+ client.getIpAdr() +" TERMINATED");
        nameToClientMap.remove(name);
    }









    }




