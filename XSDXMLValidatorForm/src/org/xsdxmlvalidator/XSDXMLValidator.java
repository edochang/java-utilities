package org.xsdxmlvalidator;

// Import other java packages
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class XSDXMLValidator extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2977604866656698943L;
	
	// Define class variable
	JTextArea responseTextArea;
	JTextArea xmlTextArea;
	JTextArea xsdTextArea;
	
	private static JFrame frame;
	
	//public static JButton validateXML = new JButton("Validate XML");
	//public static JButton validateXSD = new JButton("Validate XSD");
	public static JButton validateXSDXML = new JButton("Validate XML XSD");
	
	public XSDXMLValidator() {
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		
		responseTextArea = new JTextArea(5, 130); 
		responseTextArea.setEditable(false);
		JScrollPane scrollPaneResponse = new JScrollPane(responseTextArea);
		
		xmlTextArea = new JTextArea(40, 60);
		JScrollPane scrollPane = new JScrollPane(xmlTextArea);
		
		/*
		validateXML.setAlignmentX(Component.CENTER_ALIGNMENT);
		validateXML.addActionListener(this);
		*/
		
		xsdTextArea = new JTextArea(40, 60);
		JScrollPane scrollPane2 = new JScrollPane(xsdTextArea);
		
		/*
		validateXSD.setAlignmentX(Component.CENTER_ALIGNMENT);
		validateXSD.addActionListener(this);
		*/
		
		validateXSDXML.setAlignmentX(Component.CENTER_ALIGNMENT);
		validateXSDXML.addActionListener(this);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel horizontalPanel = new JPanel();
		horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.LINE_AXIS));
		
		JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("XML Message"),
                BorderFactory.createEmptyBorder(10,10,10,10)));
        leftPanel.add(scrollPane);
        leftPanel.add(Box.createRigidArea(new Dimension(0,10)));
        //leftPanel.add(validateXML);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        rightPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("XSD Schema"),
                        BorderFactory.createEmptyBorder(10,10,10,10)));
        rightPanel.add(scrollPane2);
        rightPanel.add(Box.createRigidArea(new Dimension(0,10)));
        //rightPanel.add(validateXSD);
        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add(scrollPaneResponse);
        
        horizontalPanel.add(leftPanel);
        horizontalPanel.add(Box.createRigidArea(new Dimension(10,0)));
        horizontalPanel.add(rightPanel);
        
        mainPanel.add(horizontalPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,10)));
        mainPanel.add(validateXSDXML);
        mainPanel.add(Box.createRigidArea(new Dimension(0,10)));
        mainPanel.add(bottomPanel);

        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        add(mainPanel);
	}
	
	//React to the user pushing the ValidateXML button.
    public void actionPerformed(ActionEvent e) {
        /*
    	if (e.getSource() == validateXML){
        	// Perform XML validation action here.
        	System.out.println("Validating XML");
        }
        else if (e.getSource() == validateXSD) {
        	// Perform XSD validation action here.
        	System.out.println("Validating XSD");
        	responseTextArea.setText("Validating XSD");
        }
    	*/
        if (e.getSource() == validateXSDXML) {
        	String result;
        	
        	// Perform XML and XSD validation action here.
        	System.out.println("Validating XML and XSD");
        	result = validate.validtateXMLXSD(xmlTextArea.getText(), xsdTextArea.getText());
        	//result = "<html><body><pre>" + result + "</pre></body></html>";
        	//result = result.replaceAll("(\r\n|\n)", "<br>");
        	responseTextArea.setText(result);
        }
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("XSD XML Validator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new XSDXMLValidator());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
		        UIManager.put("swing.boldMetal", Boolean.FALSE);
		        createAndShowGUI();
            }
        });
    }
}
