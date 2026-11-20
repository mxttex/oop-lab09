package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final static String TITLE = "My first graphical java interface";
    private final JFrame frame = new JFrame(TITLE);
    private final Controller controller;

    public SimpleGUI(final Controller controller) {
        this.controller = controller;

        final JPanel pNorth = new JPanel();
        final JTextField textArea = new JTextField();
        pNorth.add(textArea);
        final JButton bSave = new JButton("Save");

        frame.getContentPane().add(pNorth, BorderLayout.NORTH);
        frame.getContentPane().add(bSave, BorderLayout.SOUTH);

        bSave.addActionListener((ActionListener) -> {
           try {
            this.controller.saveOnFile(textArea.getText()); 
           } catch (final IOException e) {
                showMessageDialog(bSave, e.getMessage());
           }
        });

    }

    private void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw /2 , sh /2);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }   

    public static void main() {
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }
}
