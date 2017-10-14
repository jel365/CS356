package project1;


import java.util.Random;


public class Students {
    private int size;
    public Students(int size){
        this.size = size;
    }
    
    
    /*
    receive parameter of result array from question
    
    based on size of class, run for loop choosing random location representing 
    choice
    
    increment integer in location indicating vote cast for that choice
    */
    public void vote(int[]r)
    {
        Random v = new Random();
        for(int i = 0; i < size; i++){
           
        int  a = v.nextInt(r.length);
        r[a]++;
        }
    }
}
