import java.util.*;

public class BinaryClock
{
	Calendar now;

    public BinaryClock()
    {
    	now = Calendar.getInstance();
    }

    public boolean[] binaryTime()
    {
        /*
        	returns array for binary time
        	[0] - [3] for hours
            [4] - [9] for minutes
            [10] for pm
    	*/
        boolean binaryTime[] = new boolean[11];

        now.setTimeInMillis(System.currentTimeMillis());

        if(now.get(Calendar.AM_PM) == Calendar.PM)
        	binaryTime[10] = true;

        int hours, minutes;

        hours = now.get(Calendar.HOUR);
        minutes = now.get(Calendar.MINUTE);

        boolean help[] = hours2Binary(hours);
        for(int i=0; i<=3; i++)
        		binaryTime[i] = help[i];

        help = minutes2Binary(minutes);
        for(int i=4; i<=9; i++)
        		binaryTime[i] = help[(i-4)];


        return binaryTime;
    }

    private boolean[] hours2Binary(int h)
    {
        boolean binHours[] = new boolean[4];
        for(int i=0; i<binHours.length; i++)
        	binHours[i] = false;

        if(h >= 8)
        {
        	h -= 8;
            binHours[0] = true;
        }

        if(h >= 4)
        {
        	h -= 4;
            binHours[1] = true;
        }

        if(h >= 2)
        {
        	h -= 2;
            binHours[2] = true;
        }

        if(h >= 1)
        {
        	h -= 1;
            binHours[3] = true;
        }
        return binHours;
    }

    private boolean[] minutes2Binary(int m)
    {
        boolean binMinutes[] = new boolean[6];
        for(int i=0; i<binMinutes.length; i++)
        	binMinutes[i] = false;

        if(m >= 32)
        {
        	m -= 32;
            binMinutes[0] = true;
        }

        if(m >= 16)
        {
        	m -= 16;
            binMinutes[1] = true;
        }

        if(m >= 8)
        {
        	m -= 8;
            binMinutes[2] = true;
        }

        if(m >= 4)
        {
        	m -= 4;
            binMinutes[3] = true;
        }

        if(m >= 2)
        {
        	m -= 2;
            binMinutes[4] = true;
        }

        if(m >= 1)
        {
        	m -= 1;
            binMinutes[5] = true;
        }
        return binMinutes;
    }
}