import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/*
Admin Window
includes panels for all controls and tree view
*/
public class Admin extends JFrame implements ActionListener{
    private Database d = Database.getInstance();
    
    //tree-specific objects
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
    private DefaultMutableTreeNode id = null;
    private DefaultMutableTreeNode parent = null;
    private JTree hierarchy = new JTree(root);
    
    //controls_A objects
    private JButton addUser = new JButton("Add user");
    private JTextField userText = new JTextField(20);
    
    private JButton addGroup = new JButton("Add Group");
    private JTextField groupText = new JTextField(20);
    
    private JTextField view = new JTextField(20);
    private JButton addView = new JButton("Open user view");
    
    //controls_B objects
    private JButton userNum = new JButton("Total Users");
    private JButton groupNum = new JButton("Total Groups");
    private JButton percentage = new JButton("Positive percentage");
    private JButton messageNum = new JButton("Total messages");
  
    public Admin(){
        
        //Frame settings
        setSize(717,525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        
        //Hierarchy settings
        JPanel treePanel = new JPanel();
        treePanel.setSize(450,500);
        treePanel.setLocation(0,0);
        treePanel.setBackground(Color.cyan);
        treePanel.add(hierarchy, BorderLayout.WEST);
       
        //controls settings
        JPanel controls_A = new JPanel();
        controls_A.setSize(250,250);
        controls_A.setLocation(450,0);
        controls_A.setLayout(new BoxLayout(controls_A, BoxLayout.Y_AXIS));
        userText.setMaximumSize(new Dimension(400,25));
        groupText.setMaximumSize(new Dimension(400,25));
        view.setMaximumSize(new Dimension(400,25));
        addUser.addActionListener(this);
        addUser.setActionCommand("user");
        addGroup.addActionListener(this);
        addGroup.setActionCommand("group");
        addView.addActionListener(this);
        addView.setActionCommand("userView");
        controls_A.add(userText);
        controls_A.add(addUser);
        controls_A.add(groupText);
        controls_A.add(addGroup);
        controls_A.add(view);
        controls_A.add(addView);
        controls_A.setBackground(Color.cyan);
        
        
        //data menu settings
        JPanel controls_B = new JPanel();
        controls_B.setSize(250,250);
        controls_B.setLocation(450,250);
        controls_B.setLayout(new GridLayout(2,2));
        controls_B.add(userNum);
        userNum.setActionCommand("userCount");
        userNum.addActionListener(this);
        controls_B.add(groupNum);
        groupNum.setActionCommand("groupCount");
        groupNum.addActionListener(this);
        controls_B.add(percentage);
        percentage.setActionCommand("percent");
        percentage.addActionListener(this);
        controls_B.add(messageNum);
        messageNum.setActionCommand("messageCount");
        messageNum.addActionListener(this);
        controls_B.setBackground(Color.cyan);
        
        
        
        add(treePanel);
        add(controls_A);
        add(controls_B);
        setVisible(true);
        
    }
    
    public void add(String u, boolean a){
        //Add node with string name and set child boolean
        id = new DefaultMutableTreeNode(u);
        id.setAllowsChildren(a);
        
        
        if(hierarchy.getSelectionPath() == null || hierarchy.getSelectionPath().getLastPathComponent() == root)//if nothing is selected or selection is root, add to root
        {
        root.add(id);
        }
        else //add to selected node(parent)
        {
        parent = (DefaultMutableTreeNode) hierarchy.getSelectionPath().getLastPathComponent();
        parent.add(id);
        
        
        
        
        
        }
        
    }

    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("user")){
            
            add(userText.getText(),false);
            d.getUsers().add(new User(userText.getText(), d));
            if(parent != null ){
            String s = parent.toString();
            d.findUserGroup(s).add(d.findUser(userText.getText()));
            }
            d.addedUser();
        }
        else if(e.getActionCommand().equals("group"))
        {
            
            add(groupText.getText(),true);
            d.getGroups().add(new UserGroup(groupText.getText(), d));
            if(parent != null){
            String s = parent.toString();
            d.findUserGroup(s).add(d.findUserGroup(groupText.getText()));
            }
            d.addedGroup();
        
        }else if(e.getActionCommand().equals("userCount")){
         int i = d.getuCount();
         
         JOptionPane.showMessageDialog(rootPane, "User Count: " + i);
         
        //Gets groupcount
        }else if(e.getActionCommand().equals("groupCount"))  {
         
         int w = d.getgCount();
         
         JOptionPane.showMessageDialog(rootPane, "User Group Count: " + w);
         
         //gets percentage
        }else if(e.getActionCommand().equals("percent")){
            float p = (d.getPositive() / d.getmCount()) * 100;
            JOptionPane.showMessageDialog(rootPane, "Positive Message Count: " + p);
            
         //gets total messagecount
        }else if(e.getActionCommand().equals("messageCount")){
            int y = (int) d.getmCount();
         
         JOptionPane.showMessageDialog(rootPane, "Message Count: " + y);
         //Opens user view window   
        }else if(e.getActionCommand().equals("userView")){
            UserView u = new UserView(d.findUser(view.getText()));
}
        
        
        DefaultTreeModel T = (DefaultTreeModel) hierarchy.getModel();
        T.reload();
    }

    
}