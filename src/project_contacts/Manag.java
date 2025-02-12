package project_contacts;
 import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class Manag extends Tabel {

    String name, phone, gmail, city, nicname, gender, relation, adress;
    int num1;
    File f;
    List<Integer> selectedRows = new ArrayList<>();

    public Manag() throws Exception {
     }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttons[6]) {
            fram1.dispose();
            fram2.setVisible(true);
        } else if (e.getSource() == Bottont) {
            table.clearSelection();
            fram2.dispose();
            fram1.setVisible(true);
        } else if (e.getSource() == redButton1) {
            gender = redButton1.getText();
        } else if (e.getSource() == redButton2) {
            gender = redButton2.getText();
        } else if (e.getSource() == buttons[1]) {
            add();
        } else if (e.getSource() == buttons[0]) {
            clear();
        } else if (e.getSource() == buttons[2]) {
            search();
        } else if (e.getSource() == Buttont) {
            delete();
        } else if (e.getSource() == buttons[5]) {
            help h = new help();
        }else if (e.getSource() == buttons[4]) {
                 clearall();
        }
     }

    void add() {
        name = textarry[0].getText();
        phone = textarry[1].getText();
        gmail = textarry[2].getText();
        city = textarry[3].getText();
        nicname = textarry[4].getText();
        num1 = typecontacts.getSelectedIndex();
        relation = typecontact[num1];
        adress = textArea.getText();
        if (textarry[0].getText().trim().isEmpty()|| textarry[1].getText().trim().isEmpty()|| textarry[2].getText().trim().isEmpty()|| textarry[3].getText().trim().isEmpty()|| textarry[4].getText().trim().isEmpty() || typecontact[num1].trim().isEmpty() ||textArea.getText().trim().isEmpty()|| gender == null) {
            JOptionPane.showMessageDialog(null, "!!!!!! You Must Answer All !!!!!", "Valide", JOptionPane.WARNING_MESSAGE);
        } else {
            if ((phone.startsWith("010") | phone.startsWith("011") | phone.startsWith("012"))
                    && (gmail.endsWith("@gmail.com") && phone.length() == 11)) {
                model.addRow(new Object[]{ name, phone, gmail,
                    city, nicname, gender, relation,
                    adress});
                numRow++;
                labek.setText("Number of contacts is : " + table.getRowCount());
                JOptionPane.showMessageDialog(null, "Added Successfully", "Add", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Invalid Gmail or Phone Number ", "Valide", JOptionPane.WARNING_MESSAGE);
            }
        }
         write();
    }

    void clear() {
        if (textarry[0].getText().isEmpty() && textarry[1].getText().isEmpty() && textarry[2].getText().isEmpty() && textarry[3].getText().isEmpty() && textarry[4].getText().isEmpty() && textArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Already Clear", "Clear", JOptionPane.WARNING_MESSAGE);
        } else {
             textarry[0].setText(null);
            textarry[1].setText(null);
            textarry[2].setText(null);
            textarry[3].setText(null);
            textarry[4].setText(null);
            textArea.setText(null);
        }
    }

    void search() {
        String s = JOptionPane.showInputDialog("Enter Contact Name : ");
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < 5; j++) {
                if (model.getValueAt(i, j).equals(s)) {
                    selectedRows.add(i);
                    break;
                }
            }
        }
             
        if (!selectedRows.isEmpty()) {
            for (int row : selectedRows) {
                table.addRowSelectionInterval(row, row);
            }
             fram1.dispose();
            selectedRows.clear();
            fram2.setVisible(true);
         }else{
           JOptionPane.showMessageDialog(null, "Not Found", "", JOptionPane.INFORMATION_MESSAGE);
        }
       
    }
     void delete() {
        int index = table.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Please Select at least one");
        } else {
            model.removeRow(index);
            numRow--;
            labek.setText("Number of contacts is : " +table.getRowCount());
        }
          write();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
         read();
     }

    @Override
    public void windowClosing(WindowEvent e) {
       write();
    }

    @Override
    public void windowClosed(WindowEvent e) {
     }

    @Override
    public void windowIconified(WindowEvent e) {
     }

    @Override
    public void windowDeiconified(WindowEvent e) {
     }

    @Override
    public void windowActivated(WindowEvent e) {
     }

    @Override
    public void windowDeactivated(WindowEvent e) {
     }
    
    void read(){
            
         try {
            // TODO add your handling code here:
            FileInputStream file = new FileInputStream("contacts.bin");
            ObjectInputStream input = new ObjectInputStream(file);
            // Method for deserialization of object
            Vector<Vector> tableData = (Vector<Vector>)input.readObject();
             input.close();
            file.close();
          DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = 0; i < tableData.size(); i++) {
                Vector row = tableData.get(i);
                 model.addRow(new Object[]{row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), row.get(6), row.get(7)});
                 labek.setText("Number of contacts is : "+ table.getRowCount());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
      //   numRow=table.getRowCount();
       
        
    }
    void write(){
       DefaultTableModel model = (DefaultTableModel) table.getModel();
        Vector<Vector> tableData = model.getDataVector();
        
        //Saving of object in a file
        try {
            FileOutputStream file = new FileOutputStream("contacts.bin");
            ObjectOutputStream output = new ObjectOutputStream(file);
             // Method for serialization of object
            output.writeObject(tableData);

            output.close();
            file.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       // numRow=table.getRowCount();
    }
    void clearall(){
         int num=  JOptionPane.showConfirmDialog(null, "are you already wanna Delete all ?", "Clear", JOptionPane.YES_NO_CANCEL_OPTION); 
        if(num==0){
         model.setRowCount(0);
             write();
             JOptionPane.showMessageDialog(null, "Done Clear", "Clear", JOptionPane.INFORMATION_MESSAGE);
             numRow=0;
            labek.setText("Number of contacts is : " +table.getRowCount());
             
        }
    }

}
