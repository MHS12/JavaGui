import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Recive {
      public JPanel GUiR() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.ORANGE);
        panel.setSize(800, 800);
        // Add a label to make the panel visible
        panel.add(new JLabel("Recive Panel Loaded", javax.swing.SwingConstants.CENTER));
        return panel;
    }
}
