import java.awt.*;
import javax.swing.*;

public class Send {

    public static JPanel GUi() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLUE);
        panel.setSize(800, 800);

        // panel.setVisible(!visible);
        return panel;
    }
}
