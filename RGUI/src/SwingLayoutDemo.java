import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SwingLayoutDemo {
	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;
	   private JLabel msglabel;
	   JLabel[] lab1={ new JLabel("Input Path to file"),new JLabel("File Headers"), new JLabel("Input Covariates")};
	      JTextField[] tex1= new JTextField[3];

	   public SwingLayoutDemo(){
	      prepareGUI();
	   }

	   public static void main(String[] args){
	      SwingLayoutDemo swingLayoutDemo = new SwingLayoutDemo();  
	      swingLayoutDemo.showGridLayoutDemo();       
	   }
	      
	   private void prepareGUI(){
	      mainFrame = new JFrame("Java SWING Examples");
	      mainFrame.setSize(500,500);
	      mainFrame.setLayout(new GridLayout(3, 1));

	      headerLabel = new JLabel("",JLabel.CENTER );
	      statusLabel = new JLabel("",JLabel.CENTER);        

	      statusLabel.setSize(350,100);
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
		        System.exit(0);
	         }        
	      });    
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }
	   
	   public void showGridLayoutDemo(){
	      headerLabel.setText("Coex Prototype");      

	      JPanel panel = new JPanel();
	      panel.setBackground(Color.white);
	      panel.setSize(400,400);
	      GridLayout layout = new GridLayout(0,2);
	      layout.setHgap(10);
	      layout.setVgap(10);
	      //JLabel[] lab1={ new JLabel("Input Path to file"),new JLabel("File Headers"), new JLabel("Input Covariates")};
	      //JTextField[] tex1= new JTextField[3];
	      for(int x=0; x<3; x++){
	    	  tex1[x]=new JTextField(15);
	      }
	      panel.setLayout(layout);
	      for(int x=0; x<3; x++){
	    	  panel.add(lab1[x]);
	    	  panel.add(tex1[x]);
	      }
	      JButton Go= new JButton("Analyze");
	      Go.addActionListener(new CustomActionListener());
	      panel.add(Go);
	      controlPanel.add(panel);
	      mainFrame.setVisible(true);  
	   }
	   class CustomActionListener implements ActionListener{
		      public void actionPerformed(ActionEvent e) {
		          String path= tex1[0].getText();
		          String Headers= tex1[1].getText();
		          String Covariates=tex1[2].getText();
		          List<String> items = Arrays.asList(Headers.split("\\s*,\\s*"));
		          int total = items.size();
		          statusLabel.setText(Integer.toString(total));
		          statusLabel.setText(items.get(1));
		          
		          
		      }
	}
}