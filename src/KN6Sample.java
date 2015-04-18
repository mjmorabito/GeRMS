import java.util.ArrayList;
import java.util.Random;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryan Ahearn
 */
public class KN6Sample {
    
    //array to hold values of pictures for the problems, 0-12 (ascends on difficulty)
    private ArrayList<String> Sequence;
    
    //array to hold possible answer
    private ArrayList<String> AnsArray = new ArrayList<String>();
    
     private int correctAnswer;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String ans5;
    private String ans6;
    
    private final String qustion = "The name of this coin(s) is? ";
    Random rand = new Random();
    
     public KN6Sample(){
        //initializing the Problem array with zeroes
       Sequence = new ArrayList<>();
       for( int i=0; i<13;i++){
            
            Sequence.add(""+i);
        }    
    }
    
       //get Easy Question  Penny Nickel or Dime
    public int getEQuestion(){
        AnsArray.removeAll(AnsArray);
        
        shuffleList(Sequence, 0, 2);
        correctAnswer = Integer.parseInt(Sequence.get(0));
        removefromsequence();
        
        ans1 = correctAnswer + "";
        AnsArray.add("" + correctAnswer);
        
       int goodWrongAnswer = rand.nextInt(3);
       
       //while loop to check for duplicate wrong answers
       while(goodWrongAnswer == Integer.parseInt(ans1) || 
               AlreadyInSequence(goodWrongAnswer))
       {
           goodWrongAnswer = rand.nextInt(3);
       }
    //wrong answer hasn't been used, so store in the Array
    ans2 = goodWrongAnswer + "";
    AnsArray.add(ans2);
    
    goodWrongAnswer = rand.nextInt(3);
     while(goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2)
              || AlreadyInSequence(goodWrongAnswer))
       {
           goodWrongAnswer = rand.nextInt(3);
       }
    //wrong answer hasn't been used, so store in the Array
    ans3 = goodWrongAnswer + "";
    AnsArray.add(ans3);
    
        //Randomizes the buttons
        shuffleList(AnsArray, 0, 2);
        ans1 = AnsArray.get(0);
        ans2 = AnsArray.get(1);
        ans3 = AnsArray.get(2);
        
        
        return correctAnswer;
    }
    
    //Get Medium Question  All Coins
    public int getMQuestion(){
        AnsArray.removeAll(AnsArray);
        
        shuffleList(Sequence, 0, 3);
        correctAnswer = Integer.parseInt(Sequence.get(0));
        removefromsequence();
        
        ans1 = correctAnswer + "";
        AnsArray.add("" + correctAnswer);
        
       int goodWrongAnswer = rand.nextInt(4);
       
       //while loop to check for duplicate wrong answers
       while(goodWrongAnswer == Integer.parseInt(ans1) || 
               AlreadyInSequence(goodWrongAnswer))
       {
           goodWrongAnswer = rand.nextInt(4);
       }
    //wrong answer hasn't been used, so store in the Array
    ans2 = goodWrongAnswer + "";
    AnsArray.add(ans2);
    
    goodWrongAnswer = rand.nextInt(4);
     while(goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2)
              || AlreadyInSequence(goodWrongAnswer))
       {
           goodWrongAnswer = rand.nextInt(4);
       }
    //wrong answer hasn't been used, so store in the Array
    ans3 = goodWrongAnswer + "";
    AnsArray.add(ans3);
    
    while (goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2)
                || goodWrongAnswer == Integer.parseInt(ans3) || AlreadyInSequence(goodWrongAnswer)) {
            goodWrongAnswer = rand.nextInt(4);
        }
        ans4 = goodWrongAnswer + "";
        AnsArray.add(ans4);
        
        //Randomizes the buttons
        shuffleList(AnsArray,0,3);
        ans1 = AnsArray.get(0);
        ans2 = AnsArray.get(1);
        ans3 = AnsArray.get(2);
        ans4 = AnsArray.get(3);
        
        return correctAnswer;
    }
    
    //Get Hard Question
     public int getHQuestion(){
        AnsArray.removeAll(AnsArray);
        
        shuffleList(Sequence, 4, 9);
        correctAnswer = Integer.parseInt(Sequence.get(0));
        removefromsequence();
        
        ans1 = correctAnswer + "";
        AnsArray.add("" + correctAnswer);
        
       int goodWrongAnswer = rand.nextInt(6)+4;
       
       //while loop to check for duplicate wrong answers
       while(goodWrongAnswer == Integer.parseInt(ans1) || 
               AlreadyInSequence(goodWrongAnswer))
       {
           goodWrongAnswer = rand.nextInt(6)+4;
       }
    //wrong answer hasn't been used, so store in the Array
    ans2 = goodWrongAnswer + "";
    AnsArray.add(ans2);
    
    goodWrongAnswer = rand.nextInt(6)+4;
     while(goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2)
              || AlreadyInSequence(goodWrongAnswer))
       {
           goodWrongAnswer = rand.nextInt(6)+4;
       }
    //wrong answer hasn't been used, so store in the Array
    ans3 = goodWrongAnswer + "";
    AnsArray.add(ans3);
    
    while (goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2)
                || goodWrongAnswer == Integer.parseInt(ans3) || AlreadyInSequence(goodWrongAnswer)) {
            goodWrongAnswer = rand.nextInt(13);
        }
        ans4 = goodWrongAnswer + "";
        AnsArray.add(ans4);
        
        
        while (goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2)
                || goodWrongAnswer == Integer.parseInt(ans3) || goodWrongAnswer == Integer.parseInt(ans4)
                || AlreadyInSequence(goodWrongAnswer)) {
            goodWrongAnswer = rand.nextInt(5)+7;
        }
        ans5 = goodWrongAnswer + "";
        AnsArray.add(ans5);
        //Randomizes the buttons
        shuffleList(AnsArray, 4, 9);
        ans1 = AnsArray.get(0);
        ans2 = AnsArray.get(1);
        ans3 = AnsArray.get(2);
        ans4 = AnsArray.get(3);
        return correctAnswer;
    }
    
    public boolean getAnswer(int a)
    {
        return  false;
    }
    
    private void removefromsequence()
    {
        
        for (int i = 0; i< Sequence.size();i++) 
        {
            if (correctAnswer == Integer.parseInt(Sequence.get(i)))
            {
                Sequence.remove(i);
            }
            
        }
        
    }
    //Iterates through the array to shuffle all contents
    public static void shuffleList(ArrayList<String> a, int start, int end)
    {
        int n = end;
        Random ran = new Random();
       
        for(int i = start; i<n; i++)
        {
            int change = i + ran.nextInt(n - i);
            swap(a, i, change);
        }
    }
    
    //Swaps the values of two array indexes
    private static void swap(ArrayList<String> a, int i, int change)
    {
        String helper = a.get(i);
        a.set(i, a.get(change));
        a.set(change, helper);
    }
    
    //Looks for duplicates in the sequence
    private boolean AlreadyInSequence(int number)
    {
        boolean indicator = false;
        for(int i=0; i<AnsArray.size()-1; i++)
        {
            if(number == Integer.parseInt(AnsArray.get(i)))
                indicator = true;
            
        }
        return indicator;
    }
    
    public String getAns1()
  {
      return ans1;
  }
  public String getAns2()
  {
      return ans2;
  }

  public String getAns3()
  {
      return ans3;
  }

  public String getAns4()
  {
      return ans4;
  }
    
}
