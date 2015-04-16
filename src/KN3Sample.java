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
public class KN3Sample {
    
    
    //need to implement, assign images to number values?
    
    
    //array to hold values of pictures for the problems, 0-12 (ascends on difficulty)
    private ArrayList<String> Sequence;
    
    //array to hold possible answer
    private ArrayList<String> AnsArray = new ArrayList<String>();
    
    //TODO: figure out why arraylist isn't working. 
    
    /*AnsArray.add(0,"first");
    AnsArray.add(1,"second");
    AnsArray.add(2,"third");
    AnsArray.add(3,"fourth");
    AnsArray.add(4,"fifth");
    
    */
   
    private int correctAnswer;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String ans5;
    
    
    
    
    
    
    
    private final String question ="What position is Iggy in?";
    
   
    Random rand = new Random();
    private final int medPtr = 3;
    private final int hardPtr = 7;
    private final int easyList = 3;
    private final int medList = 4;
    private final int hardList = 5;
    
   // private int ans1, ans2, ans3, ans4;
    /*
    private int questE;
    private int questM;
    private int questH;
    private int ePicVal;
    private int mPicVal;
    private int hPicVal;
    */
    
    public KN3Sample(){
        //initializing the Problem array with zeroes
       Sequence = new ArrayList<>();
       for( int i=0; i<13;i++){
            
            Sequence.add(""+i);
        }    
    }
     //get Easy Question
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
    
    //Get Medium Question
    public int getMQuestion(){
        AnsArray.removeAll(AnsArray);
        
        shuffleList(Sequence, 3, 6);
        correctAnswer = Integer.parseInt(Sequence.get(0));
        removefromsequence();
        
        ans1 = correctAnswer + "";
        AnsArray.add("" + correctAnswer);
        
       int goodWrongAnswer = rand.nextInt(4)+3;
       
       //while loop to check for duplicate wrong answers
       while(goodWrongAnswer == Integer.parseInt(ans1) || 
               AlreadyInSequence(goodWrongAnswer))
       {
           goodWrongAnswer = rand.nextInt(4)+3;
       }
    //wrong answer hasn't been used, so store in the Array
    ans2 = goodWrongAnswer + "";
    AnsArray.add(ans2);
    
    goodWrongAnswer = rand.nextInt(4)+3;
     while(goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2)
              || AlreadyInSequence(goodWrongAnswer))
       {
           goodWrongAnswer = rand.nextInt(4)+3;
       }
    //wrong answer hasn't been used, so store in the Array
    ans3 = goodWrongAnswer + "";
    AnsArray.add(ans3);
    
    while (goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2)
                || goodWrongAnswer == Integer.parseInt(ans3) || AlreadyInSequence(goodWrongAnswer)) {
            goodWrongAnswer = rand.nextInt(4)+3;
        }
        ans4 = goodWrongAnswer + "";
        AnsArray.add(ans4);
        
        //Randomizes the buttons
        shuffleList(AnsArray, 3 , 6);
        ans1 = AnsArray.get(0);
        ans2 = AnsArray.get(1);
        ans3 = AnsArray.get(2);
        ans4 = AnsArray.get(3);
        
        return correctAnswer;
    }
    
    //Get Hard Question
     public int getHQuestion(){
        AnsArray.removeAll(AnsArray);
        
        shuffleList(Sequence, 7, 11);
        correctAnswer = Integer.parseInt(Sequence.get(0));
        removefromsequence();
        
        ans1 = correctAnswer + "";
        AnsArray.add("" + correctAnswer);
        
       int goodWrongAnswer = rand.nextInt(5)+7;
       
       //while loop to check for duplicate wrong answers
       while(goodWrongAnswer == Integer.parseInt(ans1) || 
               AlreadyInSequence(goodWrongAnswer))
       {
           goodWrongAnswer = rand.nextInt(5)+7;
       }
    //wrong answer hasn't been used, so store in the Array
    ans2 = goodWrongAnswer + "";
    AnsArray.add(ans2);
    
    goodWrongAnswer = rand.nextInt(5)+7;
     while(goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2)
              || AlreadyInSequence(goodWrongAnswer))
       {
           goodWrongAnswer = rand.nextInt(5)+7;
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
        shuffleList(AnsArray, 7, 11);
        ans1 = AnsArray.get(0);
        ans2 = AnsArray.get(1);
        ans3 = AnsArray.get(2);
        ans4 = AnsArray.get(3);
        ans5 = AnsArray.get(4);
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
    
  /*public void InitializeProblems(){
        //initializes all answers back to 0
        questE= 0;
        ePicVal= 0;
        
        questM=0;
        mPicVal =0;
        
        questH=0;
        hPicVal=0;
        
    }
    
    public void Assignment(){
        
        questE= rand.nextInt(easyList);
        ePicVal= questE;
        
        questM=rand.nextInt(medList)+medPtr;
        mPicVal = questM;
        
        questH=rand.nextInt(hardList)+hardPtr;
        hPicVal = questH;
        
    }
    
  */
}
