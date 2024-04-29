import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    @SuppressWarnings("unused")
    final private Font mainFont= new Font("Segoe print", Font.BOLD, 18);
    JTextField tfNAME, tfUserName;

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "true");

        JFrame frame = new JFrame("My First JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JPanel mainPanel = new JPanel();
        //mainPanel.setBackground(new Color(128, 785, 255));


        frame.setTitle("App Learner");
        //Dimension minimumSize - MainFrame.main(String[])
        //frame.setMinimumSize(Dimension minimumSize);
        frame.setSize(300, 300);


        frame.setMinimumSize(new Dimension(300,300));
        frame.setVisible(true);


    }


    
}

