import javax.swing.*;
import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Calender {

    JFrame frame;
    JPanel settingPanel;
    JPanel monthPanel;
    JPanel weekPanel;
    JButton setSize;
    JButton setColor;





    public Calender(){
        frame = new JFrame("Calender");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //setting the settingPanel, which include change size, change color,
        JPanel settingPanel = new JPanel();

        JButton setSize=new JButton("Set Size");
        JButton setColor=new JButton("Set Color");

        settingPanel.add(setSize);
        settingPanel.add(setColor);


       settingPanel.setSize(1200, 50);


        //setting the monthPanel, the add to frame line is at the bottom
        JPanel monthPanel = new JPanel();
        monthPanel.setLayout(new BoxLayout(monthPanel,BoxLayout.Y_AXIS));


        for(int w=0;w<4;w++){
            JPanel weekPanel = new JPanel();
            weekPanel.setBorder(BorderFactory. createLineBorder(Color. black));
            for(int d=0;d<7;d++){
                //Initializing all objects in the day panel.
                JLabel dateLabel = new JLabel("This is day "+(w*7+d+1));
                JTextField taskInput = new JTextField(10);
                taskInput.setText("task =");
                String text = taskInput.getText();
                boolean selected = false;
                JButton newTaskButton = new JButton("New Task");
                JCheckBox checkBox = new JCheckBox(text, selected);

                Day d1 = new Day(dateLabel, taskInput, checkBox,newTaskButton);
                d1. setBorder(BorderFactory. createLineBorder(Color. black));

                weekPanel.add(d1);



            }
            monthPanel.add(weekPanel);

        }



        frame.add(settingPanel,BorderLayout.NORTH);
        frame.add(monthPanel,BorderLayout.SOUTH);
        frame.setSize(1400, 600);
        frame.setVisible(true);


    }



    public static void main(String[] args) {
        Calender x = new Calender();


    }
}