import javax.swing.JOptionPane;

public class Greeter
{
    public void sayHello()
    {
        JOptionPane.showMessageDialog(null,
            "Hello, World!", "Greeter", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}
