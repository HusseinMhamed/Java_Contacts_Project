package project_contacts;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public abstract class MainFrema extends JFrame implements ActionListener, WindowListener {

    ImageIcon customIcon1 = new ImageIcon("src/icons/phone-book.png");///main
    ImageIcon customIcon2 = new ImageIcon("src/icons/card (1).png");///name  
    ImageIcon customIcon3 = new ImageIcon("src/icons/phone (1).png");/////phone
    ImageIcon customIcon4 = new ImageIcon("src/icons/gmail (1).png");/////gmail
    ImageIcon customIcon5 = new ImageIcon("src/icons/skyscraper (1).png");/////city
    ImageIcon customIcon6 = new ImageIcon("src/icons/id-card (1).png");/////////nik name
    ImageIcon customIcon7 = new ImageIcon("src/icons/home-address.png");////adrees
    ImageIcon customIcon8 = new ImageIcon("src/icons/relationship.png");///relation
    ImageIcon customIcon9 = new ImageIcon("src/icons/add.png");//add
    ImageIcon customIcon10 = new ImageIcon("src/icons/search.png");//search
    ImageIcon customIcon11 = new ImageIcon("src/icons/delete.png");//delete
    ImageIcon customIcon12 = new ImageIcon("src/icons/update.png");//updeat
    ImageIcon customIcon13 = new ImageIcon("src/icons/cleaning.png");////clear
    ImageIcon customIcon14 = new ImageIcon("src/icons/help.png");//help
    ImageIcon customIcon15 = new ImageIcon("src/icons/go.png");//show
    JLabel mainlabel = new JLabel(customIcon1);
    JLabel labelicons[] = new JLabel[14];
    MyPanel panel = new MyPanel();
    JTextField[] textarry = new JTextField[5];
    JLabel label[] = new JLabel[10];
    JTextArea textArea = new JTextArea();
    JRadioButton redButton1 = new JRadioButton("Male");
    JRadioButton redButton2 = new JRadioButton("Female");
    JButton buttons[] = new JButton[7];
    ButtonGroup group = new ButtonGroup();
    String[] typecontact = {"friend", "family", "best friend", "Worker"};
    JComboBox<JButton[]> typecontacts = new JComboBox(typecontact);
    JFrame fram1 = new JFrame();

    public MainFrema() {
        fram1.setSize(900, 700);
        fram1.setResizable(true);
        fram1.setLayout(null);
        fram1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fram1.getContentPane().setBackground(new Color(0, 0, 0));
        fram1.setLocationRelativeTo(fram1);
        fram1.setLayout(null);
        panel.setBounds(0, 0, 900, 700);

        fram1.add(panel);
        ///////////////////////////////lapel////////////////////////
        for (int i = 0; i < label.length; i++) {
            label[i] = new JLabel();
            label[i].setForeground(Color.black);
            label[i].setFont(new Font("Georgia", Font.ITALIC, 20));
            panel.add(label[i]);
            if (i < buttons.length) {
                buttons[i] = new JButton();
                buttons[i].setFocusable(false);
                buttons[i].setFont(new Font("Georgia", Font.ITALIC, 20));
                buttons[i].setBackground(Color.white);
                buttons[i].setBorder(new LineBorder(Color.black, 1));
                buttons[i].setForeground(Color.black);
                panel.add(buttons[i]);
                buttons[i].addActionListener(this);
            }
        }
        //////////////////////////////////////////text feild/////////////////
        for (int i = 0, j = 120; i < textarry.length; i++, j += 40) {
            textarry[i] = new JTextField();
            textarry[i].setBackground(Color.white);
            textarry[i].setForeground(Color.black);
            textarry[i].setFont(new Font("Georgia", Font.ITALIC, 20));
            textarry[i].setCaretColor(Color.black);
            textarry[i].setBorder(new LineBorder(Color.white, 2));
            label[i].setBounds(135, j, 200, 40);
            textarry[i].setBounds(100, j += 40, 270, 40);
            label[i].setFont(new Font("Georgia", Font.ITALIC, 20));
            panel.add(textarry[i]);
        }
        label[0].setText("Full Name :");
        label[1].setText("Phone :");
        label[2].setText("Gmail :");
        label[3].setText("City :");
        label[4].setText("Nickname :");
        label[5].setText("Address");
        label[6].setText("Relation");
        label[7].setText("MY CONTACTS");
        label[5].setBounds(520, 165, 100, 30);
        label[6].setBounds(745, 165, 100, 30);
        label[7].setBounds(350, 40, 300, 30);
        label[7].setFont(new Font("Georgia", Font.LAYOUT_NO_START_CONTEXT, 30));
        label[7].setForeground(Color.white);
        /////////////////group radio button////////////////////////////////////////
        redButton1.setFocusable(false);
        redButton1.setForeground(Color.white);
        redButton1.setFont(new Font("Georgia", Font.ITALIC, 20));
        redButton2.setFocusable(false);
        redButton2.setForeground(Color.white);
        redButton2.setFont(new Font("Georgia", Font.ITALIC, 20));
        redButton1.setBackground(new Color(0, 153, 153));
        redButton2.setBackground(new Color(0, 153, 153));
        redButton1.setBounds(100, 545, 17, 17);
        redButton2.setBounds(240, 545, 17, 17);
        redButton1.addActionListener(this);
        redButton2.addActionListener(this);
        label[8].setText("Male");
        label[9].setText("Female");
        label[8].setBounds(120, 535, 50, 30);
        label[9].setBounds(265, 535, 80, 30);
        panel.add(redButton1);
        panel.add(redButton2);
        group.add(redButton1);
        group.add(redButton2);
        ///////////////////////combobox//////////////////////////////////////////
        panel.add(typecontacts);
        typecontacts.setBounds(735, 200, 110, 30);
        typecontacts.setForeground(Color.black);
        typecontacts.setBorder(new LineBorder(Color.white, 3));
        setFocusable(false);
        typecontacts.setFont(new Font("Georgia", Font.ITALIC, 20));
        typecontacts.addActionListener(this);
        /////////////////////////trxtarea//////////////////////////////////
        panel.add(textArea);
        textArea.setBounds(420, 200, 270, 100);
        textArea.setFont(new Font("Georgia", Font.ITALIC, 20));
        textArea.setForeground(Color.black);
        textArea.setBackground(Color.white);
        textArea.setBorder(new LineBorder(Color.black, 1));
        textArea.setCaretColor(Color.black);
        ////////////////////buttons Icons//////////////////////////
        buttons[0].setIcon(customIcon13);
        buttons[1].setIcon(customIcon9);
        buttons[2].setIcon(customIcon10);
        buttons[4].setIcon(customIcon11);
        buttons[5].setIcon(customIcon14);
        // buttons[6].setIcon(customIcon15);
        /////////////////////bottons text////////////////////////////
        buttons[0].setText("Clear");
        buttons[1].setText("Add");
        buttons[2].setText("Search");
        buttons[4].setText("Delete all");
        buttons[5].setText("Help");
        buttons[6].setText("Show My Contacts");
        buttons[0].setBounds(180, 590, 120, 40);
        buttons[1].setBounds(720, 414, 130, 40);
        buttons[2].setBounds(420, 415, 130, 40);
        buttons[4].setBounds(570, 415, 130, 40);
        buttons[5].setBounds(750, 80, 120, 40);
        buttons[6].setBounds(510, 590, 230, 40);
        // panel.add(buttons[i]);
        //////////////////////icons ///////////////////////////////////
        panel.add(mainlabel);
        mainlabel.setBounds(580, 40, 30, 30);
        for (int i = 0, j = 120; i < labelicons.length; i++, j += 80) {

            labelicons[i] = new JLabel();
            if (i < 5) {
                labelicons[i].setBounds(100, j, 40, 40);
            }
            panel.add(labelicons[i]);
        }
        labelicons[0].setIcon(customIcon2);
        labelicons[1].setIcon(customIcon3);
        labelicons[2].setIcon(customIcon4);
        labelicons[3].setIcon(customIcon5);
        labelicons[4].setIcon(customIcon6);
        labelicons[5].setIcon(customIcon7);
        labelicons[6].setIcon(customIcon8);
        labelicons[13].setIcon(customIcon15);
        labelicons[5].setBounds(488, 165, 40, 40);
        labelicons[6].setBounds(830, 160, 40, 40);
        labelicons[7].setBounds(540, 325, 40, 40);
        labelicons[8].setBounds(390, 450, 40, 40);
        labelicons[9].setBounds(723, 440, 40, 40);
        labelicons[10].setBounds(550, 445, 40, 40);
        labelicons[11].setBounds(140, 580, 40, 40);
        labelicons[12].setBounds(810, 50, 40, 40);
        labelicons[13].setBounds(780, 590, 70, 40);
        ///////////////////////////////////////////////////
        fram1.addWindowListener(this);
        panel.setLayout(null);
        fram1.setVisible(true);
    }
}
