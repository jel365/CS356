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
public class Database {
    private User[] userbase = new User[10];
    private UserGroup[] groupbase = new UserGroup[10];
    private int uCount = 0;
    private int gCount = 0;
    private static final Database d = new Database();
    private Database(){
        
    }
    static Database getInstance(){
        return d;
    }
    User[] getUsers(){
        return userbase;
    }
    
    UserGroup[] getGroups(){
        return groupbase;
    }
    int getuCount(){
        return uCount;
    }
    void addedUser(){
        uCount++;
    }
    void addedGroup(){
        gCount++;
    }
    int getgCount(){
        return gCount;
    }
}
