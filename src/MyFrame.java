import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener, MouseListener {

    JButton level1;
    JButton level2;
    JButton level3;
    Board board;
    JButton[][] buttons;

    public MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(625, 500);

        level1 = new JButton("Level 1");
        level1.setBounds(250, 100, 100, 50);
        this.add(level1);
        level1.addActionListener(this);

        level2 = new JButton("Level 2");
        level2.setBounds(250, 200, 100, 50);
        this.add(level2);
        level2.addActionListener(this);

        level3 = new JButton("Level 3");
        level3.setBounds(250, 300, 100, 50);
        this.add(level3);
        level3.addActionListener(this);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == level1) {
            board = new Board(1);
            buttons = new JButton[8][10];
            this.remove(level1);
            this.remove(level2);
            this.remove(level3);
            this.invalidate();
            this.validate();
            this.repaint();
            this.setLayout(new GridLayout(8, 10, 1, 1));
            for (int i = 0; i < 8; i++) {
                for (int x = 0; x < 10; x++) {
                    JButton button = new JButton("");
                    buttons[i][x] = button;
                    button.setBackground(Color.GRAY);
                    this.add(button);
                }
            }
            this.setVisible(true);
        }
        else if (e.getSource() == level2) {
            board = new Board(2);
            buttons = new JButton[14][18];
            this.remove(level1);
            this.remove(level2);
            this.remove(level3);
            this.invalidate();
            this.validate();
            this.repaint();
            this.setLayout(new GridLayout(14, 18, 1, 1));
            for (int i = 0; i < 14; i++) {
                for (int x = 0; x < 18; x++) {
                    JButton button = new JButton("");
                    buttons[i][x] = button;
                    button.setBackground(Color.GRAY);
                    this.add(button);
                }
            }
            this.setVisible(true);
        }
        else if (e.getSource() == level3) {
            board = new Board(3);
            buttons = new JButton[20][24];
            this.remove(level1);
            this.remove(level2);
            this.remove(level3);
            this.invalidate();
            this.validate();
            this.repaint();
            this.setLayout(new GridLayout(20, 24, 1, 1));
            for (int i = 0; i < 20; i++) {
                for (int x = 0; x < 24; x++) {
                    JButton button = new JButton("");
                    buttons[i][x] = button;
                    button.setBackground(Color.GRAY);
                    this.add(button);
                }
            }
            this.setVisible(true);
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /*for (int i = 0; i < buttons.length; i++) {
            for (int x = 0; x < buttons[i].length; x++) {
                if (e.equals(buttons[i][x])) {
                    buttons[i][x].setText(board.getBoard()[i][x]);
                    buttons[i][x].invalidate();
                    buttons[i][x].validate();
                    buttons[i][x].repaint();
                    buttons[i][x].setBackground(Color.WHITE);
                }
            }
        }*/
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
}

