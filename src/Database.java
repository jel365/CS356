
import java.util.ArrayList;


public class Database {
    //List of Users
    private ArrayList<User> userbase = new ArrayList<User>();
    
    //List of User Groups
    private ArrayList<UserGroup> groupbase = new ArrayList<UserGroup>();
    
    //count for users and usergroups
    private int uCount = 0;
    private int gCount = 0;
    private float mCount = 0;
    private float positive = 0;
    //singleton instance
    private static final Database d = new Database();
    
    
    //constructor
    private Database(){
        
    }
    
    
    //retrieve singleton instance
    static Database getInstance(){
        return d;
    }
    
    //returns user list
    ArrayList<User> getUsers(){
        return userbase;
    }
    
    //returns user group list
    ArrayList<UserGroup> getGroups(){
        return groupbase;
    }
    
    //return number of users
    int getuCount(){
        return uCount;
    }
    
    //increase number of users
    void addedUser(){
        uCount++;
    }
    float getmCount(){
        return mCount;
    }
    float getPositive(){
        return positive;
    }
    void addedPositive(){
        positive++;
    }
    void addedMessage(){
        mCount++;
    }
    
    //return number of user groups
    void addedGroup(){
        gCount++;
    }
    
    //increase number of user groups
    int getgCount(){
        return gCount;
    }
    
    //find specific user in userbase
    User findUser(String id){
        for(int b = 0; b < userbase.size(); b++){
            if(userbase.get(b).getID().equals(id)){
                return userbase.get(b);
            }
        }
        return null;
    }
    
    UserGroup findUserGroup(String id){
        for(int b = 0; b < groupbase.size(); b++){
            if(groupbase.get(b).getID().equals(id)){
                return groupbase.get(b);
            }
        }
        return null;
    }
}