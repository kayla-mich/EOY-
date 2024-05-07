import java.awt.Dimension;
import javax.swing.*;


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
        frame.setVisible(true);


    }


    private static Dimension Dimension(int i, int j) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Dimension'");
    }
}