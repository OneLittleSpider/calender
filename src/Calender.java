import javax.swing.*;
import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Calender {

    JFrame frame;
    JPanel monthPanel;

    public Calender(){
        frame = new JFrame("Calender");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel monthPanel = new JPanel();
        for(int i=0;i<5;i++){
            JLabel dayLabel = new JLabel("this is a panel"+i);
            JTextField textField = new JTextField(10 );
            String text = textField.getText();
            boolean selected = false;
            JCheckBox checkBox = new JCheckBox(text, selected);
            Day day = new Day(dayLabel, textField, checkBox);
            monthPanel.add(day);
        }


        frame.add(monthPanel);

        frame.setSize(500, 500);
        frame.setVisible(true);


    }



    public static void main(String[] args) {
        Calender x = new Calender();
    }
}