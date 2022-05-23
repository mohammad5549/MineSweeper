import java.awt.*;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
       /* Board b = new Board(2);
        b.generateBombs();
        b.generateNumber(0, 0);
        String[][] board = b.getBoard();
        for (String[] x: board)
        {
            System.out.println(Arrays.toString(x));
        }
        //UserInterface.setupGui();*/


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(625, 500);
        frame.setLayout(new GridLayout(8, 10, 2, 2));

        for (int i = 1; i <= 80; i++){
            JButton button = new JButton("");
            if (i % 2 == 0) {
                button.setBackground(Color.GRAY);
            }
            else {
                button.setBackground(Color.DARK_GRAY);
            }
            frame.add(button);
        }

        /*frame.add(new JButton("1"));
        frame.add(new JButton("2"));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));
        frame.add(new JButton(""));*/

        frame.setVisible(true);

    }
}
