import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MineSweeperFrame extends JFrame implements ActionListener, MouseListener {

    JButton level1;
    JButton level2;
    JButton level3;
    Board board;
    JButton[][] buttons;
    ImageIcon flag = new ImageIcon("flag1.png");
    JPanel topPanel;
    JPanel bottomPanel;
    int flags;
    JButton flagCounter;
    JButton check;
    JButton status;

    public MineSweeperFrame(){



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(638, 612);

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
        topPanel = new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setBounds(0, 0, 625, 75);
        topPanel.setLayout(null);
        this.add(topPanel);


        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.setBounds(0, 75, 625, 500);
        bottomPanel.setLayout(null);
        this.add(bottomPanel);

        flagCounter = new JButton();
        flagCounter.setBackground(Color.GRAY);
        flagCounter.setBorder(BorderFactory.createEtchedBorder());
        flagCounter.setFont(new Font("Comic Sans", Font.BOLD, 20));
        flagCounter.setBounds(30, 13, 75, 50);
        topPanel.add(flagCounter);

        check = new JButton("CHECK");
        check.setBackground(Color.GREEN);
        check.setBorder(BorderFactory.createEtchedBorder());
        check.setFont(new Font("Comic Sans", Font.BOLD, 20));
        check.setForeground(Color.WHITE);
        check.setBounds(500, 13, 100, 50);
        topPanel.add(check);
        check.addMouseListener(this);

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

            flags = board.getBombs();

            flagCounter.setText("\uD83D\uDEA9  " + flags);
            flagCounter.setForeground(Color.RED);

            bottomPanel.setLayout(new GridLayout(8, 10));
            for (int i = 0; i < 8; i++) {
                for (int x = 0; x < 10; x++) {
                    JButton button = new JButton("");
                    button.setBorder(BorderFactory.createEtchedBorder());
                    button.addMouseListener(this);
                    buttons[i][x] = button;
                    button.setBackground(Color.DARK_GRAY);
                    bottomPanel.add(button);
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

            flags = board.getBombs();

            flagCounter.setText("\uD83D\uDEA9  " + flags);
            flagCounter.setForeground(Color.RED);

            bottomPanel.setLayout(new GridLayout(14, 18));
            for (int i = 0; i < 14; i++) {
                for (int x = 0; x < 18; x++) {
                    JButton button = new JButton("");
                    button.setBorder(BorderFactory.createEtchedBorder());
                    button.addMouseListener(this);
                    buttons[i][x] = button;
                    button.setBackground(Color.DARK_GRAY);
                    bottomPanel.add(button);
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

            flags = board.getBombs();

            flagCounter.setText("\uD83D\uDEA9  " + flags);
            flagCounter.setForeground(Color.RED);

            bottomPanel.setLayout(new GridLayout(20, 24));
            for (int i = 0; i < 20; i++) {
                for (int x = 0; x < 24; x++) {
                    JButton button = new JButton("");
                    button.setBorder(BorderFactory.createEtchedBorder());
                    button.addMouseListener(this);
                    buttons[i][x] = button;
                    button.setBackground(Color.DARK_GRAY);
                    bottomPanel.add(button);
                }
            }
            this.setVisible(true);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == check && flags == 0) {
            System.out.println("Win");
            for (int i = 0; i < buttons.length; i++){
                for (int x = 0; x < buttons[i].length; x++){
                    bottomPanel.remove(buttons[i][x]);
                }
            }
            this.invalidate();
            this.validate();
            this.repaint();
            status = new JButton("YOU WIN!");
            status.setBackground(Color.GREEN);
            status.setBounds(155, 175, 300, 100);
            status.setFont(new Font("Comic Sans", Font.BOLD, 40));
            bottomPanel.add(status);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
                        bottomPanel.remove(buttons[i][x]);
                    }
                }
                this.invalidate();
                this.validate();
                this.repaint();
                status = new JButton("YOU LOSE!");
                status.setBackground(Color.RED);
                status.setBounds(155, 175, 300, 100);
                status.setFont(new Font("Comic Sans", Font.BOLD, 40));
                bottomPanel.add(status);

            }
            else if (board.getBoard()[row][col].equals("0")){
                //revealAlgorithm(row, col, row, col);
                buttons[row][col].setBackground(Color.GRAY);
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
            if (buttons[row][col].getText().equals("\uD83D\uDEA9")) {
                buttons[row][col].setText("");
                buttons[row][col].setForeground(Color.BLACK);
                buttons[row][col].setFocusable(false);
                flags++;
                flagCounter.setText("\uD83D\uDEA9  " + flags);
            }
            else if (flags > 0) {
                buttons[row][col].setText("\uD83D\uDEA9");
                buttons[row][col].setForeground(Color.RED);
                buttons[row][col].setFocusable(false);
                flags--;
                flagCounter.setText("\uD83D\uDEA9  " + flags);
            }

        }
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

    public boolean checkWin(){
        for (int i = 0; i < buttons.length; i++){
            for (int x = 0; x < buttons[i].length; x++){
                if (!(buttons[i][x].getText().equals("\uD83D\uDEA9") && board.getBoard()[i][x].equals("X"))){
                    return false;
                }
            }
        }
        return true;
    }

    public void revealAlgorithm(int row, int col, int prevR, int prevC){
        buttons[row][col].setBackground(Color.GRAY);
        if (row == 0 && col == 0){
            if (!(row == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row][col + 1].equals("0")) {
                    revealAlgorithm(row, col + 1, row, col);
                }
                else {
                    buttons[row][col + 1].setBackground(Color.GRAY);
                    buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
                }
            }
            if (!(row + 1 == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row + 1][col + 1].equals("0")) {
                    revealAlgorithm(row + 1, col + 1, row, col);
                }
                else {
                    buttons[row + 1][col + 1].setBackground(Color.GRAY);
                    buttons[row + 1][col + 1].setText(board.getBoard()[row + 1][col + 1]);
                }
            }
            if (!(row + 1 == prevR && col == prevC)) {
                if (board.getBoard()[row + 1][col].equals("0")) {
                    revealAlgorithm(row + 1, col, row, col);
                }
                else {
                    buttons[row + 1][col].setBackground(Color.GRAY);
                    buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
                }
            }
        }
        else if (row == 0 && col == board.getBoard()[0].length - 1){
            if (!(row == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row][col - 1].equals("0")) {
                    revealAlgorithm(row, col - 1, row, col);
                }
                else {
                    buttons[row][col - 1].setBackground(Color.GRAY);
                    buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
                }
            }
            if (!(row + 1 == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row + 1][col - 1].equals("0")) {
                    revealAlgorithm(row + 1, col - 1, row, col);
                }
                else {
                    buttons[row + 1][col - 1].setBackground(Color.GRAY);
                    buttons[row + 1][col - 1].setText(board.getBoard()[row + 1][col - 1]);
                }
            }
            if (!(row + 1 == prevR && col == prevC)) {
                if (board.getBoard()[row + 1][col].equals("0")) {
                    revealAlgorithm(row + 1, col, row, col);
                }
                else {
                    buttons[row + 1][col].setBackground(Color.GRAY);
                    buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
                }
            }
        }
        else if (row == board.getBoard().length - 1 && col == 0){
            if (!(row - 1 == prevR && col == prevC)) {
                if (board.getBoard()[row - 1][col].equals("0")) {
                    revealAlgorithm(row - 1, col, row, col);
                }
                else {
                    buttons[row - 1][col].setBackground(Color.GRAY);
                    buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
                }
            }
            if (!(row - 1 == prevC && col + 1 == prevC)) {
                if (board.getBoard()[row - 1][col + 1].equals("0")) {
                    revealAlgorithm(row - 1, col + 1, row, col);
                }
                else {
                    buttons[row - 1][col + 1].setBackground(Color.GRAY);
                    buttons[row - 1][col + 1].setText(board.getBoard()[row - 1][col + 1]);
                }
            }
            if (!(row == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row][col + 1].equals("0")) {
                    revealAlgorithm(row, col + 1, row, col);
                }
                else {
                    buttons[row][col + 1].setBackground(Color.GRAY);
                    buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
                }
            }
        }
        else if (row == board.getBoard().length - 1 && col == board.getBoard()[0].length - 1){
            if (!(row - 1 == prevR && col == prevC)) {
                if (board.getBoard()[row - 1][col].equals("0")) {
                    revealAlgorithm(row - 1, col, row, col);
                }
                else {
                    buttons[row - 1][col].setBackground(Color.GRAY);
                    buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
                }
            }
            if (!(row - 1 == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row - 1][col - 1].equals("0")) {
                    revealAlgorithm(row - 1, col - 1, row, col);
                }
                else {
                    buttons[row - 1][col - 1].setBackground(Color.GRAY);
                    buttons[row - 1][col - 1].setText(board.getBoard()[row - 1][col - 1]);
                }
            }
            if (!(row == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row][col - 1].equals("0")) {
                    revealAlgorithm(row, col - 1, row, col);
                }
                else {
                    buttons[row][col - 1].setBackground(Color.GRAY);
                    buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
                }
            }
        }
        else if (row == 0){
            if (!(row == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row][col - 1].equals("0")) {
                    revealAlgorithm(row, col - 1, row, col);
                }
                else {
                    buttons[row][col - 1].setBackground(Color.GRAY);
                    buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
                }
            }
            if (!(row + 1 == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row + 1][col - 1].equals("0")) {
                    revealAlgorithm(row + 1, col - 1, row, col);
                }
                else {
                    buttons[row + 1][col - 1].setBackground(Color.GRAY);
                    buttons[row + 1][col - 1].setText(board.getBoard()[row + 1][col - 1]);
                }
            }
            if (!(row + 1 == prevR && col == prevC)) {
                if (board.getBoard()[row + 1][col].equals("0")) {
                    revealAlgorithm(row + 1, col, row, col);
                }
                else {
                    buttons[row + 1][col].setBackground(Color.GRAY);
                    buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
                }
            }
            if (!(row + 1 == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row + 1][col + 1].equals("0")) {
                    revealAlgorithm(row + 1, col + 1, row, col);
                }
                else {
                    buttons[row + 1][col + 1].setBackground(Color.GRAY);
                    buttons[row + 1][col + 1].setText(board.getBoard()[row + 1][col + 1]);
                }
            }
            if (!(row == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row][col + 1].equals("0")) {
                    revealAlgorithm(row, col + 1, row, col);
                }
                else {
                    buttons[row][col + 1].setBackground(Color.GRAY);
                    buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
                }
            }
        }
        else if (col == 0){
            if (!(row - 1 == prevR && col == prevC)) {
                if (board.getBoard()[row - 1][col].equals("0")) {
                    revealAlgorithm(row - 1, col, row, col);
                }
                else {
                    buttons[row - 1][col].setBackground(Color.GRAY);
                    buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
                }
            }
            if (!(row - 1 == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row - 1][col + 1].equals("0")) {
                    revealAlgorithm(row - 1, col + 1, row, col);
                }
                else {
                    buttons[row - 1][col + 1].setBackground(Color.GRAY);
                    buttons[row - 1][col + 1].setText(board.getBoard()[row - 1][col + 1]);
                }
            }
            if (!(row == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row][col + 1].equals("0")) {
                    revealAlgorithm(row, col + 1, row, col);
                }
                else {
                    buttons[row][col + 1].setBackground(Color.GRAY);
                    buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
                }
            }
            if (!(row + 1 == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row + 1][col + 1].equals("0")) {
                    revealAlgorithm(row + 1, col + 1, row, col);
                }
                else {
                    buttons[row + 1][col + 1].setBackground(Color.GRAY);
                    buttons[row + 1][col + 1].setText(board.getBoard()[row + 1][col + 1]);
                }
            }
            if (!(row + 1 == prevR && col == prevC)) {
                if (board.getBoard()[row + 1][col].equals("0")) {
                    revealAlgorithm(row + 1, col, row, col);
                }
                else {
                    buttons[row + 1][col].setBackground(Color.GRAY);
                    buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
                }
            }
        }
        else if (row == board.getBoard().length - 1){
            if (!(row == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row][col - 1].equals("0")) {
                    revealAlgorithm(row, col - 1, row, col);
                }
                else {
                    buttons[row][col - 1].setBackground(Color.GRAY);
                    buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
                }
            }
            if (!(row - 1 == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row - 1][col - 1].equals("0")) {
                    revealAlgorithm(row - 1, col - 1, row, col);
                }
                else {
                    buttons[row - 1][col - 1].setBackground(Color.GRAY);
                    buttons[row - 1][col - 1].setText(board.getBoard()[row - 1][col - 1]);
                }
            }
            if (!(row - 1 == prevR && col == prevC)) {
                if (board.getBoard()[row - 1][col].equals("0")) {
                    revealAlgorithm(row - 1, col, row, col);
                }
                else {
                    buttons[row - 1][col].setBackground(Color.GRAY);
                    buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
                }
            }
            if (!(row - 1 == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row - 1][col + 1].equals("0")) {
                    revealAlgorithm(row - 1, col + 1, row, col);
                }
                else {
                    buttons[row - 1][col + 1].setBackground(Color.GRAY);
                    buttons[row - 1][col + 1].setText(board.getBoard()[row - 1][col + 1]);
                }
            }
            if (!(row == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row][col + 1].equals("0")) {
                    revealAlgorithm(row, col + 1, row, col);
                }
                else {
                    buttons[row][col + 1].setBackground(Color.GRAY);
                    buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
                }
            }
        }
        else if (col == board.getBoard()[0].length - 1){
            if (!(row - 1 == prevR && col == prevC)) {
                if (board.getBoard()[row - 1][col].equals("0")) {
                    revealAlgorithm(row - 1, col, row, col);
                }
                else {
                    buttons[row - 1][col].setBackground(Color.GRAY);
                    buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
                }
            }
            if (!(row - 1 == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row - 1][col - 1].equals("0")) {
                    revealAlgorithm(row - 1, col - 1, row, col);
                }
                else {
                    buttons[row - 1][col - 1].setBackground(Color.GRAY);
                    buttons[row - 1][col - 1].setText(board.getBoard()[row - 1][col - 1]);
                }
            }
            if (!(row == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row][col - 1].equals("0")) {
                    revealAlgorithm(row, col - 1, row, col);
                }
                else {
                    buttons[row][col - 1].setBackground(Color.GRAY);
                    buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
                }
            }
            if (!(row + 1 == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row + 1][col - 1].equals("0")) {
                    revealAlgorithm(row + 1, col - 1, row, col);
                }
                else {
                    buttons[row + 1][col - 1].setBackground(Color.GRAY);
                    buttons[row + 1][col - 1].setText(board.getBoard()[row + 1][col - 1]);
                }
            }
            if (!(row + 1 == prevR && col == prevC)) {
                if (board.getBoard()[row + 1][col].equals("0")) {
                    revealAlgorithm(row + 1, col, row, col);
                }
                else {
                    buttons[row + 1][col].setBackground(Color.GRAY);
                    buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
                }
            }
        }
        else {
            if (!(row - 1 == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row - 1][col - 1].equals("0")) {
                    revealAlgorithm(row - 1, col - 1, row, col);
                }
                else {
                    buttons[row - 1][col - 1].setBackground(Color.GRAY);
                    buttons[row - 1][col - 1].setText(board.getBoard()[row - 1][col - 1]);
                }
            }
            if (!(row - 1 == prevR && col == prevC)) {
                if (board.getBoard()[row - 1][col].equals("0")) {
                    revealAlgorithm(row - 1, col, row, col);
                }
                else {
                    buttons[row - 1][col].setBackground(Color.GRAY);
                    buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
                }
            }
            if (!(row - 1 == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row - 1][col + 1].equals("0")) {
                    revealAlgorithm(row - 1, col + 1, row, col);
                }
                else {
                    buttons[row - 1][col + 1].setBackground(Color.GRAY);
                    buttons[row - 1][col + 1].setText(board.getBoard()[row - 1][col + 1]);
                }
            }
            if (!(row == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row][col + 1].equals("0")) {
                    revealAlgorithm(row, col + 1, row, col);
                }
                else {
                    buttons[row][col + 1].setBackground(Color.GRAY);
                    buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
                }
            }
            if (!(row + 1 == prevR && col + 1 == prevC)) {
                if (board.getBoard()[row + 1][col + 1].equals("0")) {
                    revealAlgorithm(row + 1, col + 1, row, col);
                }
                else {
                    buttons[row + 1][col + 1].setBackground(Color.GRAY);
                    buttons[row + 1][col + 1].setText(board.getBoard()[row + 1][col + 1]);
                }
            }
            if (!(row + 1 == prevR && col == prevC)) {
                if (board.getBoard()[row + 1][col].equals("0")) {
                    revealAlgorithm(row + 1, col, row, col);
                }
                else {
                    buttons[row + 1][col].setBackground(Color.GRAY);
                    buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
                }
            }
            if (!(row + 1 == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row + 1][col - 1].equals("0")) {
                    revealAlgorithm(row + 1, col - 1, row, col);
                }
                else {
                    buttons[row + 1][col - 1].setBackground(Color.GRAY);
                    buttons[row + 1][col - 1].setText(board.getBoard()[row + 1][col - 1]);
                }
            }
            if (!(row == prevR && col - 1 == prevC)) {
                if (board.getBoard()[row][col - 1].equals("0")) {
                    revealAlgorithm(row, col - 1, row, col);
                }
                else {
                    buttons[row][col - 1].setBackground(Color.GRAY);
                    buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
                }
            }
        }
    }

    /*public void revealAlgorithm(int row, int col){
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

        }
        else if (col == board.getBoard()[0].length - 1){
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
        else {
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
            if (board.getBoard()[row + 1][col - 1].equals("0")){
                revealAlgorithm(row + 1, col - 1);
            }
            else {
                buttons[row + 1][col - 1].setBackground(Color.GRAY);
                buttons[row + 1][col - 1].setText(board.getBoard()[row + 1][col - 1]);
            }
            if (board.getBoard()[row][col - 1].equals("0")){
                revealAlgorithm(row, col - 1);
            }
            else {
                buttons[row][col - 1].setBackground(Color.GRAY);
                buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
            }
        }
    }*/



    /*public void revealAlgorithm(int row, int col){
        buttons[row][col].setBackground(Color.GRAY);
        if (row == 0 && col == 0){
            if (board.getBoard()[row][col + 1].equals("0")){
                revealAlgorithm(row, col + 1);
            }
            if (board.getBoard()[row + 1][col + 1].equals("0")){
                revealAlgorithm(row + 1, col + 1);
            }
            if (board.getBoard()[row + 1][col].equals("0")) {
                revealAlgorithm(row + 1, col);
            }
            buttons[row][col + 1].setBackground(Color.GRAY);
            buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
            buttons[row + 1][col + 1].setBackground(Color.GRAY);
            buttons[row + 1][col + 1].setText(board.getBoard()[row + 1][col + 1]);
            buttons[row + 1][col].setBackground(Color.GRAY);
            buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
        }
        else if (row == 0 && col == board.getBoard()[0].length - 1){
            if (board.getBoard()[row][col - 1].equals("0")){
                revealAlgorithm(row, col - 1);
            }
            if (board.getBoard()[row + 1][col - 1].equals("0")){
                revealAlgorithm(row + 1, col - 1);
            }
            if (board.getBoard()[row + 1][col].equals("0")){
                revealAlgorithm(row + 1, col);
            }
            buttons[row][col - 1].setBackground(Color.GRAY);
            buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
            buttons[row + 1][col - 1].setBackground(Color.GRAY);
            buttons[row + 1][col - 1].setText(board.getBoard()[row + 1][col - 1]);
            buttons[row + 1][col].setBackground(Color.GRAY);
            buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
        }
        else if (row == board.getBoard().length - 1 && col == 0){
            if (board.getBoard()[row - 1][col].equals("0")){
                revealAlgorithm(row - 1, col);
            }
            if (board.getBoard()[row - 1][col + 1].equals("0")){
                revealAlgorithm(row - 1, col + 1);
            }
            if (board.getBoard()[row][col + 1].equals("0")){
                revealAlgorithm(row, col + 1);
            }
            buttons[row - 1][col].setBackground(Color.GRAY);
            buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
            buttons[row - 1][col + 1].setBackground(Color.GRAY);
            buttons[row - 1][col + 1].setText(board.getBoard()[row - 1][col + 1]);
            buttons[row][col + 1].setBackground(Color.GRAY);
            buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
        }
        else if (row == board.getBoard().length - 1 && col == board.getBoard()[0].length - 1){
            if (board.getBoard()[row - 1][col].equals("0")){
                revealAlgorithm(row - 1, col);
            }
            if (board.getBoard()[row - 1][col - 1].equals("0")){
                revealAlgorithm(row - 1, col - 1);
            }
            if (board.getBoard()[row][col - 1].equals("0")){
                revealAlgorithm(row, col - 1);
            }
            buttons[row - 1][col].setBackground(Color.GRAY);
            buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
            buttons[row - 1][col - 1].setBackground(Color.GRAY);
            buttons[row - 1][col - 1].setText(board.getBoard()[row - 1][col - 1]);
            buttons[row][col - 1].setBackground(Color.GRAY);
            buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
        }
        else if (row == 0){
            if (board.getBoard()[row][col - 1].equals("0")){
                revealAlgorithm(row, col - 1);
            }
            if (board.getBoard()[row + 1][col - 1].equals("0")){
                revealAlgorithm(row + 1, col - 1);
            }
            if (board.getBoard()[row + 1][col].equals("0")){
                revealAlgorithm(row + 1, col);
            }
            if (board.getBoard()[row + 1][col + 1].equals("0")){
                revealAlgorithm(row + 1, col + 1);
            }
            if (board.getBoard()[row][col + 1].equals("0")){
                revealAlgorithm(row, col + 1);
            }
            buttons[row][col - 1].setBackground(Color.GRAY);
            buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
            buttons[row + 1][col - 1].setBackground(Color.GRAY);
            buttons[row + 1][col - 1].setText(board.getBoard()[row + 1][col - 1]);
            buttons[row + 1][col].setBackground(Color.GRAY);
            buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
            buttons[row + 1][col + 1].setBackground(Color.GRAY);
            buttons[row + 1][col + 1].setText(board.getBoard()[row + 1][col + 1]);
            buttons[row][col + 1].setBackground(Color.GRAY);
            buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
        }
        else if (col == 0){
            if (board.getBoard()[row - 1][col].equals("0")){
                revealAlgorithm(row - 1, col);
            }
            if (board.getBoard()[row - 1][col + 1].equals("0")){
                revealAlgorithm(row - 1, col + 1);
            }
            if (board.getBoard()[row][col + 1].equals("0")){
                revealAlgorithm(row, col + 1);
            }
            if (board.getBoard()[row + 1][col + 1].equals("0")){
                revealAlgorithm(row + 1, col + 1);
            }
            if (board.getBoard()[row + 1][col].equals("0")){
                revealAlgorithm(row + 1, col);
            }
            buttons[row - 1][col].setBackground(Color.GRAY);
            buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
            buttons[row - 1][col + 1].setBackground(Color.GRAY);
            buttons[row - 1][col + 1].setText(board.getBoard()[row - 1][col + 1]);
            buttons[row][col + 1].setBackground(Color.GRAY);
            buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
            buttons[row + 1][col + 1].setBackground(Color.GRAY);
            buttons[row + 1][col + 1].setText(board.getBoard()[row + 1][col + 1]);
            buttons[row + 1][col].setBackground(Color.GRAY);
            buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
        }
        else if (row == board.getBoard().length - 1){
            if (board.getBoard()[row][col - 1].equals("0")){
                revealAlgorithm(row, col - 1);
            }
            if (board.getBoard()[row - 1][col - 1].equals("0")){
                revealAlgorithm(row - 1, col - 1);
            }
            if (board.getBoard()[row - 1][col].equals("0")){
                revealAlgorithm(row - 1, col);
            }
            if (board.getBoard()[row - 1][col + 1].equals("0")){
                revealAlgorithm(row - 1, col + 1);
            }
            if (board.getBoard()[row][col + 1].equals("0")){
                revealAlgorithm(row, col + 1);
            }
            buttons[row][col - 1].setBackground(Color.GRAY);
            buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
            buttons[row - 1][col - 1].setBackground(Color.GRAY);
            buttons[row - 1][col - 1].setText(board.getBoard()[row - 1][col - 1]);
            buttons[row - 1][col].setBackground(Color.GRAY);
            buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
            buttons[row - 1][col + 1].setBackground(Color.GRAY);
            buttons[row - 1][col + 1].setText(board.getBoard()[row - 1][col + 1]);
            buttons[row][col + 1].setBackground(Color.GRAY);
            buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
        }
        else if (col == board.getBoard()[0].length - 1){
            if (board.getBoard()[row - 1][col].equals("0")){
                revealAlgorithm(row - 1, col);
            }
            if (board.getBoard()[row - 1][col - 1].equals("0")){
                revealAlgorithm(row - 1, col - 1);
            }
            if (board.getBoard()[row][col - 1].equals("0")){
                revealAlgorithm(row, col - 1);
            }
            if (board.getBoard()[row + 1][col - 1].equals("0")){
                revealAlgorithm(row + 1, col - 1);
            }
            if (board.getBoard()[row + 1][col].equals("0")){
                revealAlgorithm(row + 1, col);
            }
            buttons[row - 1][col].setBackground(Color.GRAY);
            buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
            buttons[row - 1][col - 1].setBackground(Color.GRAY);
            buttons[row - 1][col - 1].setText(board.getBoard()[row - 1][col - 1]);
            buttons[row][col - 1].setBackground(Color.GRAY);
            buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
            buttons[row + 1][col - 1].setBackground(Color.GRAY);
            buttons[row + 1][col - 1].setText(board.getBoard()[row + 1][col - 1]);
            buttons[row + 1][col].setBackground(Color.GRAY);
            buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
        }
        else {
            if (board.getBoard()[row - 1][col - 1].equals("0")){
                revealAlgorithm(row - 1, col - 1);
            }
            if (board.getBoard()[row - 1][col].equals("0")){
                revealAlgorithm(row - 1, col);
            }
            if (board.getBoard()[row - 1][col + 1].equals("0")){
                revealAlgorithm(row - 1, col + 1);
            }
            if (board.getBoard()[row][col + 1].equals("0")){
                revealAlgorithm(row, col + 1);
            }
            if (board.getBoard()[row + 1][col + 1].equals("0")){
                revealAlgorithm(row + 1, col + 1);
            }
            if (board.getBoard()[row + 1][col].equals("0")){
                revealAlgorithm(row + 1, col);
            }
            if (board.getBoard()[row + 1][col - 1].equals("0")){
                revealAlgorithm(row + 1, col - 1);
            }
            if (board.getBoard()[row][col - 1].equals("0")){
                revealAlgorithm(row, col - 1);
            }
            buttons[row - 1][col - 1].setBackground(Color.GRAY);
            buttons[row - 1][col - 1].setText(board.getBoard()[row - 1][col - 1]);
            buttons[row - 1][col].setBackground(Color.GRAY);
            buttons[row - 1][col].setText(board.getBoard()[row - 1][col]);
            buttons[row - 1][col + 1].setBackground(Color.GRAY);
            buttons[row - 1][col + 1].setText(board.getBoard()[row - 1][col + 1]);
            buttons[row][col + 1].setBackground(Color.GRAY);
            buttons[row][col + 1].setText(board.getBoard()[row][col + 1]);
            buttons[row + 1][col + 1].setBackground(Color.GRAY);
            buttons[row + 1][col + 1].setText(board.getBoard()[row + 1][col + 1]);
            buttons[row + 1][col].setBackground(Color.GRAY);
            buttons[row + 1][col].setText(board.getBoard()[row + 1][col]);
            buttons[row + 1][col - 1].setBackground(Color.GRAY);
            buttons[row + 1][col - 1].setText(board.getBoard()[row + 1][col - 1]);
            buttons[row][col - 1].setBackground(Color.GRAY);
            buttons[row][col - 1].setText(board.getBoard()[row][col - 1]);
        }
    }*/

}

