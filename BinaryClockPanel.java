import javax.swing.*;
import java.awt.*;

public class BinaryClockPanel extends JPanel
{
    private BinaryClock clock;
    private Insets ins;
    private JLabel LEDs[];
    private GridBagLayout gridbag;
    private ImageIcon active, inactive;

    public BinaryClockPanel()
    {
        super();

        clock = new BinaryClock();
        ins = new Insets(1,1,1,1);
        LEDs = new JLabel[11];
        gridbag = new GridBagLayout();
        active = new ImageIcon(ClassLoader.getSystemResource("active.png"), "1");
        inactive = new ImageIcon(ClassLoader.getSystemResource("inactive.png"), "0");
        
        this.setLayout(gridbag);
        this.setOpaque(false);

        // Add labels for describing texts
        addComponent(new JLabel("8"), 0, 0, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(new JLabel("4"), 0, 1, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(new JLabel("2"), 0, 2, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(new JLabel("1"), 0, 3, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(new JLabel("PM"), 0, 5, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(new JLabel("32"), 2, 0, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(new JLabel("16"), 2, 1, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(new JLabel("8"), 2, 2, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(new JLabel("4"), 2, 3, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(new JLabel("2"), 2, 4, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(new JLabel("1"), 2, 5, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);

        // loading LEDs
        for(int i=0; i<11; i++)
            LEDs[i] = new JLabel("", inactive, JLabel.CENTER);

        // adding LEDs to Panel
        addComponent(LEDs[0], 1, 0, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(LEDs[1], 1, 1, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(LEDs[2], 1, 2, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(LEDs[3], 1, 3, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(LEDs[10], 1, 5, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(LEDs[4], 3, 0, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(LEDs[5], 3, 1, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(LEDs[6], 3, 2, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(LEDs[7], 3, 3, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(LEDs[8], 3, 4, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
        addComponent(LEDs[9], 3, 5, 1, 1, 20, 20, GridBagConstraints.NONE, GridBagConstraints.CENTER, ins);
    }

    public void update()
    {
        boolean time[] = clock.binaryTime();
        for(int i=0; i<11; i++)
            if(time[i] && LEDs[i].getIcon() != active)
                LEDs[i].setIcon(active);
            else if(!time[i] && LEDs[i].getIcon() != inactive)
                LEDs[i].setIcon(inactive);

        try { Thread.sleep(100); } catch(InterruptedException e) {}
        update();
    }

    private void addComponent(Component component, int gridy, int gridx, int gridwidth, int gridheight, int weightx, int weighty, int fill, int anchor, Insets ins)
    {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.weightx = weightx;
        constraints.weighty = weighty;
        constraints.fill = fill;
        constraints.anchor = anchor;
        constraints.insets = ins;
        gridbag.setConstraints(component, constraints);
        add(component);
    }
}