import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;


public class HomeFrame extends JFrame {
    public HomeFrame(UserCredentials userCredentials) {
        setTitle("Home Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 600);
        setMinimumSize(new Dimension(300,300));
       
        JPanel homePanel = new JPanel();
      //homePanel.setLayout(new LayoutManager());
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




        add(homePanel);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            new LoginFrame(userCredentials);
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SignUpFrame(userCredentials);
            }
        });
        setVisible(true);


    }


}


