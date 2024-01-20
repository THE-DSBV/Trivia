//Author: Duncan Volk
//Date: January 12, 2022
//This class displays the instructions for the game. 

    //Import the awt, awt.event, and swing libraries.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    //Create the Instructions class
public class Instructions extends JPanel implements ActionListener
{
        //Declare integer variables to hold the y-values of the images and their velocities
    int y = 0;
    int y2 = 518;
    int velocity1 = 1;
    int velocity2 = 1;
        //Create a new instance of the Timer class
    Timer timer = new Timer(10, this);
        //Declare String variables to hold the instructions. 
    String instructions1 = "Once you have clicked 'Start Game',";
    String instructions2 = "click 'Generate Question' to start playing.";
    String instructions3 = "You will have 30 seconds to enter an";
    String instructions4 = "answer and press 'Check Answer'.";
    String instructions5 = "Correct answers earn 1 point.";
    String instructions6 = "If you don't know an answer,";
    String instructions7 = "You may click 'Hint' to show a hint.";
    String instructions8 = "Using 'Hint' will cost 0.5 points";
    String instructions9 = "Incorrect answers or running out";
    String instructions10 = "of time will end the game";
    String instructions11 = "Do not include articles like 'the', 'a'";
    String instructions12 = "or 'an' in your answer. Write";
    String instructions13 = "numerical answers in number form (ie. 1)";
    String instructions14 = "Close this page by clicking the red X,";
    String instructions15 = "or minimize it to refer to while you play.";
        //This class creates and displays the JFrame
    public void display()
    {
        Instructions in = new Instructions();
        JFrame f=new JFrame("Instructions");
        JPanel panel = (JPanel) f.getContentPane();
        f.setSize(700,800);
        f.add(in);
        f.setVisible(true);
    }
        //This class creates and adds the images and instructions
     public void paint(Graphics g)
     {
        super.paint(g);
            //Create the images
        ImageIcon i=new ImageIcon("qMark.png");
        i.paintIcon(this,g,-50,y);
        ImageIcon i2=new ImageIcon("qMark.png");
        i2.paintIcon(this,g,500,y2);
        g.setFont(new Font("Ink Free", Font.BOLD, 20));
            //Start the timer
        timer.start();
            //Output the instructions
        g.drawString("Instructions", 290, 50);
        g.setFont(new Font("Ink Free", Font.BOLD, 14));
        g.drawString(instructions1, 235, 100);
        g.drawString(instructions2, 235, 125);
        g.drawString(instructions3, 235, 160);
        g.drawString(instructions4, 235, 185);
        g.drawString(instructions5, 235, 220);
        g.drawString(instructions6, 235, 245);
        g.drawString(instructions7, 235, 270);
        g.drawString(instructions8, 235, 295);
        g.drawString(instructions9, 235, 330);
        g.drawString(instructions10, 235, 355);
        g.drawString(instructions11, 235, 390);
        g.drawString(instructions12, 235, 415);
        g.drawString(instructions13, 235, 440);
        g.drawString(instructions14, 235, 475);
        g.drawString(instructions15, 235, 500);
    }
        //This method controls the animation of the images
    public void actionPerformed(ActionEvent e)
    {
            //These two if statements make sure that the images stay within the JFrame
        if(y>518||y<0)
        {
        velocity1 =- velocity1;
        }
        if(y2>518||y2<0)
        {
        velocity2 =- velocity2;
        }
            //Update the y-values to move the images
        y = y + velocity1;
        y2 = y2 + velocity2;
            //Repaint the images
        repaint();
    }
}