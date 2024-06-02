import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Day extends JPanel implements ActionListener {
    private JLabel date;
    private JTextField taskInput;
    private TaskLine taskline;





    public Day(JLabel date, JTextField taskInput, JCheckBox checkBox, JButton newTaskButton, JButton input) {
        this.date = date;
        this.taskInput = taskInput;
        //this.input = input;
        //this.checkBox = checkBox;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        add(date);
        add(taskInput);
        add(input);

        newTaskButton.addActionListener(this);
        input.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Input")) {
            System.out.println("clicked");

            JCheckBox checkBox = new JCheckBox();
            JLabel task= new JLabel(taskInput.getText());
            System.out.println(""+taskInput.getText());
            TaskLine line1 = new TaskLine(checkBox,task);
            add(line1);

            taskInput.setText("");
            revalidate();
            repaint();

        }
    }



}
