package bry.bry.windows;

import javax.swing.*;
import java.awt.*;

public class ConnectWindow {

    public static JFrame connectFrame = new JFrame("Connect");

    public static JTextArea ipAdrArea = new JTextArea(1, 9);
    public static JScrollPane adrPane = new JScrollPane(ipAdrArea);

    public static JLabel connectLabel = new JLabel("Connect a device");



    public static void newConnectWindow(){


        connectFrame.setSize(500, 250);
        connectFrame.setLocationRelativeTo(null);
        connectFrame.setResizable(false);
        connectFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        connectFrame.setVisible(true);







    }





}
