package bry.bry;


import bry.bry.client.ClientStuff;
import bry.bry.server.ServerStuff;
import bry.bry.windows.WindowMaker;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;


import static javax.management.remote.JMXConnectorFactory.connect;


class ClientTask implements Runnable {

    public String ipAdr = "192.168.1.247";


    @Override
    public void run() {

        try {

            WindowMaker.newMainWindow();


//            ClientStuff stuff = new ClientStuff();
//
//            stuff.openClient(ipAdr, 154);
//
//
//
//
//            while (true) {
//                try {
//                    Socket socket = new Socket();
//                    socket.connect(new InetSocketAddress(InetAddress.getByName(ipAdr), 154) );
//                    socket.close();
//                } catch (IOException e) {
//                    System.out.println(e);
//                    break;
//                }
//
//
//
//                System.out.println(getOutput());
//
//
//            }
//            ClientStuff.stopClient();
//            WindowMaker.mainFrame.dispose();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);


        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {


        LogStuff.putToLogOut("------START------");




        ClientTask clientTask = new ClientTask();

        Thread thread = new Thread(clientTask);



        thread.start();



        ServerStuff.openServer(154);


    }

    }
