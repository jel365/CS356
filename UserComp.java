
import javax.swing.JPanel;
//Interface for user and usergroup
public interface UserComp {
    public void add(UserComp u);
    public String getID();
    public void display(JPanel p);
    public boolean userCheck();
    
}