import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class LessonHomeFrame extends JFrame{
    public LessonHomeFrame(UserCredentials userCredentials, String username, String selectedLanguage) {
    JFrame lessonHomeFrame= new JFrame("Home Lesson");
    lessonHomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    lessonHomeFrame.setSize(300,600);
    lessonHomeFrame.setMinimumSize(new Dimension(300,300));


        JPanel lessonHomePanel= new JPanel();
        lessonHomePanel.setLayout(null);         
        lessonHomePanel.setBackground(new Color(128,128,255));
        
        JLabel nameUser= new JLabel(username);
        nameUser.setFont(new Font("Arial", Font.BOLD, 25));
        nameUser.setBounds(15, 5, 240, 50);
        lessonHomePanel.add(nameUser);
       
        JLabel languLabel= new JLabel(selectedLanguage);
        languLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        languLabel.setBounds(15, 30, 240, 50);
        lessonHomePanel.add(languLabel);


        ImageIcon chatlogoLabel = new ImageIcon("chatGPTl.png");
        Image image = chatlogoLabel.getImage();
        Image resizedImage = image.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JButton askChatGPTButton = new JButton(resizedIcon);
        askChatGPTButton.setBounds(235, 10, 25, 25);
        lessonHomePanel.add(askChatGPTButton);

        
        /* Image image = buttonImag.getImage();  
        Image newimg = image.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH); 
        ImageIcon resizedIcon = new ImageIcon(newimg);  
        JLabel chatlogoLabel = new JLabel(resizedIcon);
        chatlogoLabel.setBounds(210, 10, 25, 25);
        lessonHomePanel.add(chatlogoLabel);
      */  
        JLabel askChatGPTLabel = new JLabel("Ask Chat GPT");
        askChatGPTLabel.setBounds(200, 40, 115, 15);
        askChatGPTLabel.setPreferredSize(new Dimension(115, 15));
        lessonHomePanel.add(askChatGPTLabel);
       
        askChatGPTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           System.out.println("Works!");
            }
    });


        /* askChatGPTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a dialog or new frame for user to input their question
                String userQuestion = JOptionPane.showInputDialog(lessonHomeFrame, "Ask ChatGPT in " + selectedLanguage + ":");
                if (userQuestion != null && !userQuestion.trim().isEmpty()) {
                    // Process the user question, possibly send to ChatGPT API
                    // For demonstration, we simply show a message dialog
                    JOptionPane.showMessageDialog(lessonHomeFrame, "Your question: " + userQuestion + "\nLanguage: " + selectedLanguage);
                }
            }
        });
         */

        JLabel unit1= new JLabel("Unit 1: Basics and Introductions");
        unit1.setFont(new Font("Britannic", Font.BOLD, 17));
        unit1.setBounds(15, 60, 275, 50);
        lessonHomePanel.add(unit1);


        JLabel u1Lesson1= new JLabel("Lesson 1");
        u1Lesson1.setFont(new Font("Britannic", Font.PLAIN, 15));
        u1Lesson1.setBounds(15, 90, 150, 25);
        lessonHomePanel.add(u1Lesson1);
        JButton u1Lesson1Button= new JButton("Greetings and Introduction");
        u1Lesson1Button.setFont(new Font("Arial", Font.PLAIN, 10));
        u1Lesson1Button.setBounds(15,115,170,20);
        lessonHomeFrame.add(u1Lesson1Button);


        

        JLabel u1Lesson2= new JLabel("Lesson 2");
        u1Lesson2.setFont(new Font("Britannic", Font.PLAIN, 15));
        u1Lesson2.setBounds(15, 135, 150, 25);
        lessonHomePanel.add(u1Lesson2);
        JButton u1Lesson2Button= new JButton("Colors and Shapes");
        u1Lesson2Button.setFont(new Font("Arial", Font.PLAIN, 10));
        u1Lesson2Button.setBounds(15,160,150,20);
        lessonHomeFrame.add(u1Lesson2Button);
       
        JLabel u1Lesson3= new JLabel("Lesson 3");
        u1Lesson3.setFont(new Font("Britannic", Font.PLAIN, 15));
        u1Lesson3.setBounds(15, 185, 150, 25);
        lessonHomePanel.add(u1Lesson3);
        JButton u1Lesson3Button= new JButton("Numbers and Counting");
        u1Lesson3Button.setFont(new Font("Arial", Font.PLAIN, 10));
        u1Lesson3Button.setBounds(15,210,150,20);
        lessonHomeFrame.add(u1Lesson3Button);

        JLabel U1Test= new JLabel("Unit 1 Test");
        U1Test.setFont(new Font("Britannic", Font.PLAIN, 15));
        U1Test.setBounds(15, 235, 150, 25);
        lessonHomePanel.add(U1Test);
        JButton u1TestButton= new JButton("Test 1");
        u1TestButton.setFont(new Font("Arial", Font.PLAIN, 10));
        u1TestButton.setBounds(15,260,75,20);
        lessonHomeFrame.add(u1TestButton);



//2nd unit
        JLabel unit2= new JLabel("Unit 2: Daily Life");
        unit2.setFont(new Font("Britannic", Font.BOLD, 17));
        unit2.setBounds(15, 295, 275, 50);
        lessonHomePanel.add(unit2);


        JLabel u2Lesson1= new JLabel("Lesson 1");
        u2Lesson1.setFont(new Font("Britannic", Font.PLAIN, 15));
        u2Lesson1.setBounds(15, 320, 150, 25);
        lessonHomePanel.add(u2Lesson1);
        JButton u2Lesson1Button= new JButton("Days of the Week");
        u2Lesson1Button.setFont(new Font("Arial", Font.PLAIN, 10));
        u2Lesson1Button.setBounds(15,345,170,20);
        lessonHomeFrame.add(u2Lesson1Button);

        JLabel u2Lesson2= new JLabel("Lesson 2");
        u2Lesson2.setFont(new Font("Britannic", Font.PLAIN, 15));
        u2Lesson2.setBounds(15, 365, 150, 25);
        lessonHomePanel.add(u2Lesson2);
        JButton u2Lesson2Button= new JButton("Food and Drink");
        u2Lesson2Button.setFont(new Font("Arial", Font.PLAIN, 10));
        u2Lesson2Button.setBounds(15,390,150,20);
        lessonHomeFrame.add(u2Lesson2Button);
       
        JLabel u2Lesson3= new JLabel("Lesson 3");
        u2Lesson3.setFont(new Font("Britannic", Font.PLAIN, 15));
        u2Lesson3.setBounds(15, 410, 150, 25);
        lessonHomePanel.add(u2Lesson3);
        JButton u2Lesson3Button= new JButton("Daily Routines");
        u2Lesson3Button.setFont(new Font("Arial", Font.PLAIN, 10));
        u2Lesson3Button.setBounds(15,435,150,20);
        lessonHomeFrame.add(u2Lesson3Button);

        JLabel U2Test= new JLabel("Unit 2 Test");
        U2Test.setFont(new Font("Britannic", Font.PLAIN, 15));
        U2Test.setBounds(15, 455, 150, 25);
        lessonHomePanel.add(U2Test);
        JButton u2TestButton= new JButton("Test 2");
        u2TestButton.setFont(new Font("Arial", Font.PLAIN, 10));
        u2TestButton.setBounds(15,480,75,20);
        lessonHomeFrame.add(u2TestButton);




        lessonHomeFrame.add(lessonHomePanel);
        lessonHomeFrame.setVisible(true);

    }
}
