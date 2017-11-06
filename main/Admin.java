/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author smaug
 */
public class Admin extends JFrame implements ActionListener{
    private Database d = Database.getInstance();
    
    JTextField u_id = new JTextField(20);
    JButton addU = new JButton("Add user");
    JTextField g_id = new JTextField(20);
    JButton addG = new JButton("Add user group");
    JButton uView = new JButton("Switch to user view"); 
    JButton uTotal = new JButton("Total users");
    JButton uGTotal = new JButton("Total user groups");
    JButton percentage = new JButton ("Positive percentage");
    JButton mTotal = new JButton("Total messages");
    
    
    public Admin(){
    setSize(600,640);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(null);
    
    addU.addActionListener(this);
    addU.setActionCommand("user");
    
    addG.addActionListener(this);
    addG.setActionCommand("group");
    
    uTotal.addActionListener(this);
    uTotal.setActionCommand("userCount");
    
    uGTotal.addActionListener(this);
    uGTotal.setActionCommand("groupCount");
    
    JPanel controls = new JPanel();
    controls.setSize(300,400);
    controls.setLocation(300, 0);
    u_id.setMaximumSize(new Dimension(300,20));
    g_id.setMaximumSize(new Dimension(300,20));
    
    controls.setLayout(new BoxLayout(controls, BoxLayout.Y_AXIS));
    controls.add(u_id);
    controls.add(addU);
    controls.add(g_id);
    controls.add(addG);
    
    
    JPanel Totals = new JPanel();
    Totals.setSize(300,200);
    Totals.setLocation(300,400);
    Totals.setBackground(Color.blue);
    Totals.setLayout(new GridLayout(2,2));
    Totals.add(percentage);
    Totals.add(mTotal);
    Totals.add(uTotal);
    Totals.add(uGTotal);
    controls.add(uView);
    
    JPanel tree = new JPanel();
    tree.setSize(300,600);
    tree.setLocation(0, 0);
    tree.setBackground(Color.red);
    
    add(tree);
    add(controls);
    add(Totals);
    setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("user")){
            d.getUsers()[d.getuCount()] = new User(u_id.getText());
            d.addedUser();
            
        }else if(e.getActionCommand().equals("group")){
            d.getGroups()[d.getgCount()] = new UserGroup(g_id.getText());
            d.addedGroup();
        }else if(e.getActionCommand().equals("userCount")){
         JOptionPane p = new JOptionPane();
         int i = d.getuCount();
         JLabel count = new JLabel();
         count.setText(String.valueOf(i));
         
        
        }else if(e.getActionCommand().equals("groupCount"))  {
         
         int i = d.getgCount();
         
         JOptionPane.showMessageDialog(rootPane, i);
        }else if(e.getActionCommand().equals("percentage")){
         JOptionPane p = new JOptionPane();
         int i = d.getuCount();
         JLabel count = new JLabel();
         count.setText(String.valueOf(i));
         p.add(count);
         p.setVisible(true);
        }else if(e.getActionCommand().equals("messageCount")){
            
        }else if(e.getActionCommand().equals("userView")){
            
        }
    }
    
    
}
