import com.toedter.calendar.JCalendar;
import java.time.DayOfWeek;
import java.time.LocalDate;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Calender implements ActionListener {
    //JCalendar jc;
//date library
    JFrame frame;
    JPanel settingPanel;
    JPanel monthPanel;
    JPanel weekPanel;
    JButton setSize;
    JButton setColor;
    private Color color;





    public Calender(){
        frame = new JFrame("Calender");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        //setting the settingPanel, which include change size, change color,
        settingPanel = new JPanel();

        JButton setSize=new JButton("Set Size");
        setSize.addActionListener(this);
        settingPanel.add(setSize);


        JButton setColor=new JButton("Set Color");
        setColor.addActionListener(this);
        settingPanel.add(setColor);



       settingPanel.setSize(1200, 50);


        //setting the monthPanel, the add to frame line is at the bottom
        monthPanel = new JPanel();
        monthPanel.setLayout(new BoxLayout(monthPanel,BoxLayout.Y_AXIS));

        //getting the date, month, and year of user's current date.
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        int currentDay = currentDate.getDayOfMonth();
        DayOfWeek day = currentDate.getDayOfWeek();
        String dayName=day.name();
        System.out.println(dayName);

        JLabel monthYearLabel = new JLabel("Month: " + currentMonth + " Year: " + currentYear);
        monthYearLabel.setFont(new Font("Serif", Font.BOLD, 20));
        monthPanel.add(monthYearLabel);

        String arr[] ={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};



        JPanel namePanel = new JPanel();
        namePanel.setBorder(BorderFactory. createLineBorder(Color. black));

        for(int i=0;i<7;i++){
            System.out.println(arr[i]);
            JLabel dateLabel = new JLabel(arr[i]);
            dateLabel.setLocation(150*i,150);
            namePanel.add(dateLabel);

        }
        monthPanel.add(namePanel);



        for(int dm=1;dm<=currentDate.lengthOfMonth();dm++) {
            JPanel weekPanel = new JPanel();
            weekPanel.setBorder(BorderFactory.createLineBorder(Color.black));
            for (int dw = 1; dw < 8; dw++) {
                JLabel dateLabel = new JLabel(""+dm);
                //the following line help with changing word size and font, can be used in changesize function later.
                // dateLabel.setFont(new Font("Serif",Font.BOLD,30));

                JTextField taskInput = new JTextField(10);
                taskInput.setText("task =");
                String text = taskInput.getText();
                boolean selected = false;
                JButton newTaskButton = new JButton("New Task");
                JCheckBox checkBox = new JCheckBox(text, selected);

                Day d1 = new Day(dateLabel, taskInput, checkBox, newTaskButton);
                d1.setBorder(BorderFactory.createLineBorder(Color.black));

                if (dm == currentDay) {
                    d1.setBackground(Color.BLUE);
                }

                weekPanel.add(d1);
                dm += 1;
            }

            monthPanel.add(weekPanel);
        }







        JPanel panel = new JPanel();
        //panel.add(new JCalendar());
        frame.add(panel,BorderLayout.CENTER);

        frame.add(settingPanel,BorderLayout.NORTH);
        frame.add(monthPanel,BorderLayout.SOUTH);
        frame.setSize(1400, 600);
        frame.setVisible(true);


    }

    public void setColor(Color color) {
        this.color = color;
        monthPanel.setBackground(color);
        for (Component weekPanel : monthPanel.getComponents()) {
            if (weekPanel instanceof JPanel) {
                ((JPanel) weekPanel).setBackground(color);
                for (Component dayPanel : ((JPanel) weekPanel).getComponents()) {
                    if (dayPanel instanceof JPanel) {
                        ((JPanel) dayPanel).setBackground(color);
                    }
                }
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        // If pencilButton is pressed, set drawingPanel mode to "Pencil"
        if (ae.getActionCommand().equals("Set Color")) {

            //String wantedColor = JOptionPane.showInputDialog(frame,"Enter color");
            String str=JOptionPane.showInputDialog(frame,"Enter inputs separated by spaces");
            String [] stringArray = str.split(" ");
            int[] colorIntArray = new int[3];

            for(int i = 0; i<=stringArray.length-1; i++)
            {
                colorIntArray[ i ] = Integer.parseInt( stringArray[ i ] );
            }
            int red=colorIntArray[0];
            int green=colorIntArray[1];
            int blue=colorIntArray[2];

            setColor(new Color(red,green,blue));



        }
    }



    public static void main(String[] args) {
        Calender x = new Calender();

    }
}