package com.test.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import com.test.model.Airplane;  

public class MainFrame {  
    private void createAndShow() {  
        // Create and set up the window.  
        final JFrame frame = new JFrame("Airplane");  
        // Display the window.  
        frame.setSize(500, 500);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        // set flow layout for the frame  
        frame.getContentPane().setLayout(new FlowLayout());
        
        Airplane airplane = new Airplane();
        PanelRight panel2 = new PanelRight(airplane);
        PanelLeft panel1 = new PanelLeft(airplane);  
        //panel2.add(box2);  
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2); 
        splitPane.setPreferredSize(new Dimension(400,400));
        // JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,  
        // panel1, panel2);  
        frame.getContentPane().add(splitPane);  
    }  
    
    public void startFrame() {  
        javax.swing.SwingUtilities.invokeLater(new Runnable() {  
            public void run() {  
                createAndShow();  
            }  
        });  
    }  
}  