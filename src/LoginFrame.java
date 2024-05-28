import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Will appear after the user presses the login button in HomeFrame
public class LoginFrame extends JFrame{
    public LoginFrame(UserCredentials userCredentials) {

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
                       "-Select Language-",  "العربية(Arabic)", "Bengali", "English", "Français (French)", "Deutsch (German)", "हिंदी (Hindi)", 
                       "Indonesia", "日本語 (Japanese)", "中文 (Mandarin Chinese)", "Português (Portuguese Brazil)", 
                       "Русский (Russian)", "Español (Spanish)", "తెలుగు (Telugu)", "اردو(Urdu)"
                    });
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
                          //Submit button
                                submitLanguButton.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        selectLangFrame.dispose();
                                        new LessonHomeFrame(userCredentials,username, selectedLanguage);
                                    }
                                });
        
                                selectLangFrame.setVisible(true);

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
                new HomeFrame(userCredentials);
            }
        });
        loginFrame.setVisible(true);
    }
} 

