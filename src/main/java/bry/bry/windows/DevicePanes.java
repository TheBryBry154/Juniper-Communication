package bry.bry.windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DevicePanes {


    public static HashMap<String, JPanel> devicePanels = new HashMap<>();
    public static HashMap<String, String> deviceNameAndAddress = new HashMap<>();
    public static HashMap<String, Boolean> deviceNameAndConnectStatus = new HashMap<>();

    private String address;
    private String name;

    public void newPanelTemplate(String name, String ipAdr){

        JLabel nameLabel = new JLabel("Name: " + name);
        JLabel ipAdrLabel = new JLabel("Address: " + ipAdr);
        JLabel connectionLabel = new JLabel("Connected: " + deviceNameAndConnectStatus.get(name));
        JButton connectToDeviceButton = new JButton("Connect");
        //JLabel connected = new JLabel((Icon) DeviceListRenderer.bluePath);

        connectToDeviceButton.addActionListener(connectToDeviceListener);
        address = ipAdr;
        this.name = name;



        JPanel panel = new JPanel();


        panel.setLayout(new GridLayout());
        panel.add(nameLabel);
        panel.add(ipAdrLabel);
        panel.add(connectToDeviceButton);
        panel.setVisible(true);
        panel.setName(name);

        devicePanels.put(name, panel);
        deviceNameAndAddress.put(name, ipAdr);

        WindowMaker.listModel.addElement(name);
    }


public ActionListener connectToDeviceListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        MiscUtils.connectDevice(address, name);
        }
};


}
