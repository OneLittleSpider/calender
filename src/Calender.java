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
        frame.setLayout(new BorderLayout());

        JPanel monthPanel = new JPanel();
        monthPanel.setLayout(new BoxLayout(monthPanel,BoxLayout.X_AXIS));
        for(int i=0;i<5;i++){
            JLabel dayLabel = new JLabel("This is day"+i);

            JTextField taskInput = new JTextField(10);
            taskInput.setText("task 1=");
            String text = taskInput.getText();

            boolean selected = false;

            JCheckBox checkBox = new JCheckBox(text, selected);
            Day d1 = new Day(dayLabel, taskInput, checkBox);
            monthPanel.add(d1);



        }



        frame.add(monthPanel,BorderLayout.CENTER);

        frame.setSize(500, 500);
        frame.setVisible(true);


    }



    public static void main(String[] args) {
        Calender x = new Calender();
    }
}