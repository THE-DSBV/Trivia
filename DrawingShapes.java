import java.awt.*;
import javax.swing.*;

public class DrawingShapes extends JPanel
{

public static void main(String[]args)
{
JFrame frame=new JFrame("This is my painting frame");
DrawingShapes ds=new DrawingShapes();
//frame.getContentPane().add(ds);
frame.add(ds);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(600,400);
frame.setBackground(Color.yellow);
frame.setVisible(true);

}

public void paint(Graphics g)
{
//drawing rectangles
//g.fillRect(int x,int y, int width, int height);
g.setColor(Color.red);
g.fillRect(50,50,100,50);
g.setColor(Color.black);

g.drawRect(50,125,100,50);
//drawing oval
//g.fillOval(int x,int y, int width, int height);
g.setColor(Color.black);
g.fillOval(50,200, 100,50);
g.drawOval(50,275, 100,50);
//creating polygons
g.setColor(Color.red);
int[]x={250,300,350,400,350,300,250};
int[]y={100,50,50,100,150,150,100};
g.fillPolygon(x,y,6);
g.setColor(Color.black);
int[]x2={250,300,350,400,350,300,250};
int[]y2={225,175,175,225,275,275,225};
g.drawPolygon(x2,y2,6);
//drawing lines
g.drawLine(250,350,400,300);
//creating arcs
//g.fillArc(int x,int y,int widthj, int height, int startingangle, int arcAngle);
g.fillArc(450,50,100,100,45,135);
g.drawArc(450,150,100,100,45,135);
//writing on the frame
g.setColor(Color.blue);
Font f=new Font("Courier",Font.PLAIN,36);
g.setFont(f);
g.drawString("These are my drawings",100,400);

}
}