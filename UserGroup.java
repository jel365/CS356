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
    public UserGroup(String id, Database d){
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
    
    //display usergroup
    public void display(JPanel p){
        p.add(new JLabel("Group: " + id));
        Iterator groupI = g.iterator();
        while(groupI.hasNext()){
            UserComp i = (UserComp) groupI.next();
            i.display(p);
        }
    }
    
    
}