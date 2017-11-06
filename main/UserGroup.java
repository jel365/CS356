/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import java.util.Iterator;




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
    public void display(){
        System.out.println("Group: " + id);
        Iterator groupI = g.iterator();
        while(groupI.hasNext()){
            UserComp i = (UserComp) groupI.next();
            i.display();
        }
    }
    
    
}
