import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {

    JButton level1;
    JButton level2;
    JButton level3;

    public MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(625, 500);

        level1 = new JButton("Level 1");
        level1.setBounds(250, 100, 100, 50);
        this.add(level1);
        level1.addActionListener(this);

        level2 = new JButton("Level 2");
        level2.setBounds(250, 150, 100, 50);
        this.add(level2);
        level2.addActionListener(this);

        level3 = new JButton("Level 3");
        level3.setBounds(250, 200, 100, 50);
        this.add(level3);
        level3.addActionListener(this);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == level1) {
            this.remove(level1);
            this.remove(level2);
            this.remove(level3);
            level1.setVisible(false);
            level2.setVisible(false);
            level3.setVisible(false);
            this.setLayout(new GridLayout(8, 10, 2, 2));
            for (int i = 1; i <= 80; i++){
                JButton button = new JButton("");
                button.setBackground(Color.GRAY);
                this.add(button);
            }
            this.setVisible(true);
        }
    }
}
