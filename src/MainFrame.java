import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.GridLayout;
import java.util.HashMap;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 

public class MainFrame extends JFrame {
    
    private static HashMap<String, String> userCredentials = new HashMap<>();
    public static void main(String[] args) {

        JFrame homeFrame= new JFrame("Home Screen");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setSize(300, 300);
        homeFrame.setMinimumSize(new Dimension(300,300));
       
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout());
        homePanel.setBackground(new Color(128, 128, 255));
       
        JButton loginButton = new JButton("Log in");
        loginButton.setPreferredSize(new Dimension(75, 30));
        homePanel.add(loginButton);
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setPreferredSize(new Dimension(85, 30));
        homePanel.add(signUpButton);


        homeFrame.add(homePanel);
 
       loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e){
        homeFrame.dispose();
        JFrame loginFrame= new JFrame("Login");
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.setSize(300,600);
        loginFrame.setMinimumSize(new Dimension(300,300));


        JPanel logiPanel= new JPanel();
        logiPanel.setLayout(new FlowLayout());
        logiPanel.setBackground(new Color(128,128,255));


       JLabel user= new JLabel("Username");
        JTextField textUser= new JTextField(15);
        textUser.setPreferredSize(new Dimension(10, 25));
        logiPanel.add(user);
        logiPanel.add(textUser);
        JLabel pass= new JLabel("Password");
        JPasswordField textpass= new JPasswordField(15);
        textpass.setPreferredSize(new Dimension(10, 25));
        logiPanel.add(pass);
        logiPanel.add(textpass);
       
        JButton submitLogin = new JButton("Submit");
        submitLogin.setPreferredSize(new Dimension(75, 30));
        logiPanel.add(submitLogin);
        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        logiPanel.add(showPasswordCheckBox);
        JButton backLogButton = new JButton("Back");
        backLogButton.setPreferredSize(new Dimension(75, 30));
        logiPanel.add(backLogButton);
       
        loginFrame.add(logiPanel);
        loginFrame.setVisible(true);


       
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    textpass.setEchoChar((char) 0);
                } else {
                    textpass.setEchoChar('•');
                }
            }
        });
        //LOG IN CHECK
        submitLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String username= textUser.getText();
                char[] password= textpass.getPassword();
                 String inputPasswordString = new String(password).trim();


                System.out.println("Entered username: " + username);
                System.out.println("Entered password: " + inputPasswordString);
       
                if (userCredentials.containsKey(username)) {
                    String storedPassword = userCredentials.get(username);
                    if (storedPassword.equals(inputPasswordString)) {
                        JOptionPane.showMessageDialog(loginFrame, "Login successful!");
                        loginFrame.dispose();
    
                  
                      JFrame selectLangFrame = new JFrame("Next Screen");
                    selectLangFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                     //JPanel mainPanel = new JPanel();
                    //mainPanel.setBackground(new Color(128, 128, 255));
                    selectLangFrame.setSize(300, 300);
           
                    JPanel nextPanel = new JPanel();
                    JLabel step= new JLabel("Congrats! Now select the language you would like to learn!");
                    nextPanel.add(step);
       
                    selectLangFrame.add(nextPanel);
                    selectLangFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Incorrect password. Please try again.");
                }
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Username does not exist. Please sign up.");
            }
                   // Clear the password char array for security
                   java.util.Arrays.fill(password, '\0');
                }
            });
            backLogButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                loginFrame.dispose();
                homeFrame.setVisible(true);
            }
        });
    }
});


//NEW FRANE 
    JFrame frame = new JFrame("Sign Up");

         //Dimension minimumSize - MainFrame.main(String[])
        //frame.setMinimumSize(Dimension minimumSize);
        frame.setSize(300, 300);

        frame.setMinimumSize(new Dimension(300,300));      

        //Allows  do add different componets for screen
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(new Color(128,128,255));

        //Text labels and text fields
        JLabel name= new JLabel("Name");
        JTextField textName= new JTextField(15);
        //makes the size of the my choice
        textName.setPreferredSize(new Dimension(10, 25));
        panel.add(name);
        panel.add(textName);
        JLabel user= new JLabel("Username");
        JTextField textUser= new JTextField(15);
        textUser.setPreferredSize(new Dimension(10, 25));
        panel.add(user);
        panel.add(textUser);
        JLabel pass= new JLabel("Password");
        JTextField textpass= new JTextField(15);
        textpass.setPreferredSize(new Dimension(10, 25));
        panel.add(pass);
        panel.add(textpass);
       
        //Adds the button on the screen
        JButton submitButton= new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(75, 30));
        panel.add(submitButton);

        frame.add(panel);


        submitButton.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
            JFrame nextFrame = new JFrame("Next Screen");
            nextFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            nextFrame.setSize(300, 300);
           
            JPanel nextPanel = new JPanel();
            JLabel step= new JLabel("One step closer to creating your account!");
            nextPanel.add(step);
           
            nextFrame.add(nextPanel);
            nextFrame.setVisible(true);
            }
        });

        frame.setVisible(true);
    }


    private static Dimension Dimension(int i, int j) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Dimension'");
    }
}