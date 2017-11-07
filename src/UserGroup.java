import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class UserGroup implements UserComp{
    private String id;
    
    ArrayList g = new ArrayList();
    public UserGroup(String id){
        this.id = id;
    }
    public void add(UserComp u) {
        g.add(u);
    }

    
    public String getID() {
        return id;
    }
    public void display(JPanel p){
        p.add(new JLabel("Group: " + id));
        Iterator groupI = g.iterator();
        while(groupI.hasNext()){
            UserComp i = (UserComp) groupI.next();
            i.display(p);
        }
    }
    
    
}