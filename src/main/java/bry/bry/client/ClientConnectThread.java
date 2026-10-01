package bry.bry.client;

import bry.bry.LogStuff;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientConnectThread implements Runnable {

    public String ipAdr;

    @Override
    public void run() {

        try {
            ClientStuff stuff = new ClientStuff();

            stuff.openClient(ipAdr, 154);


        while (true) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(InetAddress.getByName(ipAdr), 154) );
                socket.close();
            } catch (IOException e) {

                if (ipAdr.isEmpty()) LogStuff.putToLogOut("Ip Address is empty");

                System.out.println(e);
                break;
            }

        }

            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
