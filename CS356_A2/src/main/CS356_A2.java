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
public class CS356_A2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserComp A = new User("115");
        UserComp B = new User("42");
        UserComp C = new User("Boom");
        
        UserComp GA = new UserGroup("Group 1");
        UserComp GB = new UserGroup("Group 2");
        
        
        GB.add(A);
        GB.add(B);
        
        GA.add(C);
        GA.add(GB);
        
        GA.display();
    }
    
}
