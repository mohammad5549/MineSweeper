import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener, MouseListener {

    JButton level1;
    JButton level2;
    JButton level3;
    Board board;
    JButton[][] buttons;
    ImageIcon flag = new ImageIcon("flag.png");

    public MyFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(625, 500);

        level1 = new JButton("Level 1");
        level1.setBounds(250, 100, 100, 50);
        this.add(level1);
        level1.addActionListener(this);
        level1.setFocusable(false);

        level2 = new JButton("Level 2");
        level2.setBounds(250, 200, 100, 50);
        this.add(level2);
        level2.addActionListener(this);
        level2.setFocusable(false);

        level3 = new JButton("Level 3");
        level3.setBounds(250, 300, 100, 50);
        this.add(level3);
        level3.addActionListener(this);
        level3.setFocusable(false);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == level1) {
            board = new Board(1);
            board.generateBombs();
            board.generateNumber(0, 0);
            buttons = new JButton[8][10];
            this.remove(level1);
            this.remove(level2);
            this.remove(level3);
            this.invalidate();
            this.validate();
            this.repaint();
            this.setLayout(new GridLayout(8, 10));
            for (int i = 0; i < 8; i++) {
                for (int x = 0; x < 10; x++) {
                    JButton button = new JButton("");
                    button.setBorder(BorderFactory.createEtchedBorder());
                    button.addMouseListener(this);
                    buttons[i][x] = button;
                    button.setBackground(Color.DARK_GRAY);
                    this.add(button);
                }
            }
            this.setVisible(true);
        }
        else if (e.getSource() == level2) {
            board = new Board(2);
            board.generateBombs();
            board.generateNumber(0, 0);
            buttons = new JButton[14][18];
            this.remove(level1);
            this.remove(level2);
            this.remove(level3);
            this.invalidate();
            this.validate();
            this.repaint();
            this.setLayout(new GridLayout(14, 18));
            for (int i = 0; i < 14; i++) {
                for (int x = 0; x < 18; x++) {
                    JButton button = new JButton("");
                    button.setBorder(BorderFactory.createEtchedBorder());
                    button.addMouseListener(this);
                    buttons[i][x] = button;
                    button.setBackground(Color.DARK_GRAY);
                    this.add(button);
                }
            }
            this.setVisible(true);
        }
        else if (e.getSource() == level3) {
            board = new Board(3);
            board.generateBombs();
            board.generateNumber(0, 0);
            buttons = new JButton[20][24];
            this.remove(level1);
            this.remove(level2);
            this.remove(level3);
            this.invalidate();
            this.validate();
            this.repaint();
            this.setLayout(new GridLayout(20, 24));
            for (int i = 0; i < 20; i++) {
                for (int x = 0; x < 24; x++) {
                    JButton button = new JButton("");
                    button.setBorder(BorderFactory.createEtchedBorder());
                    button.addMouseListener(this);
                    buttons[i][x] = button;
                    button.setBackground(Color.DARK_GRAY);
                    this.add(button);
                }
            }
            this.setVisible(true);
        }



    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < buttons.length; i++){
            for (int x = 0; x < buttons[i].length; x++){
                if (e.getSource() == buttons[i][x]){
                    row = i;
                    col = x;
                }
            }
        }
        if (e.getButton() == MouseEvent.BUTTON1){
            /*int row = 0;
            int col = 0;
            for (int i = 0; i < buttons.length; i++){
                for (int x = 0; x < buttons[i].length; x++){
                    if (e.getSource() == buttons[i][x]){
                        row = i;
                        col = x;
                    }
                }
            }*/
            if (board.getBoard()[row][col].equals("X"))
            {
                for (int i = 0; i < buttons.length; i++){
                    for (int x = 0; x < buttons[i].length; x++){
                        this.remove(buttons[i][x]);
                    }
                }
                this.invalidate();
                this.validate();
                this.repaint();
            }
            else if (board.getBoard()[row][col].equals("0")){
                revealAlgorithm(row, col);
            }
            else{
                buttons[row][col].setBackground(Color.GRAY);
                buttons[row][col].setText(board.getBoard()[row][col]);
                buttons[row][col].setFocusable(false);
            }
        }
        else if (e.getButton() == MouseEvent.BUTTON3){
            /*int row = 0;
            int col = 0;
            for (int i = 0; i < buttons.length; i++){
                for (int x = 0; x < buttons[i].length; x++){
                    if (e.getSource() == buttons[i][x]){
                        row = i;
                        col = x;
                    }
                }
            }*/

            buttons[row][col].setText("X");
            buttons[row][col].setForeground(Color.RED);
            buttons[row][col].setFocusable(false);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void revealAlgorithm(int row, int col){
        buttons[row][col].setBackground(Color.GRAY);
        if (row == 0 && col == 0){
            if (board.getBoard()[row][col + 1].equals("0")){
                revealAlgorithm(row, col + 1);
            }
            else {
                buttons[row][col + 1].setBackground(Color.GRAY);
                buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
            }
            if (board.getBoard()[row + 1][col + 1].equals("0")){
                revealAlgorithm(row + 1, col + 1);
            }
            else {
                buttons[row + 1][col + 1].setBackground(Color.GRAY);
                buttons[row + 1][col + 1].setText(board.getBoard()[row + 1][col + 1]);
            }
            if (board.getBoard()[row + 1][col].equals("0")) {
                revealAlgorithm(row + 1, col);
            }
            else {
                buttons[row + 1][col].setBackground(Color.GRAY);
                buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
            }
        }
        else if (row == 0 && col == board.getBoard()[0].length - 1){
            if (board.getBoard()[row][col - 1].equals("0")){
                revealAlgorithm(row, col - 1);
            }
            else {
                buttons[row][col - 1].setBackground(Color.GRAY);
                buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
            }
            if (board.getBoard()[row + 1][col - 1].equals("0")){
                revealAlgorithm(row + 1, col - 1);
            }
            else {
                buttons[row + 1][col - 1].setBackground(Color.GRAY);
                buttons[row + 1][col - 1].setText(board.getBoard()[row + 1][col - 1]);
            }
            if (board.getBoard()[row + 1][col].equals("0")){
                revealAlgorithm(row + 1, col);
            }
            else {
                buttons[row + 1][col].setBackground(Color.GRAY);
                buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
            }
        }
        else if (row == board.getBoard().length - 1 && col == 0){
            if (board.getBoard()[row - 1][col].equals("0")){
                revealAlgorithm(row - 1, col);
            }
            else {
                buttons[row - 1][col].setBackground(Color.GRAY);
                buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
            }
            if (board.getBoard()[row - 1][col + 1].equals("0")){
                revealAlgorithm(row - 1, col + 1);
            }
            else {
                buttons[row - 1][col + 1].setBackground(Color.GRAY);
                buttons[row - 1][col + 1].setText(board.getBoard()[row - 1][col + 1]);
            }
            if (board.getBoard()[row][col + 1].equals("0")){
                revealAlgorithm(row, col + 1);
            }
            else {
                buttons[row][col + 1].setBackground(Color.GRAY);
                buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
            }

        }
        else if (row == board.getBoard().length - 1 && col == board.getBoard()[0].length - 1){
            if (board.getBoard()[row - 1][col].equals("0")){
                revealAlgorithm(row - 1, col);
            }
            else {
                buttons[row - 1][col].setBackground(Color.GRAY);
                buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
            }
            if (board.getBoard()[row - 1][col - 1].equals("0")){
                revealAlgorithm(row - 1, col - 1);
            }
            else {
                buttons[row - 1][col - 1].setBackground(Color.GRAY);
                buttons[row - 1][col - 1].setText(board.getBoard()[row - 1][col - 1]);
            }
            if (board.getBoard()[row][col - 1].equals("0")){
                revealAlgorithm(row, col - 1);
            }
            else {
                buttons[row][col - 1].setBackground(Color.GRAY);
                buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
            }
        }
        else if (row == 0){
            if (board.getBoard()[row][col - 1].equals("0")){
                revealAlgorithm(row, col - 1);
            }
            else {
                buttons[row][col - 1].setBackground(Color.GRAY);
                buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
            }
            if (board.getBoard()[row + 1][col - 1].equals("0")){
                revealAlgorithm(row + 1, col - 1);
            }
            else {
                buttons[row + 1][col - 1].setBackground(Color.GRAY);
                buttons[row + 1][col - 1].setText(board.getBoard()[row + 1][col - 1]);
            }
            if (board.getBoard()[row + 1][col].equals("0")){
                revealAlgorithm(row + 1, col);
            }
            else {
                buttons[row + 1][col].setBackground(Color.GRAY);
                buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
            }
            if (board.getBoard()[row + 1][col + 1].equals("0")){
                revealAlgorithm(row + 1, col + 1);
            }
            else {
                buttons[row + 1][col + 1].setBackground(Color.GRAY);
                buttons[row + 1][col + 1].setText(board.getBoard()[row + 1][col + 1]);
            }
            if (board.getBoard()[row][col + 1].equals("0")){
                revealAlgorithm(row, col + 1);
            }
            else {
                buttons[row][col + 1].setBackground(Color.GRAY);
                buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
            }
        }
        else if (col == 0){
            if (board.getBoard()[row - 1][col].equals("0")){
                revealAlgorithm(row - 1, col);
            }
            else {
                buttons[row - 1][col].setBackground(Color.GRAY);
                buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
            }
            if (board.getBoard()[row - 1][col + 1].equals("0")){
                revealAlgorithm(row - 1, col + 1);
            }
            else {
                buttons[row - 1][col + 1].setBackground(Color.GRAY);
                buttons[row - 1][col + 1].setText(board.getBoard()[row - 1][col + 1]);
            }
            if (board.getBoard()[row][col + 1].equals("0")){
                revealAlgorithm(row, col + 1);
            }
            else {
                buttons[row][col + 1].setBackground(Color.GRAY);
                buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
            }
            if (board.getBoard()[row + 1][col + 1].equals("0")){
                revealAlgorithm(row + 1, col + 1);
            }
            else {
                buttons[row + 1][col + 1].setBackground(Color.GRAY);
                buttons[row + 1][col + 1].setText(board.getBoard()[row + 1][col + 1]);
            }
            if (board.getBoard()[row + 1][col].equals("0")){
                revealAlgorithm(row + 1, col);
            }
            else {
                buttons[row + 1][col].setBackground(Color.GRAY);
                buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
            }
        }
        else if (row == board.getBoard().length - 1){
            if (board.getBoard()[row][col - 1].equals("0")){
                revealAlgorithm(row, col - 1);
            }
            else {
                buttons[row][col - 1].setBackground(Color.GRAY);
                buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
            }
            if (board.getBoard()[row - 1][col - 1].equals("0")){
                revealAlgorithm(row - 1, col - 1);
            }
            else {
                buttons[row - 1][col - 1].setBackground(Color.GRAY);
                buttons[row - 1][col - 1].setText(board.getBoard()[row - 1][col - 1]);
            }
            if (board.getBoard()[row - 1][col].equals("0")){
                revealAlgorithm(row - 1, col);
            }
            else {
                buttons[row - 1][col].setBackground(Color.GRAY);
                buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
            }
            if (board.getBoard()[row - 1][col + 1].equals("0")){
                revealAlgorithm(row - 1, col + 1);
            }
            else {
                buttons[row - 1][col + 1].setBackground(Color.GRAY);
                buttons[row - 1][col + 1].setText(board.getBoard()[row - 1][col + 1]);
            }
            if (board.getBoard()[row][col + 1].equals("0")){
                revealAlgorithm(row, col + 1);
            }
            else {
                buttons[row][col + 1].setBackground(Color.GRAY);
                buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
            }
            //------------------Left off here--------------------------//

        }
        /*
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
        }*/
    }

}

