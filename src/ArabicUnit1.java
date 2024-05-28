import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ArabicUnit1 extends JFrame {
    private int score;


    public ArabicUnit1(UserCredentials userCredentials, String username, String selectedLanguage) {
        setTitle("Arabic Unit 1 Quiz");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JPanel panel = new JPanel();
        JLabel questionLabel = new JLabel("What is the Arabic word for 'hello'?");
        panel.add(questionLabel);


        JTextField answerField = new JTextField(10);
        panel.add(answerField);


        JButton submitButton = new JButton("Submit");
        panel.add(submitButton);


        add(panel);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answer = answerField.getText().trim();
                if (answer.equalsIgnoreCase("مرحبا")) {
                    score = 100;
                    JOptionPane.showMessageDialog(null, "Correct! Your score: " + score);
                } else {
                    score = 0;
                    JOptionPane.showMessageDialog(null, "Incorrect. Your score: " + score);
                }
                dispose();
                new LessonHomeFrame(userCredentials, username, selectedLanguage);
            }
        });


        setVisible(true);
    }


    public int getScore() {
        return score;
    }
}


