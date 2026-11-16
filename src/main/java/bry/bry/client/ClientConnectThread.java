package bry.bry.client;

import bry.bry.LogStuff;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientConnectThread implements Runnable {

    public String ipAdr;
    public String name;

    @Override
    public void run() {

        ClientStuff stuff = new ClientStuff();

        try {
            System.out.println("client open");
            stuff.openClient(name, ipAdr, 154);

            System.out.println("heart");
            Thread heartbeatThread = new Thread(new HeartbeatClient(ClientStuff.nameToClientMap.get(name)));
            heartbeatThread.run();

        } catch (Exception e) {
            LogStuff.putToErrorOut(String.valueOf(e));
        }


    }
    }
