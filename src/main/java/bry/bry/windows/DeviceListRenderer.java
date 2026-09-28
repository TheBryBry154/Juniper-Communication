package bry.bry.windows;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeviceListRenderer extends DefaultListCellRenderer  {

    private static final Path pathDraft = Paths.get(DeviceListRenderer.class.toString());
    public static final Path parentPath = pathDraft.toAbsolutePath().getParent();
    public static final Path dogsPath = Path.of(parentPath + "\\src\\main\\java\\bry\\bry\\windows\\101-dogs.gif");
    public static final Path bluePath = Path.of(parentPath + "\\src\\main\\java\\bry\\bry\\windows\\bluetogreen.gif");


        Font font = new Font("times new roman", Font.BOLD, 15);

        public static List currentList = new List() ;


    @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {



            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);

            if (cellHasFocus)  label.setIcon(new ImageIcon(bluePath.toString()));
            else label.setIcon(new ImageIcon(dogsPath.toString()));

            if (isSelected && WindowMaker.mainPane.getRightComponent() != DevicePanes.devicePanels.get(value)){
                WindowMaker.mainPane.setRightComponent(DevicePanes.devicePanels.get(value));
                WindowMaker.mainPane.setDividerLocation(WindowMaker.mainPane.getLastDividerLocation());
            }

            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(font);
            return label;
        }
    }


