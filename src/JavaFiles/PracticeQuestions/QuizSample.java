
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author markmorabito
 */
public class QuizSample {

    private ArrayList<Integer> sequence;
    ArrayList <String> answerChoices = new ArrayList<>();
    private String ans1;
    private String ans2;
    private String ans3;
    private String ans4;
    private String question;
    private String numberList;
    private int start;
    private int correctAnswer;

    public QuizSample() {
         //initialize the sequence to zeros
        numberList = "";
        sequence = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            sequence.add(0);
        }

    }
/**
    public static void main(String[]args)
    {
        QuizSample q = new QuizSample();
        q.initializeElements();
    }
    * */
    
    
    
    public void initializeElements(int difficulty) {
        
        if (answerChoices.size() > 0) {
            for (int i = 3; i >= 0; i--) {
                answerChoices.remove(i);
            }
        }

        //First make every element zero
        ans1="";
        ans2="";
        ans3="";
        ans4="";
        question="";
        numberList="";
        start=0;
        correctAnswer=0;
        
        
       
        Random randomGenerator = new Random();
        //create a random integer betwen 1 and 26
        //scales the random number by the difficulty level
        System.out.println("WE are in the Quiz Sample Q: " + difficulty);
        start = difficulty*(randomGenerator.nextInt(10) + 1) + (difficulty - 1) * 10; //System.out.println("Starting number is " + start);
        System.out.println("XXXXStart is " + start);
        System.out.println("Quiz Sample part 1");
        //generates a list of 6 numbers that will be visible to choose from
        //adds them to the sequence of visible numbers 
        for (int i = 0; i < 7; i++) {
            //populate the first seven elements of the random number sequence
            sequence.set(i, start + i); 
        }
        System.out.println("Quiz Sample part 2");
        //pick a random entry to be the questionmark in the sequence
        int questionNumber = randomGenerator.nextInt(5) + 1;
        //make the correct answer be where the sequence started plus the random number
        correctAnswer = questionNumber + start; 
        System.out.println("Correct answer is : " + correctAnswer);
        //set the correct answer to -1 as a flag
        sequence.set(questionNumber, -1); 
        question = questionNumber + "";
        System.out.println("Quiz Sample part 3");
        //print out the elements with appropriate commas and the ? on the correct answer
        for (int i = 1; i < 6; i++) {
            //System.out.println("The ith elt of sequence is " + sequence.get(i)) ; 
            if (sequence.get(i) == -1 && i != 5) {
                numberList = numberList + " ? , ";
            } else if (sequence.get(i) == -1) {
                numberList = numberList + " ? ";
            } else if (i != 5) {
                numberList = numberList + sequence.get(i) + " , ";
            } else {
                numberList = numberList + sequence.get(i);
            }
        }
       System.out.println("Quiz Sample part 4");
        //store the correct answer in answer1 as a String
        ans1 = correctAnswer + "";
       
        System.out.println("Quiz Sample part 5");
        //store random numbers in the three other answer choices
        //make sure that they are unique
        
        
        int goodWrongAnswer = randomGenerator.nextInt(correctAnswer) + 10;
        //System.out.println("The correct answer is " + goodWrongAnswer);
        while (goodWrongAnswer == Integer.parseInt(ans1) || isNumberAlreadyInTheSequence(goodWrongAnswer)) {
            System.out.println("First while in Q");
            goodWrongAnswer = randomGenerator.nextInt(correctAnswer) + 10;
        }

        ans2 = goodWrongAnswer + "";
        goodWrongAnswer = randomGenerator.nextInt(correctAnswer) + 20;
        while (goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2) || isNumberAlreadyInTheSequence(goodWrongAnswer)) {
            System.out.println("2nd while in Q");
            goodWrongAnswer = randomGenerator.nextInt(correctAnswer) + 20;
        }
        ans3 = goodWrongAnswer + "";
        while (goodWrongAnswer == Integer.parseInt(ans1) || goodWrongAnswer == Integer.parseInt(ans2)
                || goodWrongAnswer == Integer.parseInt(ans3) || isNumberAlreadyInTheSequence(goodWrongAnswer)) {
            System.out.println("3rd while in Q");
            goodWrongAnswer = randomGenerator.nextInt(correctAnswer) +30;
        }

        ans4 = goodWrongAnswer + "";
        
        //Put into an arraylist and shuffle elements randomy
        //ArrayList <String> answerChoices = new ArrayList<>();
        System.out.println("The answers are " + " " + ans1 + " " +  ans2 + " " + ans3 + " " + ans4);
        answerChoices.add(ans1);
        answerChoices.add(ans2);
        answerChoices.add(ans3);
        answerChoices.add(ans4);
        System.out.println("Size is " + answerChoices.size());
        
        System.out.println("The answers are " + " " + answerChoices.get(0) + " " +  answerChoices.get(1) + " " + answerChoices.get(2) + " " + answerChoices.get(3));
        
        //Randomize the buttons
        answerChoices = shuffleList(answerChoices);
        ans1 = answerChoices.get(0);
        ans2 = answerChoices.get(1);
        ans3 = answerChoices.get(2);
        ans4 = answerChoices.get(3);
        System.out.println("The answers AFTER  are " + " " + ans1 + " " +  ans2 + " " + ans3 + " " + ans4);
        
    }
    
    //Shuffles and returns an arraylist of strings so that the answer choices are rearranged
    public ArrayList<String>  shuffleList(ArrayList<String> a) {
   
      //Creates random numbers 
       Random random = new Random();
       int randomNum = random.nextInt(4);
       
       //Create a new arraylist to store the new random numbers
       ArrayList <String> b = new ArrayList<>();
       
       
       //Adds a random index of array A to array B
       b.add(a.get(randomNum));
       
       int randomNum2 = random.nextInt(4);
       while(randomNum == randomNum2)
       {
           randomNum2 = random.nextInt(4);
       }
       b.add(a.get(randomNum2));
       
       int randomNum3 = random.nextInt(4);
       while(randomNum == randomNum3 || randomNum2 == randomNum3)
       {
          randomNum3 = random.nextInt(4); 
       }
       b.add(a.get(randomNum3));
       
       int randomNum4 = random.nextInt(4);
       while(randomNum == randomNum4 || randomNum2 == randomNum4 ||randomNum4 == randomNum3)
       {
          randomNum4 = random.nextInt(4); 
       }
       b.add(a.get(randomNum4));
      
       //Store the new array, B,  in the array A that will be returned
       a = b;
       return a;
       
       }
         
   
  public void setElementsBackToZero()
  {
      ans1="";
        ans2="";
        ans3="";
        ans4="";
        question="";
        numberList="";
        start=0;
        correctAnswer=0;
        numberList = "";
  }
  
  //Used to determine if the number is already in the sequence 
  private boolean isNumberAlreadyInTheSequence(int number)
  {
      boolean indicator = false;
      for(int i = 0; i < sequence.size()-1; i++)
      {
         if(number == sequence.get(i))
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
  
  public String getNumberList()
  {
      return numberList;
  }

  public int getCorrectAnswer()
  {
      return correctAnswer;
  }
    public ArrayList <String> getChoices()
    {
       return answerChoices; 
    }
    public String getImage()
  {
      return numberList;
  }

}
