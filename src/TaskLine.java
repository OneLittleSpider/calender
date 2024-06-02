import javax.swing.*;
    public class TaskLine extends JPanel{
        private JCheckBox checkBox;
        private JLabel task;


        public TaskLine(JCheckBox checkBox,JLabel task){
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

            this.checkBox = checkBox;
            this.task=task;

            add(checkBox);
            add(task);

        }
}
