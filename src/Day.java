import javax.swing.*;


public class Day extends JPanel{
    private JLabel date;
    private JTextField taskInput;
    private JCheckBox checkBox;

    private JButton newTaskButton;

        public Day(JLabel date, JTextField taskInput, JCheckBox checkBox, JButton newTaskButton) {
        this.date=date;
        this.taskInput=taskInput;
        this.checkBox=checkBox;
        this.newTaskButton=newTaskButton;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        add(date);
        add(taskInput);
        add(checkBox);
        add(newTaskButton);




        }
    }

