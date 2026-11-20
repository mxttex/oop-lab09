package it.unibo.mvc;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My second java graphical interface";
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller;

    public SimpleGUIWithFileChooser(final Controller controller) {
        this.controller = controller;
    
        final JPanel upperPanel = new JPanel();
        final JTextArea text = new JTextArea();
        upperPanel.setLayout(new BorderLayout());
        final JTextField textField = new JTextField(this.controller.getFilePath());
        textField.setEditable(false);
        final JButton browseFile = new JButton("Browse...");
        upperPanel.add(textField, BorderLayout.CENTER);
        upperPanel.add(browseFile, BorderLayout.LINE_END);

        final JButton bSave = new JButton("Save");

        frame.getContentPane().add(upperPanel, BorderLayout.NORTH);
        frame.getContentPane().add(text, BorderLayout.CENTER);
        frame.getContentPane().add(bSave, BorderLayout.SOUTH);

        bSave.addActionListener((event) -> {
            try {
                this.controller.saveOnFile(text.getText());
            } catch (final IOException e) {
                showMessageDialog(bSave, e.getMessage());
            }
        });

        browseFile.addActionListener((event) -> {
            final JFileChooser fileChooser = new JFileChooser();
            fileChooser.setSelectedFile(this.controller.getFile());
            final int result = fileChooser.showSaveDialog(browseFile);

            switch (result) {
                case JFileChooser.APPROVE_OPTION:
                    this.controller.setFile(fileChooser.getSelectedFile());
                    textField.setText(this.controller.getFilePath());
                    break;

                case JFileChooser.CANCEL_OPTION:
                    break;
                default:
                    JOptionPane.showMessageDialog(fileChooser, "An error has occured");

            }
        });

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 4, sh / 4);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main() {
        final SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser(new Controller());
        gui.display();

    }

    private void display() {
        frame.setVisible(true);
    }
}
