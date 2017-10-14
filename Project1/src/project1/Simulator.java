
package project1;
import java.util.Random;

public class Simulator {


    /**
     * Runs simulated survey with predetermined question
     * 
     * Answers are left to direct user input, and are 5 for the test
     * Number of options can be changed for True/False questions.
     * 
     * Sample class size is randomized 
     */
    public static void main(String[] args) {
        
        //Question Class instance
        Question q = new Question();
        q.setQuestion("How many ounces are in a pound?");
        
        //5 Option multiple choice
        q.setOptions(5);
        q.present();
        
        
        Random r = new Random();
        //Class size random
        int s = r.nextInt(30) + 2;
        Students ClassA = new Students(s);
        ClassA.vote(q.getRes());
        
        System.out.println("Out of " + s + " students:");
        q.results();
    }
    

    
}
