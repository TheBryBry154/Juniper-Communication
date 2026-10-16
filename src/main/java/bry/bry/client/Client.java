package bry.bry.client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private String name;
    private String ipAdr;
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;

    public Client(String name, String ipAdr, Socket clientSocket, PrintWriter writer, BufferedReader reader){
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

    public BufferedReader getReader() {
       return reader;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

}

