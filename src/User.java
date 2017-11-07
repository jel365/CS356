


import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author smaug
 */
public class User implements UserComp{
private String id;
private ArrayList<User>followers = new ArrayList<User>();
Database d;
ArrayList feed = new ArrayList();
    public User(String id, Database d){
        this.id = id;
        this.d = d;
    }
    public void add(UserComp u) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
    public String getID() {
        return id;
    }

    
    public void display(JPanel p) {
        p.add(new JLabel("-User: " + id));
    }
    
    public ArrayList<User> getFollowers(){
        return followers;
    }
    public void follow(String i){
        d.findUser(i).getFollowers().add(this);
    }
    
    
    
    
    public void status(String s){
        feed.add(s);
        
    }
    
    public ArrayList getFeed(){
        return feed;
    }
    
    public void Update(String s){
        for(int a = 0; a < followers.size(); a++){
            
            followers.get(a).getFeed().add(s);
            System.out.println("Followers updated");
            
        }
    }
    
    
    
}