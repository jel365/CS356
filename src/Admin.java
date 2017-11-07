import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
Admin Window
includes panels for all controls and tree view
*/
public class Admin extends JFrame implements ActionListener{
    private Database d = Database.getInstance();
    
    //GUI elements
    JTextField u_id = new JTextField(20);
    JButton addU = new JButton("Add user");
    JTextField g_id = new JTextField(20);
    JButton addG = new JButton("Add user group");
    JButton uView = new JButton("Switch to user view"); 
    JButton uTotal = new JButton("Total users");
    JButton uGTotal = new JButton("Total user groups");
    JButton percentage = new JButton ("Positive percentage");
    JButton mTotal = new JButton("Total messages");
    JTextField view = new JTextField(20);
    JPanel tree = new JPanel();
    
    public Admin(){
    //Frame setup
    setSize(600,640);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(null);
    
    //ActionListener setup
    addU.addActionListener(this);
    addU.setActionCommand("user");
    
    addG.addActionListener(this);
    addG.setActionCommand("group");
    
    uTotal.addActionListener(this);
    uTotal.setActionCommand("userCount");
    
    uGTotal.addActionListener(this);
    uGTotal.setActionCommand("groupCount");
    
    uView.addActionListener(this);
    uView.setActionCommand("userView");
    
    percentage.addActionListener(this);
    percentage.setActionCommand("percent");
    
    mTotal.addActionListener(this);
    mTotal.setActionCommand("messageCount");
    
    
    //button control panel
    JPanel controls = new JPanel();
    controls.setSize(300,400);
    controls.setLocation(300, 0);
    u_id.setMaximumSize(new Dimension(300,20));
    g_id.setMaximumSize(new Dimension(300,20)); 
    view.setMaximumSize(new Dimension(300,20));
    controls.setLayout(new BoxLayout(controls, BoxLayout.Y_AXIS));
    controls.setBackground(Color.white);
    controls.add(u_id);
    controls.add(addU);
    controls.add(g_id);
    controls.add(addG);
    
    //Total buttons panel
    JPanel Totals = new JPanel();
    Totals.setSize(300,200);
    Totals.setLocation(300,400);
    Totals.setBackground(Color.blue);
    Totals.setLayout(new GridLayout(2,2));
    Totals.add(percentage);
    Totals.add(mTotal);
    Totals.add(uTotal);
    Totals.add(uGTotal);
    Totals.setBackground(Color.white);
    controls.add(view);
    controls.add(uView);
    
    
    //hierarchy panel
    tree.setSize(300,600);
    tree.setLocation(0, 0);
    tree.setBackground(Color.red);
    tree.setLayout(new BoxLayout(tree, BoxLayout.Y_AXIS));
    d.getGroups().get(0).display(tree);
    tree.setBackground(Color.cyan);
    
    add(tree);
    add(controls);
    add(Totals);
    setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {
        //Creates User 
        if(e.getActionCommand().equals("user")){
           
            d.getUsers().add(new User(u_id.getText(),d)); //add to user arraylist
            d.addedUser();                              //increment count
            d.getGroups().get(0).add(new User(u_id.getText(),d));  //add to root 
            tree.removeAll();
            d.getGroups().get(0).display(tree);
           
            revalidate();
        //Creates Group   
        }else if(e.getActionCommand().equals("group")){
            d.getGroups().add(new UserGroup(g_id.getText(),d));
            d.addedGroup();
            d.getGroups().get(0).add(new UserGroup(g_id.getText(),d));
            tree.removeAll();
            d.getGroups().get(0).display(tree);
            revalidate();
        //Gets usercount
        }else if(e.getActionCommand().equals("userCount")){
         float i = d.getuCount();
         
         JOptionPane.showMessageDialog(rootPane, "User Count: " + i);
         
        //Gets groupcount
        }else if(e.getActionCommand().equals("groupCount"))  {
         
         float w = d.getgCount();
         
         JOptionPane.showMessageDialog(rootPane, "User Group Count: " + w);
         //gets percentage
         
        }else if(e.getActionCommand().equals("percent")){
         float q = (d.getPositive()/d.getmCount())  * 100;
         
         JOptionPane.showMessageDialog(rootPane, "Positive Count: " + q + "%");
         
         //gets total messagecount
        }else if(e.getActionCommand().equals("messageCount")){
            float y = d.getmCount();
         
         JOptionPane.showMessageDialog(rootPane, "Message Count: " + y);
         //Opens user view window   
        }else if(e.getActionCommand().equals("userView")){
            UserView u = new UserView(d.findUser(view.getText()));
        }
    }
    
    
}