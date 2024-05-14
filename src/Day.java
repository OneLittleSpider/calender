import javax.swing.*;


public class Day extends JPanel{
    private JLabel day;
    private JTextField taskInput;
    private JCheckBox checkBox;

        public Day(JLabel day, JTextField taskInput, JCheckBox checkBox) {
        this.day=day;
        this.taskInput=taskInput;
        this.checkBox=checkBox;

        add(day);
        add(taskInput);
        add(checkBox);



        }
    }

