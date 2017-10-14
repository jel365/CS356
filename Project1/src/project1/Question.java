package project1;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author James
 */
public class Question {
    int s;
    private String question;
    private int[] res;
    private String[] options;
    
    public void setQuestion(String q){
        question = q;
    }
    
    //Takes user input to fill in options
    
    public void setOptions(int size){
        s = size;
        res = new int[size];
        options = new String[size];
        Scanner keyboard = new Scanner(System.in);
        for(int i = 0; i < options.length; i++){
            System.out.println("Option " + (i+1));
            String inp = keyboard.nextLine();
            options[i] = inp;
        }
    }
    public int[] getRes(){
        return res;
    }
         
    //Presents question prompt to be answered
    public void present()
    {
        System.out.println(question);
        char c = 'A';
        for(int j = 0; j < options.length; j++)
        {   
            System.out.println(c + ". " + options[j]);
            c++;
        }
    }
    
    //Presents result in easy to read format
    public void results()
           
    {
         System.out.println("Results:");
         char d = 'A';
        for(int k = 0; k < res.length; k++){
            
            System.out.println(d + ": " + res[k]);
            d++;
        }
    }
  
    
    
    
    
}
