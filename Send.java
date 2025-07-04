import java.awt.*;
import java.io.File;

import javax.swing.*;

public class Send {
    static FileInputApp fileInputApp = new FileInputApp();
    public static JPanel GUi() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLUE);
        panel.setSize(800, 800);
        panel.setVisible(true);
        panel.setBorder(BorderFactory.createTitledBorder("Send"));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JLabel("Send Panel"));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JLabel("File Input:"));
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        // Adding the file input panel
        JPanel fileInputPanel = fileInputApp.inputFile();
        panel.add(fileInputPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        
        return panel;
    }
}
