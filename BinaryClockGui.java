import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class BinaryClockGui
{
	private JFrame clockFrame;
    private BinaryClockPanel binClockPanel;
    private ImageIcon statusIcon;

    public BinaryClockGui()
    {
    	clockFrame = new JFrame("KADS Binary Clock 2.0");
        binClockPanel = new BinaryClockPanel();
        statusIcon = new ImageIcon(ClassLoader.getSystemResource("status.png"));

        clockFrame.setResizable(false);
        clockFrame.setBounds(10, 10, 160, 120);
        clockFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clockFrame.setIconImage(statusIcon.getImage());
        clockFrame.setAlwaysOnTop(true);
        clockFrame.setLayout(new FlowLayout());
        clockFrame.add(binClockPanel);
        //clockFrame.pack();
        clockFrame.setVisible(true);

        binClockPanel.update();
    }

    public static void main(String[] args)
    {
    	BinaryClockGui kadsBinClock = new BinaryClockGui();
    }
}