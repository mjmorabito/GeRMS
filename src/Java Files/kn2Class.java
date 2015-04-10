

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author searomg
 */
public class kn2Class {
    
    private ArrayList<String> sequence;
    private ArrayList <String> answerChoices = new ArrayList<>();
    //private ArrayList <Integer> answersOut = new ArrayList<>();
    private int correctAnswer;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    
    
    public kn2Class() {
         //initialize the sequence to zeros
        sequence = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sequence.add(""+i);
        }
    }
    
    public int getQuestion() {
        
        //sequence.removeAll(sequence);
        answerChoices.removeAll(answerChoices);
        
        Random randomQuestion = new Random();

        //correctAnswer = randomQuestion.nextInt(10);
        
        shuffleList(sequence);
        
        correctAnswer = Integer.parseInt(sequence.get(0));
        
        removefromsequence();
        
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
    
    private void removefromsequence(){
        for (int i=0; i<sequence.size();i++)
        {
            if (correctAnswer == Integer.parseInt(sequence.get(i))){
                sequence.remove(i);
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
