package bry.bry.windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static bry.bry.windows.DevicePanes.*;

public class ConnectWindow {

    public static JFrame connectFrame = new JFrame("Connect");

    public static JTextField ipAdrField = new JTextField( 9);
    public static JTextField deviceNameField = new JTextField( 9);
    public static JButton connectButton = new JButton("Connect");

    public static JLabel connectMainLabel = new JLabel(new ImageIcon(ConnectWindow.class.getResource("/Connect-main.png")));

    public static JLabel ipAdrLabel = new JLabel("Device IP Address: ");
    public static JLabel deviceNameLabel = new JLabel("Device Name: ");



    public static void newConnectWindow(){

        connectFrame.setSize(500, 250);
        connectFrame.setLayout((LayoutManager) null);
        connectFrame.setLocationRelativeTo(null);
        connectFrame.setResizable(false);
        connectFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        connectMainLabel.setBounds(10,10,500,200);

        ipAdrField.setBounds(330, 10, 120, 20);
        ipAdrLabel.setBounds(220,-30,1000, 100);
        connectFrame.add(ipAdrLabel);

        deviceNameField.setBounds(330, 35, 120, 20);
        deviceNameLabel.setBounds(250,-5,100, 100);
        connectFrame.add(deviceNameLabel);

        connectButton.setBounds(350,150,100,50);
        connectButton.addActionListener(connectListener);

        connectFrame.add(ipAdrField);
        connectFrame.add(connectButton);
        connectFrame.add(deviceNameField);
        connectFrame.add(connectMainLabel);
        connectFrame.setVisible(true);



    }

    public static void newErrorMessage(String error, JFrame owner, String header){
        JOptionPane.showMessageDialog(owner,error,header,JOptionPane.ERROR_MESSAGE);
    }

    public static ActionListener connectListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

//            System.out.println("A"+deviceNameField.getText());
//            System.out.println("B"+ipAdrField.getText());
//
//            System.out.println("C"+devicePanels.keySet());
//            System.out.println("D"+deviceNameAndAddress.values());

            DevicePanes devicePanes = new DevicePanes();


            ///  will re-add if i care to stop the masses from having fun and whimsy

//            if (!devicePanels.containsKey(deviceNameField.getText()) && !deviceNameAndAddress.containsValue(ipAdrField.getText())){
               devicePanes.newPanelTemplate(deviceNameField.getText(), ipAdrField.getText());
//            } else if (deviceNameAndAddress.containsValue(ipAdrField.getText())){
//                newErrorMessage("Cannot have the same address as another entry",connectFrame,"Connect Error");
//
//            } else newErrorMessage("Cannot have the same name as another entry",connectFrame,"Connect Error");










        }
    };


}
