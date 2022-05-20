public class Board {

    String[][] board;
    String level;
    int bombs;
    int planted;

    public String[][] getBoard()
    {
        return board;
    }

    public Board(int level)
    {
        if (level == 1)
        {
            board = new String[8][10];
            bombs = 10;
        }
        else if (level == 2)
        {
            board = new String[14][18];
            bombs = 40;
        }
        else
        {
            board = new String[20][24];
            bombs = 100;
        }
        planted = 0;
    }

    public void generateBombs()
    {
        while (planted < bombs)
        {
            int randomRow = (int) (Math.random() * board.length);
            int randomCol = (int) (Math.random() * board[0].length);
            if (board[randomRow][randomCol] != null)
            {
                while (board[randomRow][randomCol] != null)
                {
                    randomRow = (int) (Math.random() * board.length);
                    randomCol = (int) (Math.random() * board[0].length);
                }
            }
            board[randomRow][randomCol] = "X";
            planted++;
        }
        for (int i = 0; i < board.length; i++){
            for (int x = 0; x < board[i].length; x++){
                if (board[i][x] == null){
                    board[i][x] = "0";
                }
            }
        }
    }

    public void generateNumber(int row, int col) throws ArrayIndexOutOfBoundsException
    {
        if (board[row][col].equals("X"))
        {
            try
            {
                generateNumber(row, col + 1);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                if (row < board.length - 1)
                {
                    generateNumber(row + 1, 0);
                }
            }
        }
        else
        {
            int perimeter = 0;
            if (row == 0 && col == 0){
                if (board[row][col + 1].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col + 1].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col].equals("X")) {
                    perimeter++;
                }
                board[row][col] = "" + perimeter;
                generateNumber(row, col + 1);
            }
            else if (row == 0 && col == board[0].length - 1){
                if (board[row][col - 1].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col - 1].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col].equals("X")){
                    perimeter++;
                }
                board[row][col] = "" + perimeter;
                generateNumber(row + 1, 0);
            }
            else if (row == board.length - 1 && col == 0){
                if (board[row - 1][col].equals("X")){
                    perimeter++;
                }
                if (board[row - 1][col + 1].equals("X")){
                    perimeter++;
                }
                if (board[row][col + 1].equals("X")){
                    perimeter++;
                }
                board[row][col] = "" + perimeter;
                generateNumber(row, col + 1);
            }
            else if (row == board.length - 1 && col == board[0].length - 1){
                if (board[row - 1][col].equals("X")){
                    perimeter++;
                }
                if (board[row - 1][col - 1].equals("X")){
                    perimeter++;
                }
                if (board[row][col - 1].equals("X")){
                    perimeter++;
                }
                board[row][col] = "" + perimeter;
            }
            else if (row == 0){
                if (board[row][col - 1].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col - 1].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col + 1].equals("X")){
                    perimeter++;
                }
                if (board[row][col + 1].equals("X")){
                    perimeter++;
                }
                board[row][col] = "" + perimeter;
                generateNumber(row, col + 1);
            }
            else if (col == 0){
                if (board[row - 1][col].equals("X")){
                    perimeter++;
                }
                if (board[row - 1][col + 1].equals("X")){
                    perimeter++;
                }
                if (board[row][col + 1].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col + 1].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col].equals("X")){
                    perimeter++;
                }
                board[row][col] = "" + perimeter;
                generateNumber(row, col + 1);
            }
            else if (row == board.length - 1){
                if (board[row][col - 1].equals("X")){
                    perimeter++;
                }
                if (board[row - 1][col - 1].equals("X")){
                    perimeter++;
                }
                if (board[row - 1][col].equals("X")){
                    perimeter++;
                }
                if (board[row - 1][col + 1].equals("X")){
                    perimeter++;
                }
                if (board[row][col + 1].equals("X")){
                    perimeter++;
                }
                board[row][col] = "" + perimeter;
                generateNumber(row, col + 1);
            }
            else if (col == board[0].length - 1){
                if (board[row - 1][col].equals("X")){
                    perimeter++;
                }
                if (board[row - 1][col - 1].equals("X")){
                    perimeter++;
                }
                if (board[row][col - 1].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col - 1].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col].equals("X")){
                    perimeter++;
                }
                board[row][col] = "" + perimeter;
                generateNumber(row + 1, 0);
            }
            else {
                if (board[row - 1][col - 1].equals("X")){
                    perimeter++;
                }
                if (board[row - 1][col].equals("X")){
                    perimeter++;
                }
                if (board[row - 1][col + 1].equals("X")){
                    perimeter++;
                }
                if (board[row][col + 1].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col + 1].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col].equals("X")){
                    perimeter++;
                }
                if (board[row + 1][col - 1].equals("X")){
                    perimeter++;
                }
                if (board[row][col - 1].equals("X")){
                    perimeter++;
                }
                board[row][col] = "" + perimeter;
                generateNumber(row, col + 1);
            }

        }

    }
}
