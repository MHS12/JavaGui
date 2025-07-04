package uitolld;
import javax.swing.*;
public class UItools {
    public JButton btn_1(String text){
        // Create a button with the specified text
        JButton button = new JButton(text);
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        return button;
    }
}
