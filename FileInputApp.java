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
        filePathField.setEditable(false); // Make it read-only

        // Button to open file chooser
        JButton browseButton = new JButton("Choose Folder");

        // Action for Browse button
        browseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select a Folder");
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
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
        return inputpanel;
    }
}
