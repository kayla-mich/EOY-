import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//This work was done at home in my laptop
public class MainFrame extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JPanel mainPanel = new JPanel();
        //mainPanel.setBackground(new Color(128, 128, 255));


        frame.setTitle("App Learner");
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