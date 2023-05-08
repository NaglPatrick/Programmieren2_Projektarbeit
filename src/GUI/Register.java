package GUI;
/*
 * ISchedule
 * Program to let Professors(Admin), assistants and student schedule their preferred courses
 * Author: Nagl Patrick
 * Last Change:  05.05.2022
 */

import javax.swing.*;

public class Register extends JFrame{

    private JPanel mainPanel;
    private JTextField eMailField;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JComboBox comboBox;
    private JButton buttonCreate;


    public Register() {
        initialize();
    }

    public void initialize() {
        setContentPane(mainPanel);
        setTitle("Registration");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

//    private void createUIComponents() {
//        // TODO: place custom component creation code here
//        JComboBox<String> comboBox = new JComboBox<String>();
//        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Administrator", "Assistant", "Student"}));
//
//    }





}
