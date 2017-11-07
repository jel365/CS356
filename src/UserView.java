
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
public class UserView extends JFrame implements ActionListener{
    private Database d = Database.getInstance();
    private User u;
    
    //interactible GUI items
    JButton followButton = new JButton("Follow");
    JTextField followUser = new JTextField(20);
    
    JTextField tweetField = new JTextField(30);
    JButton tweet = new JButton("Post Tweet");
    JPanel newsFeed = new JPanel();
    JPanel followerList = new JPanel();
    
    public UserView(User u){
        this.u = u;
        //setup for UserView Window
        setSize(600,600);
        setLocationRelativeTo(null);
        setLayout(null);
        
        
        //followers panel
        
        followerList.setSize(600,200);
        followerList.setLocation(0,50);
        followerList.setBackground(Color.cyan);
        
        //header panel
        JPanel header = new JPanel();
        header.setSize(600,50);
        header.setLocation(0,0);
        JLabel userID = new JLabel("User: " + u.getID());
        followButton.addActionListener(this);
        followButton.setActionCommand("follow");
        header.add(userID, FlowLayout.LEFT);
        header.add(followUser, FlowLayout.CENTER);
        header.add(followButton, FlowLayout.RIGHT);
        header.setBackground(Color.cyan);
        
        
        //Tweet Panel
        JPanel tweetP = new JPanel();
        tweetP.setSize(600, 50);
        tweetP.setLocation(0,250);
        tweet.addActionListener(this);
        tweet.setActionCommand("tweet");
        tweetP.add(tweetField);
        tweetP.add(tweet);
        
        
        //Feed Panel
        newsFeed.setBackground(Color.cyan);
        newsFeed.setSize(600,300);
        newsFeed.setLocation(0, 300);
        newsFeed.setLayout(new BoxLayout(newsFeed,BoxLayout.Y_AXIS));
        
        
        add(newsFeed);
        add(tweetP);
        add(header);
        add(followerList);
       
        displayFeed();
        displayFollowers();
        setVisible(true);
    }
    
    //display news feed for user
    public void displayFeed(){
        newsFeed.add(new JLabel("News Feed"));
        Date d = new Date();
        
        for(int x = 0; x < u.getFeed().size(); x++){
            String s = (String) u.getFeed().get(x);
            newsFeed.add(new JLabel(s + " (Posted on " + d.toString() + ")"));
            
            revalidate();
        }
        
    }
    //display followers of user
    public void displayFollowers(){
        followerList.add(new JLabel("Followers: "));
        for(int z = 0; z < u.getFollowers().size(); z++){
            String s = u.getFollowers().get(z).getID();
            followerList.add(new JLabel(s));
            
            revalidate();
        }
    }
//updates followers with user's status
public void Update(String s){
        for(int a = 0; a < u.getFollowers().size(); a++){
            
           
            d.findUser(u.getID()).getFollowers().get(a).getFeed().add(s);
            
            System.out.println("Followers updated");
            revalidate();
        }
    }

//checks for predetermined positive words
public void positiveCheck(){
    if(tweetField.getText().contains("great") || tweetField.getText().contains("awesome") || tweetField.getText().contains("cool") || tweetField.getText().contains("neat")){
        d.addedPositive();
    }
}
    
    public void actionPerformed(ActionEvent e) {
        //follow user ID in textfield
        if(e.getActionCommand().equals("follow")){
            followerList.removeAll();
            u.follow(followUser.getText());
            displayFollowers();
         //post status
        }else if(e.getActionCommand().equals("tweet")){
            d.addedMessage();
            positiveCheck();
            newsFeed.removeAll();
            u.status(tweetField.getText());
            Update(tweetField.getText());
            displayFeed();
            revalidate();
        }
    }
}