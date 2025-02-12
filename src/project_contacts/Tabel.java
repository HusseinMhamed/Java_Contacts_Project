package project_contacts;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
 import javax.swing.border.LineBorder;
 public abstract class  Tabel extends MainFrema {

    MyPanel panel2 = new MyPanel();
    Object[][] data;
    protected DefaultTableModel model;
    JTable table;
    JLabel labelcont = new JLabel("MY CONTACTS");
    JButton Bottont = new JButton("Back");
    JButton Buttont = new JButton("Delete Contact");
     ImageIcon customIco1 = new ImageIcon("src/icons/left-arrow.png");
    ImageIcon customIco2 = new ImageIcon("src/icons/numbers.png");
    JLabel labelicons1 = new JLabel(customIco1);
     JLabel labelicons2 = new JLabel(customIco2);
      
    int numRow;
    JLabel labek ;
      JFrame fram2 =new JFrame();
    public Tabel() {
        fram2.setSize(900, 700);
        fram2.setResizable(false);
        fram2.setLayout(null);
        fram2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fram2.getContentPane().setBackground(new Color(0, 0, 0));
        fram2.setLocationRelativeTo(this);
        fram2.setLayout(null);
        panel2.setBounds(0, 0, 900, 700);
        fram2.add(panel2);
        panel2.setLayout(null);
         /////////////////////////////////////////////////////
        String[] columns = new String[]{
            "Name", "Phone", "Email", "City", "Nickname", "Gender", "Relation", "Address"
        };
        data = null;
        model = new DefaultTableModel(data, columns);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 200, 900, 700);
        panel2.add(scrollPane);
        table.getAutoResizeMode();
        Bottont.addActionListener(this);
        ///////////////////////////////////////////////////////////////
        labelcont.setForeground(Color.white);
        labelcont.setBounds(340, 30, 300, 30);
        labelcont.setFont(new Font("Georgia", Font.ITALIC, 35));
        Bottont.setForeground(Color.black);
        Bottont.setBounds(150, 115, 100, 40);
        Bottont.setFont(new Font("Georgia", Font.ITALIC, 20));
        Bottont.setBackground(Color.white);
        Bottont.setBorder(new LineBorder(Color.black, 1));
        Bottont.setFocusable(false);
        ////////////////////////
        Buttont.addActionListener(this);
        Buttont.setBounds(290, 115,180, 40);
        Buttont.setFont(new Font("Georgia", Font.ITALIC, 20));
        Buttont.setBackground(Color.white);
        Buttont.setBorder(new LineBorder(Color.black, 1));
        Buttont.setFocusable(false);
        Buttont.setIcon(customIcon11);
        ////////////////////////////////
        
         numRow=table.getRowCount();
         labek = new JLabel("Number of contacts is : "+numRow);
        labelicons1.setBounds(50, 100, 90, 70);
        labelicons2.setBounds(480, 115, 90, 70);
        labek.setForeground(Color.black);
        labek.setBounds(580, 130, 300, 30);
        labek.setFont(new Font("Georgia", Font.ITALIC, 23));
        panel2.add(labelcont);
        panel2.add(labek);
        panel2.add(labelicons1);
        panel2.add(labelicons2);
        panel2.add(Bottont);
        panel2.add(Buttont);
       // table.getColumnModel().getColumn(0).setPreferredWidth(20);
       }
 }
