//Author: Duncan Volk
//Date: January 2, 2022
//This class outputs the end of game information and allows the user to play again or close the game
    
    //Import the required inbuilt java libraries
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.*;
    //Create the GameOver class as a child class of the StartScreen class
public class GameOver extends StartScreen
{
        //Create all of the GUI elements
    JFrame frame = new JFrame("Game Over");
    JPanel panel = (JPanel) frame.getContentPane();
    JLabel lblGameOver = new JLabel();
    JLabel lblEndGame = new JLabel();
    JLabel lblRank = new JLabel();
    JLabel lblHighScore = new JLabel();
    JLabel lblPointsOff = new JLabel();
    JButton btnNewGame = new JButton("New Game");
    JButton btnClose = new JButton("Close Game");   
        //This method sets the attributes of all the GUI methods and displays them
    public GameOver()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        
        panel.add(lblGameOver);
        lblGameOver.setSize(180,25);
        lblGameOver.setBounds(150, 50, 180, 25);
        lblGameOver.setFont(new Font("Ink Free", Font.BOLD, 15));
        
        panel.add(lblEndGame);
        lblEndGame.setSize(250,25);
        lblEndGame.setBounds(110, 100, 250, 25);
        lblEndGame.setFont(new Font("Ink Free", Font.BOLD, 15));
        
        panel.add(lblRank);
        lblRank.setSize(240,25);
        lblRank.setBounds(87, 130, 250, 25);
        lblRank.setFont(new Font("Ink Free", Font.BOLD, 15));
        
        panel.add(lblHighScore);
        lblHighScore.setSize(180,25);
        lblHighScore.setBounds(137, 160, 180, 25);
        lblHighScore.setFont(new Font("Ink Free", Font.BOLD, 15));
        
        panel.add(btnNewGame);
        btnNewGame.setSize(180,25);
        btnNewGame.setBounds(105, 210, 180, 25);
        btnNewGame.setFont(new Font("Ink Free", Font.BOLD, 15));
        btnNewGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    //Close the JFrame
                frame.dispose();
                    //Create a new object of the TriviaGame class
                TriviaGame game = new TriviaGame();
            }
        });
        
        panel.add(btnClose);
        btnClose.setSize(180,25);
        btnClose.setBounds(105, 235, 180, 25);
        btnClose.setFont(new Font("Ink Free", Font.BOLD, 15));
        btnClose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    //call the close game method from the StartScreen class
                closeGame();
            }
        });
        
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(100, 100, 100));
    }
        //This method outputs all the end of game information
    public void endGame(String highScore, String rank, String indicator, boolean gameOver)
    {
            //Check if the user lost the game
        if(gameOver == false)
        {
                //Set the background colour to green
            panel.setBackground(new Color(51, 255, 51));
        }
        else
        {
                //Set the background colour to red
            panel.setBackground(new Color(255, 51, 51));
                //Output a game over message
            lblGameOver.setText("GAME OVER");
        }       
            //Output how the user won/lost the game, their rank, and the all time highscore
        lblEndGame.setText(indicator);
        lblRank.setText(rank);
        lblHighScore.setText(highScore);
    }
}