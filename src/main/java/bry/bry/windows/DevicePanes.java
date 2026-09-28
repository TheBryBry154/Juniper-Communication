package bry.bry.windows;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DevicePanes {


    public static HashMap<String, JPanel> devicePanels = new HashMap<>();

    public static void newPanelTemplate(String name,String ipAdr ){

        JLabel nameLabel = new JLabel("Name: " + name);
        JLabel ipAdrLabel = new JLabel("Address: " + ipAdr);
        //JLabel connected = new JLabel((Icon) DeviceListRenderer.bluePath);

        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout());
        panel.add(nameLabel);
        panel.add(ipAdrLabel);
        panel.setVisible(true);


        devicePanels.put(name, panel);
        WindowMaker.listModel.addElement(name);
    }



}
