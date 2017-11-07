
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;

//User class
public class User implements UserComp{
private String id;
private ArrayList<User>followers = new ArrayList<User>();
Database d;
ArrayList feed = new ArrayList();
    public User(String id, Database d){
        this.id = id;
        this.d = d;
    }
    
    //User is leaf; not used
    public void add(UserComp u) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    //return ID
    public String getID() {
        return id;
    }

    //display user for tree
    public void display(JPanel p) {
        p.add(new JLabel("-User: " + id));
    }
    
    //return follower list
    public ArrayList<User> getFollowers(){
        return followers;
    }
    
    //follow user
    public void follow(String i){
        d.findUser(i).getFollowers().add(this);
    }
    
    
    
    //add tweet to feed list
    public void status(String s){
        feed.add(s);
        
    }
    
    //return list of tweets
    public ArrayList getFeed(){
        return feed;
    }
    
    
    
    
    
    
}