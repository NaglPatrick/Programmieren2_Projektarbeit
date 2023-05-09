package com.GUI;

import javax.swing.*;

public class Menu extends JFrame{
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JTextField textField1;
    private JButton createButton;
    private JButton acceptButton;

    public Menu() {
    }

    public void initialize() {
        setContentPane(mainPanel);
        setTitle("Main Menu");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
