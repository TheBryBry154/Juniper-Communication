package bry.bry.windows;

import bry.bry.LogStuff;
import bry.bry.client.ClientStuff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static bry.bry.windows.SettingsWindow.settingsItem;
import static bry.bry.windows.SettingsWindow.settingsListener;

public class WindowMaker {

    public static JFrame mainFrame = new JFrame("Juniper Communication");


    public static JButton connectButton = new JButton("Connect");

    public static JMenuBar bar = new JMenuBar();
    public static JMenu menu = new JMenu("File");
    public static JMenuItem connectItem = new JMenuItem("Connect");


    public static JTextArea logArea = new JTextArea(10, 1);




    public static JScrollPane logPane = new JScrollPane(logArea);


    public static void newMainWindow() throws InterruptedException {

        connectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.CTRL_DOWN_MASK));
        connectItem.addActionListener(connectListener);

        settingsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        settingsItem.addActionListener(settingsListener);


        menu.setMnemonic(KeyEvent.VK_E);
        menu.add(connectItem);
        menu.add(settingsItem);

        bar.getComponent().setBackground(Color.gray);
        bar.add(menu);

        connectButton.setBounds(450, 350, 100, 100);
        connectButton.setLayout(new FlowLayout());
        connectButton.setBackground(Color.gray);
        connectButton.addActionListener(connectListener);
        connectButton.setVisible(true);

        logArea.setEditable(true);



        logPane.setBounds(600, 0, 400, 500);



        mainFrame.setSize(1020, 575);


        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setLayout((LayoutManager) null);


        mainFrame.getContentPane().add(logPane);

        mainFrame.setJMenuBar(bar);
        mainFrame.setResizable(true);
        mainFrame.getContentPane().add(connectButton);

    }







    public static ActionListener connectListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

             ConnectWindow.newConnectWindow();

        }
    };




    }
