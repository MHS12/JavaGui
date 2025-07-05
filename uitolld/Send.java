package uitolld;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.Socket;

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

    // Method to send a file over LAN
    public static void sendFileOverLAN(String filePath, String serverIP, int serverPort) {
        try (Socket socket = new Socket(serverIP, serverPort);
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
             FileInputStream fis = new FileInputStream(filePath)) {
            File file = new File(filePath);
            dos.writeUTF(file.getName());
            dos.writeLong(file.length());
            byte[] buffer = new byte[4096];
            int read;
            while ((read = fis.read(buffer)) > 0) {
                dos.write(buffer, 0, read);
            }
            dos.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error sending file: " + ex.getMessage());
        }
    }
}
