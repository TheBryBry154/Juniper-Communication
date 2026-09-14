package bry.bry;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import static javax.management.remote.JMXConnectorFactory.connect;
import static bry.bry.ClientStuff.getOutput;

class ClientTask implements Runnable {

    private final String ipAdr = "192.168.1.247";

    @Override
    public void run() {

        try {
            WindowMaker.newMainWindow();

//            ClientStuff.openClient(ipAdr, 154);
//            ClientStuff stuff = new ClientStuff();
//
//            Scanner keyboard = new Scanner(System.in);
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
//                stuff.sendMessage(keyboard.nextLine());
//                System.out.println(getOutput());
//
//
//            }
          //  ClientStuff.stopClient();
          //  WindowMaker.mainFrame.dispose();

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
