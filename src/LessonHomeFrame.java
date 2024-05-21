import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;


public class LessonHomeFrame extends JFrame{
    public LessonHomeFrame(UserCredentials userCredentials) {
    JFrame lessonHomeFrame= new JFrame("Home Lesson");
    lessonHomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    lessonHomeFrame.setSize(300,600);
    lessonHomeFrame.setMinimumSize(new Dimension(300,300));




        JPanel lessonHomePanel= new JPanel();
        lessonHomePanel.setLayout(new FlowLayout());
        lessonHomePanel.setBackground(new Color(128,128,255));


    }
}




