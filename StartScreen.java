//Author: Duncan Volk
//Date: January 12, 2022
//This class acts as the starting screen of the game. It allows users to look at the 
//instructions, start the game, or close the game. 

    //Import the awt, awt.event, and swing libraries.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    //Create the StartScreen class
public class StartScreen extends JPanel
{
        //Main method
        //This method creates the GUI and all its elements 
    public static void main (String[] args)
    {
            //Create an instance of the class and all of the GUI elements
        StartScreen start = new StartScreen();
        JFrame f=new JFrame("Start");
        JButton btnStartGame = new JButton("Start Game");
        JButton btnInstructions = new JButton("Instructions");
        JButton btnCloseGame = new JButton("Close Game");
        JLabel lblTitle = new JLabel("Trivia Game");
        JPanel panel = (JPanel) f.getContentPane();
        
            //Add the different elements to the JPanel and set their attributes
        panel.add(lblTitle);
        lblTitle.setSize(150,25);
        lblTitle.setBounds(115, 20, 180, 25);
        lblTitle.setFont(new Font("Ink Free", Font.BOLD, 20));
        
        panel.add(btnStartGame);
        btnStartGame.setSize(150,25);
        btnStartGame.setBounds(105, 80, 150, 25);
        btnStartGame.setFont(new Font("Ink Free", Font.BOLD, 15));
        btnStartGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    //Create an instance of the TriviaGame class
                TriviaGame t = new TriviaGame();
                    //Close the StartScreen JFrame
                f.dispose();
            }
        });
        panel.add(btnInstructions);
        btnInstructions.setSize(150,25);
        btnInstructions.setBounds(105, 120, 150, 25);
        btnInstructions.setFont(new Font("Ink Free", Font.BOLD, 15));
        btnInstructions.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    //Create an instance of the Instructions class
                Instructions i = new Instructions();
                    //Call the display method
                i.display();
            }
        });
        panel.add(btnCloseGame);
        btnCloseGame.setSize(150,25);
        btnCloseGame.setBounds(105, 160, 150, 25);
        btnCloseGame.setFont(new Font("Ink Free", Font.BOLD, 15));
        btnCloseGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                closeGame();
            }
        });
        f.setSize(350,400);
        f.add(start);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        //This method closes the game
    public static void closeGame()
    {
            //Close the game
        System.exit(0);
    }
}