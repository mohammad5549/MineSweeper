import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Board b = new Board(1);
        b.generateBombs();
        b.generateNumber(0, 0);
        String[][] board = b.getBoard();
        for (String[] x: board)
        {
            System.out.println(Arrays.toString(x));
        }

    }
}
