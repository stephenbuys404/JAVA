public class TenPennies
{
    public static void main (String[] args)
    {
        System.out.println("Welcome to the New Math…"
            + "Or, Why Java Can't Add\n");
        double penny = 0.01;          
        double dime = 0.10;           

        double tenPennies = 0;
        for (int i = 0; i < 10; i++)  
            tenPennies += penny;

        System.out.println("A dime is " + dime);
        System.out.println("Ten pennies is " +
            tenPennies);

        if (tenPennies == dime)
            System.out.println(
                "Ten Pennies is equal to a dime.");
        else
            System.out.println(
                "Ten pennies is NOT equal to a dime!");
    }
}
