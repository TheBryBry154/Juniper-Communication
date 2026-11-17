package bry.bry.client;

import bry.bry.LogStuff;
import bry.bry.windows.ConnectWindow;
import bry.bry.windows.DevicePanes;

import javax.swing.*;
import java.io.*;
import java.net.*;
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
        while (true) {
            if (panel.getComponent(0) instanceof JLabel label) {
                try {

                    if (!address.isReachable(8000)) {

                        ClientStuff.stopClient(client.getName());

                        LogStuff.putToErrorOut("Closed Client: " + client.getName() + " as Host failed to Heartbeat");

                        label.setText("Connected: False");

                    }

                    Socket testSocket = new Socket();
                    testSocket.connect(new InetSocketAddress(client.getIpAdr(), 154), 100);
                    testSocket.close();

                    LogStuff.putToLogOut("Heartbeat Ping from: " + client.getName() + "/" + client.getIpAdr());
                    label.setText("Connected: True");
                    Thread.sleep(30000);


                } catch (IOException e) {
                    LogStuff.putToErrorOut(e.getMessage());

                    try {
                        ClientStuff.stopClient(client.getName());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    LogStuff.putToErrorOut("Closed Client: " + client.getName() + " as JCom port failed to Heartbeat");
                    label.setText("Connected: False");


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }
}

