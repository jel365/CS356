



import java.util.ArrayList;


public class Database {
    //List of Users
    private ArrayList<User> userbase = new ArrayList<User>();
    
    //List of User Groups
    private ArrayList<UserGroup> groupbase = new ArrayList<UserGroup>();
    
    //count for users and usergroups
    private int uCount = 7;
    private int gCount = 3;
    private int mCount = 0;
    //singleton instance
    private static final Database d = new Database();
    
    
    //constructor
    private Database(){
        initial();
    }
    
    //sample group and user creation
    void initial(){
        UserGroup Root = new UserGroup("Root");
        UserGroup GroupA = new UserGroup("Club A");
        UserGroup GroupB = new UserGroup("Club B");
        Root.add(GroupA);
        Root.add(GroupB);
        
        
        groupbase.add(Root);
        groupbase.add(GroupA);
        groupbase.add(GroupB);
        
        User A = new User("Stan",this);
        User B = new User("Danielle",this);
        User C = new User("Jenny",this);
        User D = new User("Mike",this);
        User E = new User("Alan",this);
        User F = new User("Steve",this);
        User G = new User("Ken",this);
        
        GroupA.add(A);
        GroupA.add(B);
        GroupA.add(C);
        GroupB.add(D);
        GroupB.add(E);
        GroupB.add(F);
        GroupB.add(G);
        
        userbase.add(A);
        userbase.add(B);
        userbase.add(C);
        userbase.add(D); 
        userbase.add(E);
        userbase.add(F);
        userbase.add(G);
        
        
                
                
                
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
    int getmCount(){
        return mCount;
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