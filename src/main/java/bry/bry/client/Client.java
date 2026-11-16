package bry.bry.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private String name;
    private String ipAdr;
    private Socket clientSocket;
    private DataOutputStream writer;
    private DataInputStream reader;

    public Client(String name, String ipAdr, Socket clientSocket, DataOutputStream writer, DataInputStream reader){
        this.name = name;
        this.ipAdr = ipAdr;
        this.clientSocket = clientSocket;
        this.writer = writer;
        this.reader = reader;

    }

    public String getName() {
        return name;
    }

    public String getIpAdr() {
        return ipAdr;
    }

    public DataInputStream getReader() {
       return reader;
    }

    public DataOutputStream getWriter() {
        return writer;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

}

