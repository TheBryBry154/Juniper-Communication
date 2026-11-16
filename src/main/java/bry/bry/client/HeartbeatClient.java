package bry.bry.client;

import bry.bry.LogStuff;
import bry.bry.windows.ConnectWindow;
import bry.bry.windows.DevicePanes;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.http.HttpClient;
import java.util.concurrent.ExecutorService;

public class HeartbeatClient implements Runnable {

    private Client client;
    private byte[] ping = "AppleFritter".getBytes();
    public HeartbeatClient(Client client){
        this.client = client;
    }

    @Override
    public void run() {

        JPanel panel = DevicePanes.devicePanels.get(client.getName());
        DataInputStream reader = client.getReader();
        DataOutputStream writer = client.getWriter();
        InetAddress address = null;
        try {
            address = InetAddress.getByName(client.getIpAdr());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        while (true){

            try {

                if (panel.getComponent(0) instanceof JLabel label) {

                    System.out.println(address.isReachable(8000));

                if (!address.isReachable(8000)){

                         ClientStuff.stopClient(client.getName());

                        LogStuff.putToErrorOut("Closed Client: " + client.getName() + " failed to Heartbeat");
                        label.setText("Connected: False");

                }


                    label.setText("Connected: True");

                    System.out.println("ping!");
                    Thread.sleep(5000);
                }


            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//            try {



//                if (panel.getComponent(0) instanceof JLabel label) {
//
//                    System.out.println("ping " + ping);
//
//                    ExecutorService service =
//
//                    writer.writeInt(ping.length);
//                    System.out.println("int " + ping.length);
//
//                    writer.write(ping);
//                    System.out.println("write");
//
//                    writer.flush();
//                    System.out.println("flush");
//
//                    int length = reader.readInt();
//                    System.out.println("read");
//
//                    byte[] pong = new byte[length];
//                    System.out.println("pong" + length);
//
//                    reader.readFully(pong);
//                    System.out.println("full");
//
//                    System.out.println("a " + new String(pong));
//
//                    if (!new String(pong).equals("AppleFritters")) {
//
//                        ClientStuff.stopClient(client.getName());
//
//                        LogStuff.putToErrorOut("Closed Client: " + client.getName() + " failed to Heartbeat");
//                        label.setText("Connected: False");
//                    }
//
//
//                    label.setText("Connected: True");
//
//                    Thread.sleep(5000);
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

        }
    }
}

