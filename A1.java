import javax.swing.*;

import uitolld.UItools;

import java.awt.*;

public class A1 {
    static UItools  uiTools = new UItools();
    static Recive recive = new Recive();
    static Send send = new Send();
    static Boolean visible = true;
    public static void main(String[] args) throws Exception {
        // Create a JFrame
        JFrame frame = new JFrame("A1 Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setBackground(null);
        frame.setLayout(new BorderLayout());


        // NavBar section
        JPanel navbar = new JPanel();
        navbar.setLayout(new BoxLayout(navbar, BoxLayout.X_AXIS));
        navbar.setBackground(Color.CYAN);
        navbar.setPreferredSize(new Dimension(frame.getWidth(), 50));
        navbar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        navbar.setMinimumSize(new Dimension(0, 50));



        // body section
        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.setBackground(Color.LIGHT_GRAY);
        body.add(Send.GUi(), BorderLayout.CENTER); // Initial content of the body


        navbar.add(Box.createHorizontalGlue());
        JButton sendButton = uiTools.btn_1("Send");
        JButton reciveButton = uiTools.btn_1("recive");
        navbar.add(sendButton);
        navbar.add(reciveButton);
        navbar.add(Box.createHorizontalGlue());



        sendButton.addActionListener(e -> {
            body.removeAll();
            body.add(Send.GUi(), BorderLayout.CENTER );
            body.revalidate();
            body.repaint();
        });

        reciveButton.addActionListener(e -> {
            body.removeAll();
            body.add(recive.GUiR(), BorderLayout.CENTER);
            body.revalidate();
            body.repaint();
        });
       
        frame.add(navbar, BorderLayout.NORTH);
        frame.add(body, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}