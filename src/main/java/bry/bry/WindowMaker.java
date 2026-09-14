package bry.bry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class WindowMaker {

    public static JFrame mainFrame = new JFrame("Juniper Communication");
    public static JFrame settingsFrame = new JFrame("JunCom Settings");
    public static JFrame conncectFrame = new JFrame("Connect");

    public static JButton connectButton = new JButton("Connect");

    public static JMenuBar bar = new JMenuBar();
    public static JMenu menu = new JMenu("File");
    public static JMenuItem connectItem = new JMenuItem("Connect");
    public static JMenuItem settingsItem = new JMenuItem("Settings");

    public static JTextArea logArea = new JTextArea(10,5);
    public static JTextArea ipAdrArea = new JTextArea(1,9);
    public static JTextField settingsTextField = new JTextField("settingsArea");


    public static JScrollPane logPane = new JScrollPane(logArea);
    public static JScrollPane adrPane = new JScrollPane(ipAdrArea);

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

        connectButton.setBounds(450,350,100,100);
        connectButton.setLayout(new FlowLayout());
        connectButton.setBackground(Color.gray);
        connectButton.addActionListener(connectListener);
        connectButton.setVisible(true);

        logArea.setEditable(true);
        ipAdrArea.setEditable(true);


        logPane.setBounds(600, 0, 400, 500);
        adrPane.setBounds(200, 0, 105, 20);



        mainFrame.setSize(1020, 575);



        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.setLayout((LayoutManager)null);


        mainFrame.getContentPane().add(logPane);
        mainFrame.getContentPane().add(adrPane);
        mainFrame.setJMenuBar(bar);
        mainFrame.setResizable(true);
        mainFrame.getContentPane().add(connectButton);

    }


    public static void newSettingsWindow(){


        settingsTextField.setBounds(100, 100, 100,20);


        settingsFrame.getContentPane().add(settingsTextField);

        settingsFrame.setSize(600,600);
        settingsFrame.setLayout((LayoutManager)null);
        settingsFrame.setResizable(false);
        settingsFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        settingsFrame.setVisible(true);



    }


private static Boolean click = true;

public static ActionListener connectListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e)  {

        try {

            ClientStuff.openClient(ipAdrArea.getText(), 154);

            ClientStuff.echoTest(ipAdrArea.getText(), click);

            click = !click;

        } catch (IOException ex) {
            LogStuff.putToLogOut(ex.toString());
            throw new RuntimeException(ex);

        }

    }
};

    public static ActionListener settingsListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)  {

           newSettingsWindow();

        }
    };






}
