
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;

//User class
public class User implements UserComp{
private String id;
private ArrayList<User>followers = new ArrayList<User>();
Database d;
private long creationTime;
private long updateTime;
private boolean isUser = true;
ArrayList feed = new ArrayList();
    public User(String id, Database d, long creationTime, long updateTime){
        this.id = id;
        this.d = d;
        this.creationTime = creationTime;
        this.updateTime = updateTime;
    }
    
    //User is leaf; not used
    public void add(UserComp u) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public boolean userCheck(){
        return isUser;
    }

    //return ID
    public String getID() {
        return id;
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
    
    public long getCreation(){
        return creationTime;
    }
    
    public long getUpdate(){
        return updateTime;
    }
    
    public void setUpdate(long up){
        updateTime = up;
    }
    
    
    
    
    
}