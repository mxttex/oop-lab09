package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    
    private static final String PRINT = "Print";
    private static final String SHOW_HISTORY = "Show History";
    private static final String TITLE = "Ex 93 - MVC I/O";
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller = new SimpleController();

    private SimpleGUI() {
        // declaring the components
        final JPanel lowerPanel = new JPanel(new BorderLayout());
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        final JButton bPrint = new JButton(PRINT);
        final JButton bShowHistory = new JButton(SHOW_HISTORY);

        // deny user to write in the text area
        textArea.setEditable(false);

        // setting up the panel
        lowerPanel.add(bPrint, BorderLayout.LINE_START);
        lowerPanel.add(bShowHistory, BorderLayout.LINE_END);

        frame.getContentPane().add(textField, BorderLayout.NORTH);
        frame.getContentPane().add(textArea, BorderLayout.CENTER);
        frame.getContentPane().add(lowerPanel, BorderLayout.SOUTH);

        // setting up the event listeners
        bPrint.addActionListener((event) -> {
            controller.setNextString(textField.getText());
            controller.printString();
        });
        bShowHistory.addActionListener((event) -> {
            textArea.setText(String.join("\n", controller.getHistory()));
        });

        // setting up the frame
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int screenWidth = (int) screen.getWidth();
        final int screenHeight = (int) screen.getHeight();
        frame.setSize(screenWidth / 4, screenHeight / 4);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void display() {
        frame.setVisible(true);
    }
    public static void main() {
        SimpleGUI gui = new SimpleGUI();
        gui.display();
    }
}
