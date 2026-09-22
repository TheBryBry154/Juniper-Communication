package bry.bry.windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow {

    public static JFrame settingsFrame = new JFrame("JunCom Settings");

    public static JTextField settingsTextField = new JTextField("settingsArea");
    public static JMenuItem settingsItem = new JMenuItem("Settings");


    public static void newSettingsWindow() {


        settingsTextField.setBounds(100, 100, 100, 20);


        settingsFrame.getContentPane().add(settingsTextField);

        settingsFrame.setSize(600, 600);
        settingsFrame.setLayout((LayoutManager) null);
        settingsFrame.setResizable(false);
        settingsFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        settingsFrame.setVisible(true);


    }

    public static ActionListener settingsListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            newSettingsWindow();

        }
    };

}
