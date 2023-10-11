import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator extends JFrame {

    JTextField txtname;
    JButton[] btn;
    JButton btnClear, btnHistory;
    JButton btnDecimal, btnEqual, btnAdd, btnSub, btnMulti, btnDivi;
    Font buttonFont;
    calLogic logic;

    calculator() {

        buttonFont = new Font("Arial", Font.BOLD, 20);

        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
        con.setLayout(lay);
        con.setBackground(Color.lightGray);

        txtname = new JTextField(25);
        txtname.setPreferredSize(new Dimension(200, 50));
        con.add(txtname);

        btnDivi = new JButton("/");
        btnDivi.setFont(buttonFont);
        btnDivi.setActionCommand("/");
        btnDivi.setBackground(Color.GRAY);
        btnDivi.setPreferredSize(new Dimension(60, 40));

        btnMulti = new JButton("X");
        btnMulti.setFont(buttonFont);
        btnMulti.setActionCommand("x");
        btnMulti.setBackground(Color.GRAY);
        btnMulti.setPreferredSize(new Dimension(60, 40));

        btnSub = new JButton("-");
        btnSub.setFont(buttonFont);
        btnSub.setActionCommand("-");
        btnSub.setBackground(Color.GRAY);
        btnSub.setPreferredSize(new Dimension(60, 40));

        btn = new JButton[10]; 
        for (int i = 7; i <= 9; i++) {
            btn[i] = new JButton(Integer.toString(i));
            btn[i].setFont(buttonFont);
            btn[i].setBackground(Color.GRAY);
            btn[i].setPreferredSize(new Dimension(60, 40));
            con.add(btn[i]);
            btn[i].setActionCommand(Integer.toString(i));
        }
        con.add(btnDivi);

        for (int i = 4; i <= 6; i++) {
            btn[i] = new JButton(Integer.toString(i));
            btn[i].setFont(buttonFont);
            btn[i].setBackground(Color.GRAY);
            btn[i].setPreferredSize(new Dimension(60, 40));
            con.add(btn[i]);
            btn[i].setActionCommand(Integer.toString(i));
        }
        con.add(btnMulti);

        for (int i = 1; i <= 3; i++) {
            btn[i] = new JButton(Integer.toString(i));
            btn[i].setFont(buttonFont);
            btn[i].setBackground(Color.GRAY);
            btn[i].setPreferredSize(new Dimension(60, 40));
            con.add(btn[i]);
            btn[i].setActionCommand(Integer.toString(i));
        }
        con.add(btnSub);

        btnDecimal = new JButton(".");
        btnDecimal.setFont(buttonFont);
        btnDecimal.setBackground(Color.GRAY);
        btnDecimal.setPreferredSize(new Dimension(60, 40));
        con.add(btnDecimal);
        btnDecimal.setActionCommand(".");
       
        btn[0] = new JButton("0");
        btn[0].setFont(buttonFont);
        btn[0].setBackground(Color.GRAY);
        btn[0].setPreferredSize(new Dimension(60, 40));
        con.add(btn[0]);
        btn[0].setActionCommand("0");

        btnEqual = new JButton("=");
        btnEqual.setFont(buttonFont);
        btnEqual.setBackground(Color.GRAY);
        btnEqual.setPreferredSize(new Dimension(60, 40));
        con.add(btnEqual);
        btnEqual.setActionCommand("=");

        btnAdd = new JButton("+");
        btnAdd.setFont(buttonFont);
        btnAdd.setBackground(Color.GRAY);
        btnAdd.setPreferredSize(new Dimension(60, 40));
        con.add(btnAdd);
        btnAdd.setActionCommand("+");

        ImageIcon clearIcon = new ImageIcon("D:\\Projects\\Java\\Images\\clear.png");
        Image imgClear = clearIcon.getImage();
        Image scaledImgClear = imgClear.getScaledInstance(30, 20, Image.SCALE_SMOOTH);
        clearIcon = new ImageIcon(scaledImgClear);
        btnClear = new JButton(clearIcon);
        btnClear.setActionCommand("C");
        btnClear.setBackground(Color.GRAY);
        btnClear.setPreferredSize(new Dimension(60, 40));

        ImageIcon historyIcon = new ImageIcon("D:\\Projects\\Java\\Images\\history.png");
        Image imgHistory = historyIcon.getImage();
        Image scaledImgHistory = imgHistory.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        historyIcon = new ImageIcon(scaledImgHistory);
        btnHistory = new JButton(historyIcon);
        btnHistory.setActionCommand("History");
        btnHistory.setBackground(Color.GRAY);
        btnHistory.setPreferredSize(new Dimension(60, 40));

        con.add(btnClear);
        con.add(btnHistory);

        logic = new calLogic(txtname); 
        addButtonListeners(logic);  
    } 

    public JTextField getTxtName() {
        return txtname;
    }

    public void addButtonListeners(ActionListener listener) {
        for (JButton button : btn) {
            button.addActionListener(listener);
        }
        btnDivi.addActionListener(listener);
        btnMulti.addActionListener(listener);
        btnSub.addActionListener(listener);
        btnDecimal.addActionListener(listener);
        btnEqual.addActionListener(listener);
        btnAdd.addActionListener(listener);
        btnClear.addActionListener(listener);
        btnHistory.addActionListener(listener);
    }
}                                            