/*
 * Team name: GeRMS
 * Team members: Gustavo Moraes, Ryan Ahearn, Mark Morabito, and Samir Leal
 * Date: 04/08/15
 * Purpose: The client requested a math tutoring software for elementary school children.
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * This Class is for the KN2 class and contains the logic for the standard.
 */
public class kn2Class {
    
    private ArrayList<String> sequence;
    private ArrayList<String> easy;
    private ArrayList<String> medium;
    private ArrayList<String> hard;
    private ArrayList <String> answerChoices = new ArrayList<>();
    //private ArrayList <Integer> answersOut = new ArrayList<>();
    private int correctAnswer;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    
    
    public kn2Class() {
         //initialize the sequence to zeros
        easy = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            easy.add(""+i);
        }
        
        medium = new ArrayList<>();
        for (int i = 3; i < 6; i++) {
            medium.add(""+i);
        }
        
        hard = new ArrayList<>();
        for (int i = 7; i < 10; i++) {
            hard.add(""+i);
        }
        
        sequence = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sequence.add(""+i);
        }
    }
    
    public int getQuestion(int difficulty) {
        
        //sequence.removeAll(sequence);
        answerChoices.removeAll(answerChoices);
        
        Random randomQuestion = new Random();

        //correctAnswer = randomQuestion.nextInt(10);
        
        //shuffleList(sequence);
        //correctAnswer = Integer.parseInt(sequence.get(0));
        
        switch (difficulty){
            case 1:
                shuffleList(easy);
                correctAnswer = Integer.parseInt(easy.get(0));
                removefromsequence(easy);
                break;
            case 2:
                shuffleList(medium);
                correctAnswer = Integer.parseInt(medium.get(0));
                removefromsequence(medium);
                break;
            case 3:
                shuffleList(hard);
                correctAnswer = Integer.parseInt(hard.get(0));
                removefromsequence(hard);
                break;
        }
        
        
        ans1 = correctAnswer + "";
        answerChoices.add(""+correctAnswer);
        
        
        int goodWrongAnswer = randomQuestion.nextInt(10);
        //System.out.println("The correct answer is " + goodWrongAnswer);
        while (goodWrongAnswer == Integer.parseInt(ans1) || isNumberAlreadyInTheSequence(goodWrongAnswer)) {
            goodWrongAnswer = randomQuestion.nextInt(10);
        }
        ans2 = goodWrongAnswer + "";
        answerChoices.add(ans2);
        
        goodWrongAnswer = randomQuestion.nextInt(10);
        while (goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2) 
                || isNumberAlreadyInTheSequence(goodWrongAnswer)) {
            goodWrongAnswer = randomQuestion.nextInt(10);
        }
        ans3 = goodWrongAnswer + "";
        answerChoices.add(ans3);
        
        while (goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2)
                || goodWrongAnswer == Integer.parseInt(ans3) || isNumberAlreadyInTheSequence(goodWrongAnswer)) {
            goodWrongAnswer = randomQuestion.nextInt(10);
        }
        ans4 = goodWrongAnswer + "";
        answerChoices.add(ans4);
        
        //Randomize the buttons
        shuffleList(answerChoices);
        ans1 = answerChoices.get(0);
        ans2 = answerChoices.get(1);
        ans3 = answerChoices.get(2);
        ans4 = answerChoices.get(3);

        return correctAnswer;
    }
    
    public boolean getAnswer(int a){
        
        return false;
    }
    
    private void removefromsequence(ArrayList<String> a){
        for (int i=0; i<a.size();i++)
        {
            if (correctAnswer == Integer.parseInt(a.get(i))){
                a.remove(i);
            }
        }
    }
    
    public static void shuffleList(ArrayList<String> a) {
        int n = a.size();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < n; i++) {
          int change = i + random.nextInt(n - i);
          swap(a, i, change);
        }
    }
    private static void swap(ArrayList<String> a, int i, int change) {
        String helper = a.get(i);
        a.set(i, a.get(change));
        a.set(change, helper);
    }
    
    //Used to determine if the number is already in the sequence 
  private boolean isNumberAlreadyInTheSequence(int number)
  {
      boolean indicator = false;
      for(int i = 0; i < answerChoices.size()-1; i++)
      {
         if(number == Integer.parseInt(answerChoices.get(i)))
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
