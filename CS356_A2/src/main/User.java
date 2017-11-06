/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author smaug
 */
public class User implements UserComp{
private String id;
private User[]followers = new User[10];
Database d = Database.getInstance();
    public User(String id){
        this.id = id;
        
    }
    public void add(UserComp u) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
    public String getID() {
        return id;
    }

    
    public void display() {
        System.out.println("-User: " + id);
    }
    
    public User[] getFollowers(){
        return followers;
    }
    public void addFollower(String id){
        for(int j = 0; j < followers.length; j++){
            if(followers[j].equals(null)){
                followers[j].equals(id);
                break;
            }
        }
    }
    
    public void follow(String k){
        for(int i = 0; i < d.getUsers().length; i++){
            if(d.getUsers()[i].getID().equals(k)){
                d.getUsers()[i].addFollower(id);
                break;
            }
        }
    }
    
}
