import java.awt.event.*;
import javax.swing.*;
public class TickTock
{
    public static void main(String[] args)
    {
        Timer t = new Timer(1000, new Ticker());
        t.start();
        JOptionPane.showMessageDialog(null,"Click OK to exit program");
    }
}
class Ticker implements ActionListener
{
    private boolean tick = true;
    public void actionPerformed(ActionEvent event)
    {
        if (tick)
        {
            System.out.println("Tick...");
        }
        else
        {
            System.out.println("Tock...");
        }
        tick = !tick;
    }
}
