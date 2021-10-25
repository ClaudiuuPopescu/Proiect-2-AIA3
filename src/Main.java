import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList("Fructe");
    private JButton searchElement;
    private JButton removeElement;
    private JButton addElement;
    private JButton printList;
    private JTextField textField1;
    private JPanel rootPanel;
    private JTabbedPane modificari;
    private JTabbedPane tabbedPane1;
    private JButton btnPrint;
    private JLabel titluPg2;

    public Main(){
        addElement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                int answer;
                if(groceryList.addItem(name)) {
                        answer = JOptionPane.showConfirmDialog(null, "'" + name + "'" + " a fost adaugat cu succes!", "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                    }else {
//                    System.out.println("Trebuie introdus un produs.");
                        answer = JOptionPane.showConfirmDialog(null, "Trebuie introdus un produs!", "Error-add", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    }
                }
        });
        removeElement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                int answer;
                if(groceryList.removeItem(name)) {
                    answer = JOptionPane.showConfirmDialog(null, "'" + name + "'" + " a fost sters cu succes!", "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                }else{
                    answer = JOptionPane.showConfirmDialog(null, "Trebuie introdus numele unui produs!", "Error-remove", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        searchElement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                int answer;
                if (name != null) {
                    if (groceryList.searchForItem(name)) {
                        System.out.println("'" + name + "' a fost gasit pe lista.");
                        answer = JOptionPane.showConfirmDialog(null, "'" + name + "'" + " a fost gasit cu succes!", "Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
                    } else {
                        System.out.println("'" + name + "' nu a fost gasit pe lista.");
                        answer = JOptionPane.showConfirmDialog(null, "'" + name + "'" + " nu se afla pe lista!", "Error-search", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    };
                }
            }
        });

        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lista  = groceryList.printListBuffer();
                int answer = JOptionPane.showConfirmDialog(null, lista, "Grocery list", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GroceryList");
        frame.setContentPane(new Main().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
