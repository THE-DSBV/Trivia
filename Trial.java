import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

public class Trial extends JFrame {
    JPanel p1, p2, p3;
    JLabel l1, l2, l3, l4, l5, l6;

    Trial() {
        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.setBackground(Color.gray);
        p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.setBackground(Color.yellow);
        p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.setBackground(Color.pink);
        l1 = new JLabel("Hello");
        l2 = new JLabel("Hi");
        l3 = new JLabel("Welcome");
        l4 = new JLabel("Bye");
        l5 = new JLabel("Visit again");
        l6 = new JLabel("Thanks");
        p1.add(l1, BorderLayout.NORTH);
        p1.add(l2, BorderLayout.CENTER);
        p2.add(l3, BorderLayout.CENTER);
        p2.add(l4, BorderLayout.SOUTH);
        p3.add(l5, BorderLayout.NORTH);
        p3.add(l6, BorderLayout.SOUTH);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Trial t = new Trial();
        t.setSize(500, 500);
        t.setVisible(true);
    }
}