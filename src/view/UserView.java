package view;

import controller.EncryptionController;
import model.EncryptionModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView {
    private JFrame frame;
    private JTextField inputTextField;
    private JTextField outputTextField;
    private JTextField keyTextField;
    private JButton encryptButton;

    private EncryptionController controller;

    public UserView() {
        // Initialize the UI components
        frame = new JFrame("Text Encryption Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setLayout(new GridLayout(4, 2, 10, 10));
        // Set window icon
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"/"+"resources/image-icon.png");
        frame.setIconImage(icon.getImage());

        JLabel inputLabel = new JLabel("Enter text to encrypt:");
        frame.add(inputLabel);

        inputTextField = new JTextField();
        frame.add(inputTextField);

        JLabel outputLabel = new JLabel("Encrypted text:");
        frame.add(outputLabel);

        outputTextField = new JTextField();
        outputTextField.setEditable(false);
        frame.add(outputTextField);

        JLabel keyLabel = new JLabel("Encryption key:");
        frame.add(keyLabel);

        keyTextField = new JTextField();
        keyTextField.setEditable(false);
        frame.add(keyTextField);

        encryptButton = new JButton("Encrypt");
        encryptButton.setBackground(Color.GREEN); // Set the background color
        encryptButton.setForeground(Color.WHITE); // Set the text color
        frame.add(encryptButton);

        JLabel emptyLabel = new JLabel("");
        frame.add(emptyLabel);

        frame.getContentPane().setBackground(Color.LIGHT_GRAY); // Set the background color of the content pane
    }

    public void setEncryptButtonListener(EncryptionController controller) {
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.encryptText();
            }
        });
    }

    public String getInputText() {
        return inputTextField.getText();
    }

    public void setOutputText(String outputText) {
        outputTextField.setText(outputText);
    }

    public void setKeyText(String keyText) {
        keyTextField.setText(keyText);
    }

    public void init() {
        frame.setVisible(true);
    }
}
