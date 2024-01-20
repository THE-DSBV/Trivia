import java.util.*;
public class TestingStuff
{
    public static void main(String[]args)
    {
        //testing arraylist for highscores PROBABLY WON"T WORK BECAUSE ARRAYLIST WILL RESET
        Scanner sc = new Scanner(System.in);
        //ArrayList<Integer> scores = new ArrayList<Integer>();
        
        //testing storing questions/answers in 2d array WORKS!!!
        String[][]q = {
                    {"Q1", "A1"},
                    {"Q2","A2"}
                    };
        int random = (int)Math.floor(Math.random()*(1-0+1)+0);
        System.out.println(q[random][0]);
        String answer = sc.nextLine();
        if(answer.equals(q[random][1]))
        {
            System.out.println("correct");
        }
        else
        {
            System.out.println(q[random][1]);
        }
    }
}
