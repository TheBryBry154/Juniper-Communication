package org.example;


import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

import static javax.management.remote.JMXConnectorFactory.connect;
import static org.example.ClientStuff.getOutput;

class ClientTask implements Runnable {

    @Override
    public void run() {

        try {
            ClientStuff.openClient("127.0.0.1", 6666);
            ClientStuff stuff = new ClientStuff();


            Scanner keyboard = new Scanner(System.in);


            while (true) {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 6666) );
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e);
                    break;
                }


                stuff.sendMessage(keyboard.nextLine());
                System.out.println(getOutput());


            }
            ClientStuff.stopClient();

        } catch (IOException e) {
            throw new RuntimeException(e);


        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {


        System.out.println("------START------");

        ClientTask clientTask = new ClientTask();


        Thread thread = new Thread(clientTask);
        thread.start();


        ServerStuff.openServer(6666);


    }

    }
