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


public class SignUpFrame {
    public SignUpFrame(UserCredentials userCredentials) {
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
               new HomeFrame(userCredentials);
            }
       });


       submitButton.addActionListener(new ActionListener() {
          @Override
           public void actionPerformed(ActionEvent e){
               signFrame.dispose();
               new HomeFrame(userCredentials);
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
}



