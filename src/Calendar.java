import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Calendar implements ActionListener {
    JFrame frame;
    JPanel settingPanel;
    JPanel monthPanel;
    JPanel dayNamePanel;
    JLabel monthYearLabel;
    JButton setColor;
    LocalDate currentDate;
    int currentYear;
    int currentMonth;
    int currentDay;
    Color lightBlue=new Color(142, 202, 230);
    Color darkBlue=new Color(2, 48, 71);
    Color lightYellow=new Color(255, 183, 3);
    Color darkYellow=new Color(251, 133, 0);

    int[][] colorList={
            {205, 180, 219},
            {255, 175, 204},
            {189, 224, 254},
            {162, 210, 255},

            {0, 48, 73},
            {214, 40, 40},
            {252, 191, 73},
            {234, 226, 183},

            {255, 190, 11},
            {255, 0, 110},
            {131, 56, 236},
            {58, 134, 255},

            {38, 70, 83},
            {233, 196, 106},
            {244, 162, 97},
            {231, 111, 81},

            {255, 180, 162},
            {229, 152, 155},
            {181, 131, 141},
            {109, 104, 117},

            {34, 87, 122},
            {87, 204, 153},
            {128, 237, 153},
            {199, 249, 204},

    };


    public Calendar(){
        frame = new JFrame("Calender");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        //setting the settingPanel, which include change size, change color,
        settingPanel = new JPanel();

        JButton setColor=new JButton("Set Color");
        setColor.addActionListener(this);
        settingPanel.add(setColor);

        JButton alterColor=new JButton("Alter Color Palette");
        alterColor.addActionListener(this);
        settingPanel.add(alterColor);


        JButton last=new JButton("Last month");
        last.addActionListener(this);
        settingPanel.add(last);

        JButton next=new JButton("Next month");
        next.addActionListener(this);
        settingPanel.add(next);

        settingPanel.setBackground(darkBlue);
        settingPanel.setPreferredSize(new Dimension(1400, 40));
        settingPanel.setMinimumSize(new Dimension(1400, 40));
        settingPanel.setMaximumSize(new Dimension(1400, 40));

        //setting the monthPanel, the add to frame line is at the bottom
        monthPanel = new JPanel(new GridLayout(0,7));

        //getting the date, month, and year of user's current date.
        currentDate = LocalDate.now();
        currentYear = currentDate.getYear();
        currentMonth = currentDate.getMonthValue();
        currentDay = currentDate.getDayOfMonth();
        DayOfWeek day = currentDate.getDayOfWeek();
        String dayName=day.name();
        frame.setBackground(lightBlue);

        //below is the namePanel that contains string monday to sunday. It will be placed on top of the calendar.
       dayNamePanel = new JPanel();
        String arr[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (int i = 0; i < 7; i++) {
            DayName di = new DayName(arr[i]);
            di.setBackground(lightYellow);
            dayNamePanel.add(di);
        }
        dayNamePanel.setPreferredSize(new Dimension(1400, 40));
        dayNamePanel.setMinimumSize(new Dimension(1400, 40));
        dayNamePanel.setMaximumSize(new Dimension(1400, 40));

        // setting the monthYearLabel
        monthYearLabel = new JLabel();
        monthYearLabel.setFont(new Font("Serif", Font.BOLD, 20));
        updateMonthYearLabel();
        updateCalendar(currentDate);


        //add everything into the frame
        frame.add(settingPanel);
        frame.add(monthYearLabel);
        frame.add(dayNamePanel);
        frame.add(monthPanel);
        frame.setSize(1400, 760);
        frame.setVisible(true);
    }

    private void updateMonthYearLabel() {
        monthYearLabel.setText("Month: " + currentMonth + " Year: " + currentYear);
    }

    public void updateCalendar(LocalDate currentDate) {
        monthPanel.removeAll();
        monthPanel.revalidate();
        monthPanel.repaint();

        currentYear = currentDate.getYear();
        currentMonth = currentDate.getMonthValue();
        currentDay = currentDate.getDayOfMonth();

        monthYearLabel.setText("Month: " + currentMonth + " Year: " + currentYear);

        //setting the date panels for the current month.
        int leapYear[]={31,29,31,30,31,30,31,31,30,31,30,31};
        int nonLeapYear[]={31,28,31,30,31,30,31,31,30,31,30,31};

        LocalDate firstDayOfMonth = LocalDate.of(currentYear, currentMonth, 1);
        int startDay = firstDayOfMonth.getDayOfWeek().getValue();
        System.out.println(startDay);

        if(currentDate.isLeapYear()){
            for(int i=0;i<startDay%7;i++){
                monthPanel.add(new JLabel(""));
            }
            for (int dm = 1; dm <=leapYear[currentMonth-1] ; dm++) {
                for (int dw = 1; dw < 8; dw++) {
                    if(dm<leapYear[currentMonth-1]+1) {
                        Day d1 = getDay(dm, currentMonth, currentYear);
                        monthPanel.add(d1);
                        dm += 1;
                    }
                }
            }
        }

        else {
            for(int i=1;i<=startDay%7;i++){
                monthPanel.add(new JLabel(""));
            }
            for (int dm = 1; dm <=nonLeapYear[currentMonth-1] ; dm++) {
                for (int dw = 1; dw < 8; dw++) {
                    if(dm<nonLeapYear[currentMonth-1]+1) {
                        Day d1 = getDay(dm, currentMonth, currentYear);
                        monthPanel.add(d1);
                        dm += 1;
                    }
                }
            }

        }
        monthPanel. setBorder(BorderFactory.createLineBorder(Color.black));
        frame.add(monthPanel);
        frame.revalidate();
    }


    private Day getDay(int dm, int cm, int cy) {
        JLabel dateLabel = new JLabel("" + dm);
        JTextField taskInput = new JTextField(10);
        taskInput.setText("");
        String text = taskInput.getText();
        boolean selected = false;
        JButton newTaskButton = new JButton("New Task");
        JButton inputButton = new JButton("Input");
        JCheckBox checkBox = new JCheckBox(text, selected);

        Day d1 = new Day(dateLabel, taskInput, checkBox, newTaskButton, inputButton);
        d1.setBorder(BorderFactory.createLineBorder(Color.black));

        d1.setBackground(lightBlue);

        if ((dm == currentDay&&cm==currentMonth) &&(cy==currentYear)){
            d1.setBackground(darkYellow);
        }
        return d1;
    }


    public void setColor(Color color1, Color color2,Color color3,Color color4) {
        monthPanel.setBackground(color1);
        for (Component weekPanel : monthPanel.getComponents()) {
            if (weekPanel instanceof JPanel) {
                ((JPanel) weekPanel).setBackground(color1);
                for (Component dayPanel : ((JPanel) weekPanel).getComponents()) {
                    if (dayPanel instanceof JPanel) {
                        ((JPanel) dayPanel).setBackground(color1);
                    }
                }
            }
        }
        settingPanel.setBackground(color2);
        monthYearLabel.setBackground(color3);
        dayNamePanel.setBackground(color4);
        for(Component DayName:dayNamePanel.getComponents()){
            DayName.setBackground(color4);
        }

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Set Color")) {
            System.out.println("set color pressed");
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
            Color c=new Color(red,green,blue);
            setColor(c,c,c,c);
            currentMonth++;
            System.out.println(currentMonth);
        }

        if(ae.getActionCommand().equals("Next month")){
            currentDate= currentDate.plusMonths(1);
            updateCalendar(currentDate);
        }

        if(ae.getActionCommand().equals("Last month")){
            currentDate= currentDate.minusMonths(1);
            updateCalendar(currentDate);
        }
        if(ae.getActionCommand().equals("Alter Color Palette")){
            int r =(int)(Math.random()*5)+1;
            System.out.println(r);
            Color c1=new Color(colorList[r*4][0],colorList[r*4][1],colorList[r*4][2]);
            Color c2=new Color(colorList[r*4+1][0],colorList[r*4+1][1],colorList[r*4+1][2]);
            Color c3=new Color(colorList[r*4+2][0],colorList[r*4+2][1],colorList[r*4+2][2]);
            Color c4=new Color(colorList[r*4+3][0],colorList[r*4+3][1],colorList[r*4+3][2]);

            setColor(c1,c2,c3,c4);

        }
    }

    public static void main(String[] args) {
        Calendar x = new Calendar();

        //the following line help with changing word size and font, can be used in changesize function later.
        // dateLabel.setFont(new Font("Serif",Font.BOLD,30));
    }
}