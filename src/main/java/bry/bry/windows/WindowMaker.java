package bry.bry.windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import static bry.bry.windows.SettingsWindow.settingsItem;
import static bry.bry.windows.SettingsWindow.settingsListener;

public class WindowMaker {

    public static JFrame mainFrame = new JFrame("Juniper Communication");


    public static JButton connectButton = new JButton("Connect");

    public static JMenuBar bar = new JMenuBar();
    public static JMenu menu = new JMenu("File");

    public static JMenuItem connectItem = new JMenuItem("Connect");
    public static JMenuItem logItem = new JMenuItem("Log");

    public static DefaultListModel listModel = new DefaultListModel();

    public static JList deviceList = new JList(listModel);
    public static JScrollPane deviceListScroll = new JScrollPane(deviceList);

    public static JTextArea logArea = new JTextArea(10, 1);
    public static JScrollPane logPane = new JScrollPane(logArea);

    public static JSplitPane mainPane = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,true, deviceListScroll, logPane);





    public static void newMainWindow() throws InterruptedException {

        connectItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, InputEvent.CTRL_DOWN_MASK));
        connectItem.addActionListener(connectListener);

        settingsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        settingsItem.addActionListener(settingsListener);

        logItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        logItem.addActionListener(logListener);


        menu.setMnemonic(KeyEvent.VK_E);
        menu.add(connectItem);
        menu.add(settingsItem);
        menu.add(logItem);

        bar.getComponent().setBackground(Color.gray);
        bar.add(menu);

        deviceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        deviceList.setLayoutOrientation(JList.VERTICAL);
        deviceList.setVisibleRowCount(-1);




        //deviceList.setSize(100,100);

        connectButton.setBounds(450, 350, 100, 100);
        connectButton.setLayout(new FlowLayout());
        connectButton.setBackground(Color.gray);
        connectButton.addActionListener(connectListener);


        logArea.setEditable(true);

        deviceList.setCellRenderer(new DeviceListRenderer());


        deviceList.setFixedCellHeight(50);




        mainFrame.setSize(1020, 575);


        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setLayout(new GridLayout());


        mainPane.setDividerLocation(200);

        mainFrame.getContentPane().add(mainPane);
        mainFrame.setJMenuBar(bar);
        mainFrame.setResizable(true);


    }




    public static ActionListener logListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            deviceList.clearSelection();
            mainPane.setRightComponent(logPane);
            mainPane.setDividerLocation(mainPane.getLastDividerLocation());
         }
    };


    public static ActionListener connectListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

             ConnectWindow.newConnectWindow();
//            mainPane.setRightComponent(connectButton);
//            mainPane.setDividerLocation(mainPane.getLastDividerLocation());



        }
    };




    }
