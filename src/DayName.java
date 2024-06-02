import javax.swing.*;
import java.awt.*;

public class DayName extends JPanel {
    private String name;


    public DayName(String name) {
        this.name = name;
        JLabel dayName = new JLabel(name);
        dayName.setSize(100, 30);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Color lightYellow=new Color(255, 183, 3);
        setBackground(lightYellow);
        setPreferredSize(new Dimension(190,30));
        setBorder(BorderFactory.createLineBorder(Color.black));
        add(dayName);
    }
}
