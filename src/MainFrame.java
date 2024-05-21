import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.HashMap;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
//Whole Stack of code
public class MainFrame extends JFrame {
   
    private static HashMap<String, String> userCredentials = new HashMap<>();
    public static void main(String[] args) {


        JFrame homeFrame= new JFrame("Home Screen");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setSize(300, 600);
        homeFrame.setMinimumSize(new Dimension(300,300));
       
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new FlowLayout());
        homePanel.setBackground(new Color(128, 128, 255));
       
        JLabel appLabel= new JLabel("LinguaLure");
        appLabel.setHorizontalAlignment(SwingConstants.CENTER);
        appLabel.setFont(new Font("Arial", Font.BOLD, 50));
        homePanel.add(appLabel);
        JLabel spaceLabel= new JLabel("  ");
        spaceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        spaceLabel.setFont(new Font("Arial", Font.BOLD, 130));
        homePanel.add(spaceLabel);
        ImageIcon imageIcon = new ImageIcon("translation.png");
         Image image = imageIcon.getImage();  
        Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(newimg);  
        JLabel appimageLabel = new JLabel(resizedIcon);
        homePanel.add(appimageLabel);
        JLabel spaceLabel1= new JLabel("  ");
        spaceLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        spaceLabel1.setFont(new Font("Arial", Font.BOLD, 130));
        homePanel.add(spaceLabel1);
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
                    selectLangFrame.setSize(300, 600);
           
                    JPanel nextPanel = new JPanel();
                    JLabel step= new JLabel("Congrats! Now select the ");
                    nextPanel.add(step);
                    JLabel step1= new JLabel("language you would like to learn!");
                    nextPanel.add(step1);
                    selectLangFrame.add(nextPanel);
                    //Dropdown of the languages
                    JComboBox<String> languageComboBox = new JComboBox<>(new String[]{
                       "-Select Language-", "Mandarin Chinese", "Spanish", "English", "Hindi", "Arabic",
                        "Portuguese", "Bengali", "Russian", "Japanese", "Urdu",
                        "Indonesian", "German", "French", "Telugu" });
                    nextPanel.add(languageComboBox);
                    JButton submitLanguButton= new JButton("Submit");
                    submitLanguButton.setPreferredSize(new Dimension(75, 30));
                   nextPanel.add(submitLanguButton);
                 
                     languageComboBox.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String selectedLanguage = (String) languageComboBox.getSelectedItem();
                             System.out.println("Selected Language: " + selectedLanguage);
                             if (!selectedLanguage.equals("-Select Language-")) {
                                submitLanguButton.setVisible(true);
                            } else {
                                submitLanguButton.setVisible(false);
                            }
                            }
                    });
                   
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
signUpButton.addActionListener(new ActionListener() {
    @Override
   public void actionPerformed(ActionEvent e){
    homeFrame.dispose();
       
 
    JFrame signFrame = new JFrame("Sign Up");


         //Dimension minimumSize - MainFrame.main(String[])
        //frame.setMinimumSize(Dimension minimumSize);
        signFrame.setSize(300, 600);


        signFrame.setMinimumSize(new Dimension(300,300));      


        //Allows  do add different componets for screen
        JPanel signpanel = new JPanel();
        signpanel.setLayout(new FlowLayout());
        signpanel.setBackground(new Color(128,128,255));


        //Text labels and text fields
        JLabel name= new JLabel("Name");
        JTextField textName= new JTextField(15);
        //makes the size of the my choice
        textName.setPreferredSize(new Dimension(10, 25));
        signpanel.add(name);
        signpanel.add(textName);
        JLabel user= new JLabel("Username");
        JTextField textUser= new JTextField(15);
        textUser.setPreferredSize(new Dimension(10, 25));
        signpanel.add(user);
        signpanel.add(textUser);
        JLabel pass= new JLabel("Password");
        JPasswordField textpass= new JPasswordField(15);
        textpass.setPreferredSize(new Dimension(10, 25));
        signpanel.add(pass);
        signpanel.add(textpass);
       
        //Adds the button on the screen
        JButton submitButton= new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(75, 30));
        signpanel.add(submitButton);
        JCheckBox showPasswordCheckBox= new JCheckBox("Show Password");
        signpanel.add(showPasswordCheckBox);
        JButton backSignButton = new JButton("Back");
        backSignButton.setPreferredSize(new Dimension(75, 30));
        signpanel.add(backSignButton);






        signFrame.add(signpanel);


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
        backSignButton.addActionListener(new ActionListener() {
              @Override
            public void actionPerformed(ActionEvent e){
                signFrame.dispose();
                homeFrame.setVisible(true);
            }
        });


        submitButton.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e){
                signFrame.dispose();
                homeFrame.setVisible(true);
                String name = textName.getText();
                String username = textUser.getText();
                char[] password= textpass.getPassword();
                String passwordString = new String(password);
                // Store credentials
                if (username.isEmpty() || passwordString.isEmpty()) {
                    JOptionPane.showMessageDialog(signFrame, "Please fill out both username and password fields.");
                    submitButton.setEnabled(false);
                } else {
                if (userCredentials.containsKey(username)) {
                    JOptionPane.showMessageDialog(signFrame, "Username already exists. Try a different one.");


                } else {
                    // Store the credentials in the HashMap
                    userCredentials.put(username, passwordString);
                    JOptionPane.showMessageDialog(signFrame, "Sign-up successful! You can now log in.");
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + passwordString);
                   
                }
                java.util.Arrays.fill(password, '\0');
              }
            }
        });
        signFrame.setVisible(true);
    }
});  
homeFrame.setVisible(true);
 
}








    private static Dimension Dimension(int i, int j) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Dimension'");
    }
}










