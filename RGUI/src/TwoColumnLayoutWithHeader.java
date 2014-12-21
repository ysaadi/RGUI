import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

class TwoColumnLayoutWithHeader {
	private static JFrame mainFrame;
	   private static JLabel headerLabel;
	   private static JLabel statusLabel;
	   private static JPanel controlPanel;
	   private static JLabel msglabel;
    /**
     * Provides a JPanel with two columns (labels & fields) laid out using
     * GroupLayout. The arrays must be of equal size.
     *
     * Typical fields would be single line textual/input components such as
     * JTextField, JPasswordField, JFormattedTextField, JSpinner, JComboBox,
     * JCheckBox.. & the multi-line components wrapped in a JScrollPane -
     * JTextArea or (at a stretch) JList or JTable.
     *
     * @param labels The first column contains labels.
     * @param fields The last column contains fields.
     * @param addMnemonics Add mnemonic by next available letter in label text.
     * @return JComponent A JPanel with two columns of the components provided.
     */
	   public TwoColumnLayoutWithHeader(){
		   prepareGUI();
	   }
    public static JComponent getTwoColumnLayout(
            JLabel[] labels,
            JComponent[] fields,
            boolean addMnemonics) {
        if (labels.length != fields.length) {
            String s = labels.length + " labels supplied for "
                    + fields.length + " fields!";
            throw new IllegalArgumentException(s);
        }
        JComponent panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        // Turn on automatically adding gaps between components
        layout.setAutoCreateGaps(true);
        // Create a sequential group for the horizontal axis.
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        GroupLayout.Group yLabelGroup = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
        hGroup.addGroup(yLabelGroup);
        GroupLayout.Group yFieldGroup = layout.createParallelGroup();
        hGroup.addGroup(yFieldGroup);
        layout.setHorizontalGroup(hGroup);
        // Create a sequential group for the vertical axis.
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        layout.setVerticalGroup(vGroup);

        int p = GroupLayout.PREFERRED_SIZE;
        // add the components to the groups
        for (JLabel label : labels) {
            yLabelGroup.addComponent(label);
        }
        for (Component field : fields) {
            yFieldGroup.addComponent(field, p, p, p);
        }
        for (int ii = 0; ii < labels.length; ii++) {
            vGroup.addGroup(layout.createParallelGroup().
                    addComponent(labels[ii]).
                    addComponent(fields[ii], p, p, p));
        }
/*
        if (addMnemonics) {
            addMnemonics(labels, fields);
        }
*/
        return panel;
    }

    private final static void addMnemonics(
            JLabel[] labels,
            JComponent[] fields) {
        Map<Character, Object> m = new HashMap<Character, Object>();
        for (int ii = 0; ii < labels.length; ii++) {
            labels[ii].setLabelFor(fields[ii]);
            String lwr = labels[ii].getText().toLowerCase();
            for (int jj = 0; jj < lwr.length(); jj++) {
                char ch = lwr.charAt(jj);
                if (m.get(ch) == null && Character.isLetterOrDigit(ch)) {
                    m.put(ch, ch);
                    labels[ii].setDisplayedMnemonic(ch);
                    break;
                }
            }
        }
    }

    /**
     * Provides a JPanel with two columns (labels & fields) laid out using
     * GroupLayout. The arrays must be of equal size.
     *
     * @param labelStrings Strings that will be used for labels.
     * @param fields The corresponding fields.
     * @return JComponent A JPanel with two columns of the components provided.
     */
    public static JComponent getTwoColumnLayout(
            String[] labelStrings,
            JComponent[] fields) {
        JLabel[] labels = new JLabel[labelStrings.length];
        for (int ii = 0; ii < labels.length; ii++) {
            labels[ii] = new JLabel(labelStrings[ii]);
        }
        return getTwoColumnLayout(labels, fields);
    }

    /**
     * Provides a JPanel with two columns (labels & fields) laid out using
     * GroupLayout. The arrays must be of equal size.
     *
     * @param labels The first column contains labels.
     * @param fields The last column contains fields.
     * @return JComponent A JPanel with two columns of the components provided.
     */
    public static JComponent getTwoColumnLayout(
            JLabel[] labels,
            JComponent[] fields) {
        return getTwoColumnLayout(labels, fields, true);
    }

    public static String getProperty(String name) {
        return name + ": \t"
                + System.getProperty(name)
                + System.getProperty("line.separator");
    }
    private static void prepareGUI(){
	      mainFrame = new JFrame("Java SWING Examples");
	      mainFrame.setSize(400,400);
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

    public static void main(String[] args) {
                JComponent[] components = {
                    new JTextField(15),
                    new JTextField(15),
                    new JTextField(15),
                };

                String[] labels = {
                    "File Path:",
                    "Column Names:",
                    "Replicate Vector:",
                };
                
                JLabel[] creating= new JLabel[labels.length];
                int x;
                for( x=0; x < labels.length;x++){
                	creating[x]=new JLabel(labels[x]);
                }
                
                
                	JComponent panel = new JPanel();
                    GroupLayout layout = new GroupLayout(panel);
                    panel.setLayout(layout);
                    // Turn on automatically adding gaps between components
                    layout.setAutoCreateGaps(true);
                    // Create a sequential group for the horizontal axis.
                    GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
                    GroupLayout.Group yLabelGroup = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
                    hGroup.addGroup(yLabelGroup);
                    GroupLayout.Group yFieldGroup = layout.createParallelGroup();
                    hGroup.addGroup(yFieldGroup);
                    layout.setHorizontalGroup(hGroup);
                    // Create a sequential group for the vertical axis.
                    GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
                    layout.setVerticalGroup(vGroup);
                    
                    for( x=0; x < labels.length;x++){
                    	yLabelGroup.addComponent(creating[x]);
                    	yFieldGroup.addComponent(components[x]);
                    	vGroup.addGroup(layout.createParallelGroup().
                                addComponent(creating[x]).
                                addComponent(components[x]));
                    }
                    
                
                JComponent labelsAndFields = getTwoColumnLayout(labels,components);
                //JComponent orderForm = new JPanel(new BorderLayout(5,5));
                //orderForm.add(new JLabel("CoexGenes", SwingConstants.CENTER),
                  //  BorderLayout.PAGE_START);
               // orderForm.add(new JLabel("Please Enter the Path to a csv file you wish to analyse.  Indicate the Column header Names and "
                //		+ "Replicate list by seperating each element with a comma",SwingConstants.EAST);
               // orderForm.add(labelsAndFields, BorderLayout.CENTER);
                //orderForm.add(new JButton("here"));
                controlPanel.add(panel);
                prepareGUI();
                //JOptionPane.showMessageDialog(null, orderForm);
            }
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
    
}