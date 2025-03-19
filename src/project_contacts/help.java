package project_contacts;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class help extends JFrame {

    JFrame fram4 = new JFrame();
    MyPanel panel4 = new MyPanel();
    JLabel label3[] = new JLabel[20];

    public help() {
        fram4.setSize(900, 700);
        fram4.setResizable(false);
        fram4.setLayout(null);
        fram4.getContentPane().setBackground(new Color(0, 0, 0));
        fram4.setLocationRelativeTo(this);
        fram4.setLayout(null);
        panel4.setBounds(0, 0, 900, 700);
        fram4.add(panel4);
        panel4.setLayout(null);
        for (int i = 0; i < label3.length; i++) {
            label3[i] = new JLabel();
            label3[i].setForeground(Color.black);
            label3[i].setFont(new Font("Georgia", Font.ITALIC, 20));
            panel4.add(label3[i]);
        }
        
        label3[0].setText("HELLP");
        label3[0].setFont(new Font("Georgia", Font.ITALIC, 40));
        label3[0].setBounds(380, 30, 200, 30);
        label3[1].setText("* MY CONTACTS : ");
        label3[1].setBounds(50, 200, 300, 30);
        label3[2].setText("This program stores your contacts like: ");
        label3[2].setBounds(70, 240, 800, 30);
        label3[3].setText("_ Name ,Phone ,gmail ,city ,nickname ,gender ,address, relation ");
        label3[3].setBounds(70, 280, 800, 30);
        label3[4].setText("_ then displays all the data in one table");
        label3[4].setBounds(70, 320, 800, 30);
        label3[5].setText("_ there are many functions in this program that you can use and enjoy");
        label3[5].setBounds(70, 360, 800, 30);
        label3[6].setText("Made in Egypt");
        label3[6].setBounds(740, 610, 150, 30);
        label3[7].setText("Created by a team under supervision : ");
        label3[7].setBounds(70, 410, 800, 30);
        
        fram4.setVisible(true);

    }

}
