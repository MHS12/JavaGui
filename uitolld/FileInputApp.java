package uitolld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FileInputApp {
    public JPanel inputFile() {
        JPanel inputpanel = new JPanel();
        inputpanel.setSize(400, 150);
        inputpanel.setLayout(new FlowLayout());

        // Text field to show selected file path
        JTextField filePathField = new JTextField(20);
        filePathField.setEditable(false);

        // Button to open file chooser
        JButton browseButton = new JButton("Choose Folder");

        // Action for Browse button
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select a Folder");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 
                int option = fileChooser.showOpenDialog(inputpanel);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePathField.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        inputpanel.add(filePathField);
        inputpanel.add(browseButton);

        inputpanel.setVisible(true);
        JButton browseButtonSend = new JButton("Send File");
        inputpanel.add(browseButtonSend);
        browseButtonSend.addActionListener(e -> {
            String filePath = filePathField.getText();
            if (filePath.isEmpty()) {
                JOptionPane.showMessageDialog(inputpanel, "Please select a file to send.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Prompt for server IP and port
                String serverIP = JOptionPane.showInputDialog(inputpanel, "Enter receiver IP address:", "127.0.0.1");
                String portStr = JOptionPane.showInputDialog(inputpanel, "Enter receiver port:", "5000");
                int port = 5000;
                try { port = Integer.parseInt(portStr); } catch (Exception ex) {}
                Send.sendFileOverLAN(filePath, serverIP, port);
                JOptionPane.showMessageDialog(inputpanel, "File sent: " + filePath, "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        return inputpanel;
    }
}
