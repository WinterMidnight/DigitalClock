import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DigitalClock extends JFrame {

    private JLabel timeLabel;
    private SimpleDateFormat timeFormat;
    private Timer timer;

    public DigitalClock() {
        setTitle("Digital Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        timeLabel.setForeground(Color.GREEN);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);

        panel.add(timeLabel, BorderLayout.CENTER);
        add(panel);
      
        timeFormat = new SimpleDateFormat("HH:mm:ss");

        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the current time
                Date currentTime = new Date();

                // Format the time
                String time = timeFormat.format(currentTime);

                // Update the time label
                timeLabel.setText(time);
            }
        });

        timer.start();
        setSize(300, 200);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}
