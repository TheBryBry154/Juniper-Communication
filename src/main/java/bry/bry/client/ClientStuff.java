package bry.bry.client;

import bry.bry.LogStuff;
import bry.bry.windows.DevicePanes;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;

public class ClientStuff {

    private Socket clientSocket;
    private DataOutputStream writer;
    private DataInputStream reader;

    public static HashMap<String, Client> nameToClientMap = new HashMap<>();

    public void openClient(String name, String ip, int port) throws IOException {
       // if (!nameToClientMap.containsKey(name)) {
            LogStuff.putToLogOut("Starting Client");

            clientSocket = new Socket();
            clientSocket.connect(new InetSocketAddress(ip, port), 31000);

            LogStuff.putToLogOut("new client with port: " + clientSocket.getPort() + " and address: " + clientSocket.getInetAddress());
            writer = new DataOutputStream(clientSocket.getOutputStream());
            reader = new DataInputStream(clientSocket.getInputStream());

            Client client = new Client(name, ip, clientSocket, writer, reader);
            nameToClientMap.put(name, client);


            System.out.println("Connected: " + name + " " + clientSocket.isConnected());
            DevicePanes.deviceNameAndConnectStatus.put(name, clientSocket.isConnected());
        }

    //}

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




