//Author: Duncan Volk
//Date: 16/Dec/2021
//This class contains the main functionality of the Trivia Game and a JFrame to display it.

//Import the util, awt,awt event, io, and swing java libraries 
import java.util.*;
//I imported these awt libraries seperately to avoid ambiguity issues later on
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.Timer;
import java.io.*;

    //Create the TriviaGame class
public class TriviaGame extends JFrame
{     
        //Create all of the GUI elements
    JFrame frame = new JFrame("Trivia Game");
    JPanel panel = (JPanel) frame.getContentPane();
    JLabel lblHeading = new JLabel("Trivia Game");
    JLabel lblQuestion = new JLabel("");
    JButton btnGenerate = new JButton("Generate Question");
    JTextField txtAnswer = new JTextField();
    JButton btnCheck = new JButton("Check Your Answer");
    JLabel lblIndicator = new JLabel();
    JLabel lblTimer = new JLabel("Timer");
    JButton btnHint = new JButton("Hint");
    JLabel lblHint = new JLabel();
    JLabel lblScore = new JLabel("Score:");
    JLabel lblScoreNum = new JLabel("0.0");
    JLabel lblError = new JLabel();
    
        //Declare a 2 Dimenstional String array to hold the questions, answers, and hints
    String[][]questions ={{"What animal is on the Porsche logo?", "horse","4 legged mammal"},
    {"What year did World War 1 start?","1914","Year ends with 4"},{"What year did World War 2 start?","1939","Year ends with 9"},
    {"What is Earth’s largest continent?", "asia", "Has 4.5 billion people"},{"Which state is Area 51 located in?","nevada","Capital is Carson City"},
    {"What shape is often used for stop signs?","octagon","Sum of interior angles is 1080°"},{"In what country is Lake Bled?","slovenia","Capital is Ljubljana"},
    {"What is the national animal of Scotland?","unicorn","Mythical creature"},{"What is the name of Poland in Polish?","polska","Ends with 'ka'"},
    {"What is the shortest '-ology' word?","oology","Related to birds"},{"What is Japanese sake made from?","rice","It's a grain"},
    {"How many ribs are in a human body?","24","multiple of 4"},{"What is the world’s largest island?","greenland","Has a misleading name"},
    {"What color eyes do most humans have?","brown","It's not on the rainbow"},{"What is the rarest M&M color?","brown","Not on the rainbow"},
    {"How many eyes does a bee have?","5","Prime number"},{"Which mammal has no vocal cords?","giraffe","Native to Africa"},{"What was the first US state?","delaware","Very small state"},
    {"What is the national dish of Spain?","paella","Rice dish"},{"What year did the Cold War end?","1989","Year ends with 9"},
    {"What is the driest continent?","antarctica","Least populus continent"},{"What was Babe Ruth's first name?","george","Starts with 'G'"},
    {"What color is a polar bear’s skin?","black","It's not white"},{"Botany is the study of what?","plants","Certain organic structures"},
    {"What is a hockey puck made from?","rubber","Is used in tires"}};  
        //Declare an integer Arraylist to store the index of questions that have already been used
    ArrayList<Integer> usedQuestions = new ArrayList<Integer>();
        //Declare an integer variable to hold a random number
    int random = (int)Math.floor(Math.random()*25);
        //Declare a double variable to hold the user's score
    double score;
        //Instantiate the timer
    Timer timer;
        //Declare an ArrayList to hold all the scores taken from a text file
    ArrayList<Double> scores = new ArrayList<Double>();
        //Declare a String to hold the highscore message
    String highScore;
        //Declare a String to hold the rank message
    String rank;
        //Declare a String to hold the indicator of why the user won or lost
    String indicator;
        //Declare a boolean variable for whether the user lost
    boolean lost;
        //Declare a double array to hold all the scores
    double[]allScores;
        //Declare an integer variable to hold the value that the timer will count down from
    int counter = 30;
        //This method creates all of the GUI components and adds them to a JFrame
    TriviaGame()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
            //Add the different elements to the JPanel and set their attributes
        panel.add(lblHeading);
        lblHeading.setSize(185,25);
        lblHeading.setBounds(235, 25, 185, 30);
        lblHeading.setFont(new Font("Ink Free", Font.BOLD, 20));
        lblHeading.setForeground(Color.WHITE);
        
        panel.add(btnGenerate);
        btnGenerate.setSize(180,25);
        btnGenerate.setBounds(210, 150, 180, 25);
        btnGenerate.setFont(new Font("Ink Free", Font.BOLD, 15));
        btnGenerate.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    //Call the method that will generate a question
                generateQuestion();
            }
        });
        
        panel.add(lblQuestion);
        lblQuestion.setSize(320,25);
        lblQuestion.setBounds(180, 175, 320, 25);
        lblQuestion.setFont(new Font("Ink Free", Font.BOLD, 15));
        lblQuestion.setForeground(Color.WHITE);
        
        panel.add(txtAnswer);
        txtAnswer.setSize(180,25);
        txtAnswer.setBounds(210, 210, 180, 25);
        txtAnswer.setFont(new Font("Ink Free", Font.BOLD, 15));
        
        panel.add(btnCheck);
        btnCheck.setSize(180,25);
        btnCheck.setBounds(210, 250, 180, 25);
        btnCheck.setFont(new Font("Ink Free", Font.BOLD, 15));
        btnCheck.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    //Call the method that will check if the user's answer is correct
                checkAnswer();
            }
        });
        
        panel.add(lblIndicator);
        lblIndicator.setSize(180,25);
        lblIndicator.setBounds(255, 285, 180, 25);
        lblIndicator.setFont(new Font("Ink Free", Font.BOLD, 15));
        lblIndicator.setForeground(Color.WHITE);
        
        panel.add(lblTimer);
        lblTimer.setSize(180,25);
        lblTimer.setBounds(260, 405, 180, 25);
        lblTimer.setFont(new Font("Ink Free", Font.BOLD, 15));
        lblTimer.setForeground(Color.WHITE);
        
        panel.add(btnHint);
        btnHint.setSize(150,25);
        btnHint.setBounds(220, 330, 150, 25);
        btnHint.setFont(new Font("Ink Free", Font.BOLD, 15));
        btnHint.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    //Call the method that will output a hint
                hint();
            }
        });
        
        panel.add(lblHint);
        lblHint.setSize(280,25);
        lblHint.setBounds(220, 360, 280, 25);
        lblHint.setFont(new Font("Ink Free", Font.BOLD, 15));
        lblHint.setForeground(Color.WHITE);
        
        panel.add(lblScore);
        lblScore.setSize(180,25);
        lblScore.setBounds(240, 445, 180, 25);
        lblScore.setFont(new Font("Ink Free", Font.BOLD, 15));
        lblScore.setForeground(Color.WHITE);
        
        panel.add(lblScoreNum);
        lblScoreNum.setSize(180,25);
        lblScoreNum.setBounds(297, 445, 180, 25);
        lblScoreNum.setFont(new Font("Ink Free", Font.BOLD, 15));
        lblScoreNum.setForeground(Color.WHITE);
        
        panel.add(lblError);
        lblError.setSize(210,25);
        lblError.setBounds(210, 485, 210, 25);
        lblError.setFont(new Font("Ink Free", Font.BOLD, 15));
        lblError.setForeground(Color.WHITE);
        
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(0, 0, 0));
    }
        //This method outputs a question
    public void generateQuestion()
    {
            //Make sure the timer hasn't started yet (to prevent the user from repeatedly generating questions)
        if(counter == 30)
        {
                //Start the timer
            timer();
                //Reset the timer's font colour
            lblTimer.setForeground(Color.WHITE);
                //Make the answer box editable
            txtAnswer.setEditable(true);
                //Reset the hint, error, and indicator JLabels
            lblHint.setText("");
            lblError.setText("");
            lblIndicator.setText("");
                //Output a random question
            lblQuestion.setText(questions[random][0]);
                //Add the question to the list of used questions
            usedQuestions.add(random);
        }
        else
        {
                //Output an error message
            lblError.setText("Answer Current Question");
        }
    }
        //This method checks whether the user's answer was correct and performs related functions
    public void checkAnswer()
    {
            //Get the user's answer, convert it to lowercase and remove all spaces
        String answer = txtAnswer.getText();
        answer = answer.toLowerCase();
        answer = answer.replaceAll(" ", "");
            //Check whether the user entered an answer
        if(answer.equals(""))
        {
                //Output an error message
            lblError.setText("Please enter an answer");
        }
            //Check whether the user tried to answer before generating a question
        else if(lblQuestion.getText().equals(""))
        {
                //Output an error message
            lblError.setText("Please generate a question");
        }
        else
        {
                //Clear the answer box and make it uneditable to prevent user exploits
            txtAnswer.setText("");
            txtAnswer.setEditable(false);
                //Reset the inidcator's font colour
            lblIndicator.setForeground(Color.BLACK);
                //Reset the error message
            lblError.setText("");
                //Stop the timer and reset the counter
            stopTimer();
            counter = 30;
                //Check if the answer was correct
            if(answer.equals(questions[random][1]))
            {
                    //Output a message indicating that the answer was correct.
                lblIndicator.setForeground(Color.GREEN);
                lblIndicator.setText("Correct");
                    //Increase and output the user's score
                score = score + 1;
                lblScoreNum.setText(String.valueOf(score));

            }
            else
            {
                    //Output a message indicating that the answer was incorrect
                lblIndicator.setText("Incorrect");
                    //Set the indicator and lost variables' values
                indicator = "    Incorrect Answer";
                lost = true;
                    //Call the gameOver method.
                gameOver();
                    //Exit the checkAnswer method
                return;
            }
                //Check whether all the questions have been used
            if(usedQuestions.size() < questions.length)
            {
                    //Generate an unused random question
                do
                {
                    random = (int)Math.floor(Math.random()*25);
                }
                while(usedQuestions.contains(random));
            }
            else
            {
                    //set the indicator and lost variables' values
                indicator = "All questions answered!"; 
                lost = false;
                    //Call the gameOver method
                gameOver();
            }
        }
    }
        //This method outputs a hint
    public void hint()
    {
            //Check if the user is trying to output a hint at an appropriate time
        if(lblQuestion.getText() == questions[random][0] && lblHint.getText() == "")
        {
                //Output the hint
            lblHint.setText(questions[random][2]);
                //Decrease the user's score and output its new value
            score = score - 0.5;
            lblScoreNum.setText(String.valueOf(score));
        }
    }
        //This method runs and outputs the 30 second timer to answer a question
    public void timer(){
            //Create an object of the TimerTask class
        TimerTask task = new TimerTask(){
        @Override
            //This method runs the timer
        public void run(){
                //Check whether the timer is above 0
            if(counter > 0){
                    //Output the remaining time and decrease the value of the counter
                lblTimer.setText("  " + String.valueOf(counter));
                counter--;
                    //Check if the timer has reached set times to change the colour of the timer's text
                if(counter == 9)
                {
                    lblTimer.setForeground(Color.YELLOW);
                }
                if(counter == 4)
                {
                    lblTimer.setForeground(Color.RED);
                }
            }
            else{
                    //Output that the user ran out of time
                lblTimer.setText("Time is up");
                    //cancel the timer
                timer.cancel();
                    //Set the indicator and lost variables' values
                indicator = "You ran out of time!";
                lost = true;
                    //Call the gameOver method
                gameOver();
            }
        }   
        };
            //Create a new instance of the timer that counts down by 1 second
        this.timer = new Timer();
        int period = 1000;
        this.timer.schedule(task, 0, period);
    }
        //This method stops the timer
    public void stopTimer(){
        try{
                // Cancel the timer.
            this.timer.cancel();
        }
        catch(NullPointerException e){
                // Output an error message if the user performed an action that would cancel the timer before they started the timer. 
            lblError.setText("Please generate a question before checking your answer");
        }
    }
        //This method runs through endgame functionality and calls the GameOver class
    public void gameOver()
    {
            //Call the getScores method
        getScores();
            //Convert the scores ArrayList to an array
        allScores = scores.stream().mapToDouble(Double::doubleValue).toArray();
            //call the sort method
        sort(allScores, allScores.length);
            //Call the findRank method
        findRank();
            //Call the highScore method
        highScore();
            //Create a new object of the GameOver class and call the endGame method
        GameOver end = new GameOver();
        end.endGame(highScore, rank, indicator, lost);
            //Close the JFrame
        frame.dispose();
    }
        //This method accesses a text file that holds all the scores and adds them to an ArrayList
    public void getScores()
    {
            //Try to access the text file that holds the scores
        try{
                //Create a new object of the FileWriter class
            FileWriter fw = new FileWriter("scores.txt",true);  
                //Enter the user's score into text file and close the file
            fw.write("\n" + score);
            fw.close();
                //Open the file with a new onject of the Scanner class
            Scanner file = new Scanner(new File("scores.txt"));
                //While the file contains more scores, add the scores to an Arraylist
            while(file.hasNextDouble()) {
                scores.add(file.nextDouble());
            }
                //Close the file
            fw.close();
            
        }
        catch(IOException e)
        {
                //Output an error message
            lblError.setText("There was an issue acessing the high scores");
        }
        
    }
        //This method sorts the scores by size using recursion
    public void sort(double[]array, int n)
    {
            //Base case
        if (n == 1)
        {
            return;
        }
            //Sort the scores
        for (int i=0; i<n-1; i++)
            if (allScores[i] > allScores[i+1])
            {
                int temp = (int)allScores[i];
                allScores[i] = allScores[i+1];
                allScores[i+1] = temp;
            }
            //Recursive case
        sort(allScores, n-1);
    }
        //This method finds the user's rank out of all past players based on score
    public void findRank()
    {
            //Add the sorted scores to a List
        List<Double> list = new ArrayList<Double>();
        for(double num:allScores) {
            list.add(num);
        }
            //Reverse the list
        Collections.reverse(list);
            //Set the rank variable to a message containing the user's rank
        rank = "You placed "  + (list.lastIndexOf(score) + 1) + "/" + (allScores.length) + " players";
    }
        //This method finds the all time high score
    public void highScore()
    {
            //Set the highScore variable to a message containing the all time highscore
        highScore = "Highscore: " + (double)allScores[allScores.length-1];
    }
}