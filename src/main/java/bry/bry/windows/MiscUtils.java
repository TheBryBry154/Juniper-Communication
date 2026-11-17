package bry.bry.windows;

import bry.bry.LogStuff;
import bry.bry.client.Client;
import bry.bry.client.ClientConnectThread;
import bry.bry.client.ClientStuff;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import static bry.bry.windows.WindowMaker.*;

public class MiscUtils {

    public static JPopupMenu listRightClickMenu;
    public static JMenuItem deleteItem;
    public static JMenuItem popupConnectItem;
    public static JMenuItem popupDisconnectItem;
    private static int row;

    public static MouseListener rightClickListener = new MouseListener() {


        @Override
        public void mouseClicked(MouseEvent e) {

//            row = ((JList<?>) e.getSource()).locationToIndex(e.getPoint());
//            System.out.println(row);
//            newRightClickPopup(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {

            row = ((JList<?>) e.getSource()).locationToIndex(e.getPoint());
            System.out.println(row);
            newRightClickPopup(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    };

    public static void newRightClickPopup(MouseEvent e){
        if (SwingUtilities.isRightMouseButton(e)) {
            listRightClickMenu = new JPopupMenu();
            deleteItem = new JMenuItem("Delete");
            popupConnectItem = new JMenuItem("Connect");
            popupDisconnectItem = new JMenuItem("Disconnect");

            deleteItem.addActionListener(removeListItem);
            popupConnectItem.addActionListener(connectListItem);
            popupDisconnectItem.addActionListener(disconnectListItem);

            listRightClickMenu.add(deleteItem);
            listRightClickMenu.add(popupConnectItem);
            listRightClickMenu.add(popupDisconnectItem);

            listRightClickMenu.show(deviceList,e.getX(), e.getY());

        }
    }

    public static ActionListener removeListItem = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (listModel.get(deviceList.getSelectedIndex()) instanceof JPanel panel){
              if ( panel.getComponent(1) instanceof JLabel label){

                  DevicePanes.deviceNameAndAddress.remove(label.getText());
                  DevicePanes.devicePanels.remove(label.getText());
              }
            }

            if (deviceList.getSelectedIndex() != -1) {
                try {

                    DevicePanes.devicePanels.remove(listModel.elementAt(row).toString());
                    listModel.remove(deviceList.getSelectedIndex());
                    mainPane.setRightComponent(logPane);
                    ClientStuff.stopClient(listModel.elementAt(row).toString());
                } catch (IOException ex) {
                    LogStuff.putToErrorOut("Could not terminate client device: " + listModel.elementAt(row));
                    LogStuff.putToErrorOut(ex.getMessage());
                }

            }
        }
    };

    public static ActionListener connectListItem = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (deviceList.getSelectedIndex() != -1) {
                System.out.println(row + " -- " +  DevicePanes.deviceNameAndAddress.get(listModel.elementAt(row)));
                connectDevice(
                        DevicePanes.deviceNameAndAddress.get(listModel.elementAt(row)),
                        listModel.elementAt(row).toString()
                );
            }
            }
    };

    public static ActionListener disconnectListItem = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (deviceList.getSelectedIndex() != -1) {
                JPanel panel = DevicePanes.devicePanels.get(listModel.elementAt(row));
                if (panel.getComponent(0) instanceof JLabel label) {
                    label.setText("Connected: False");
                }
                try {
                    ClientStuff.stopClient(listModel.elementAt(row).toString());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    };

    public static void connectDevice(String address, String name){
        ClientConnectThread connectThread = new ClientConnectThread();
        connectThread.ipAdr = address;
        connectThread.name = name;

        System.out.println("thread start!");
        Thread thread = new Thread(connectThread);
        thread.start();

    }


}
