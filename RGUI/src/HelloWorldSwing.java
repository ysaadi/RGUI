/*
 * HelloWorldSwing.java requires no other files. 
 */

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HelloWorldSwing extends JPanel implements ActionListener {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
	
    private void HelloWorldSwing() {
        JFrame frame=new JFrame("java swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        JLabel headerLabel = new JLabel("",JLabel.CENTER);
        JLabel statusLabel= new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);
        JButton button;
        button= new JButton("hello");
        frame.add(headerLabel);
        frame.add(statusLabel);
        frame.add(button);
        button.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().beep();
    }


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}