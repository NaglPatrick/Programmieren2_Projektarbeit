package GUI;

import javax.swing.*;

public class Login extends JFrame{
    private JButton buttonLogin;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton buttonCreate;
    private JPanel mainPanel;

    public Login() {
        initialize();
    }

    public void initialize() {
        setContentPane(mainPanel);
        setTitle("Registration");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
