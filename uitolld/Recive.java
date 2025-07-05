package uitolld;

import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
        JButton startReceiveBtn = new JButton("Start Receiving");
        panel.add(startReceiveBtn);
        startReceiveBtn.addActionListener(e -> {
            String portStr = javax.swing.JOptionPane.showInputDialog(panel, "Enter port to listen on:", "5000");
            final int port;
            try { port = Integer.parseInt(portStr); } catch (Exception ex) { return; }
            javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
            chooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
            int option = chooser.showOpenDialog(panel);
            if (option == javax.swing.JFileChooser.APPROVE_OPTION) {
                final String saveDir = chooser.getSelectedFile().getAbsolutePath();
                new Thread(() -> receiveFileOverLAN(port, saveDir)).start();
                javax.swing.JOptionPane.showMessageDialog(panel, "Receiver started on port " + port + ". Waiting for file...", "Info", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        });
        return panel;
    }
    // Method to receive a file over LAN
    public static void receiveFileOverLAN(int listenPort, String saveDir) {
        try (java.net.ServerSocket serverSocket = new java.net.ServerSocket(listenPort)) {
            System.out.println("Waiting for file...");
            try (java.net.Socket socket = serverSocket.accept();
                 java.io.DataInputStream dis = new java.io.DataInputStream(socket.getInputStream())) {
                String fileName = dis.readUTF();
                long fileSize = dis.readLong();
                java.io.File outFile = new java.io.File(saveDir, fileName);
                try (java.io.FileOutputStream fos = new java.io.FileOutputStream(outFile)) {
                    byte[] buffer = new byte[4096];
                    int read;
                    long remaining = fileSize;
                    while ((read = dis.read(buffer, 0, (int)Math.min(buffer.length, remaining))) > 0) {
                        fos.write(buffer, 0, read);
                        remaining -= read;
                        if (remaining == 0) break;
                    }
                }
                System.out.println("File received: " + outFile.getAbsolutePath());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
