import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;
public class MovingBall extends JPanel implements ActionListener
{
int x=0;
int y=0;
int velx=2;
int vely=3;
Timer time=new Timer(10,this);
public static void main (String[] args)
{

MovingBall m=new MovingBall();
JFrame f=new JFrame("Moving Ball");
f.setBackground(Color.BLUE);
f.setSize(500,400);
f.setVisible(true);

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.add(m);

}
public void paint(Graphics g)
{
super.paint(g);
g.setColor(Color.red);
g.fillOval(x,y,50,50);
time.start();

}
public void actionPerformed(ActionEvent e)
{
if(x>450||x<0);
{
velx=-velx;
}
if(y>350||y<0);
{
vely=-vely;
}
x=x+velx;
y=y+vely;

repaint();

}
}