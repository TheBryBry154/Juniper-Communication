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

        try {
            ClientStuff stuff = new ClientStuff();

            stuff.openClient(name, ipAdr, 154);


        while (true) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(InetAddress.getByName(ipAdr), 154) );
                socket.close();
            } catch (IOException e) {

                if (ipAdr.isEmpty()) LogStuff.putToWarningOut("Ip Address is empty");

//                LogStuff.putToWarningOut("Could not connect to server, Closing client: " + ipAdr);
//                ClientStuff.stopClient(name);


                System.out.println(e);
                break;
            }

        }

            } catch (IOException e) {
            LogStuff.putToErrorOut(e.getCause().toString());

            System.out.println(e);
        }
    }
}
