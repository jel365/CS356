import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;



//Usergroup class
public class UserGroup implements UserComp{
    private String id;
    private boolean isUser = false;
    private ArrayList g = new ArrayList();
    Database d;
    private long creationTime;
    
    public UserGroup(String id, Database d, long creationTime){
        this.creationTime = creationTime;
        this.id = id;
        this.d = d;
    }
    //add user or usergroup to group
    public void add(UserComp u) {
        g.add(u);
    }
    public boolean userCheck(){
        return isUser;
    }
    //return usergroup ID
    public String getID() {
        return id;
    }
    
    public long getCreation(){
        return creationTime;
    }
    
    
    
}