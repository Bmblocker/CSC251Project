import java.util.Scanner;

public class Project_brandon_blocker
{
   public static void main(String[] args)
   {
      String name;
      double length;
      double width;
      String amountOfShade;
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Please enter the name of the room: ");
      name = keyboard.nextLine();
      
      System.out.print("Please enter the length of the room (in feet): ");
      length = keyboard.nextDouble();
      
      System.out.print("Please enter the width of the room (in feet): ");
      width = keyboard.nextDouble();
      
      amountOfShade = setAmountOfShade();
      
      Room Demo = new Room(name, length, width, amountOfShade);
      
      System.out.printf("Room Name: %s" + "\n", Demo.getName());
      System.out.printf("Room Area: %,.1f" + "\n", Demo.getArea());
      System.out.printf("Amount of Shade: %s" + "\n", Demo.getAmountOfShade());
      System.out.printf("BTUs Per Hour needed: %,.0f" + "\n", Demo.getReqCooling());
    }

    public static String setAmountOfShade()
         {
            int shade;
            String amountOfShade;
         
            Scanner keyboard = new Scanner(System.in);
         
            System.out.println("What is the amount of shade that this room receives?");
            System.out.println("\t" + "1. Little Shade");
            System.out.println("\t" + "2. Moderate Shade");
            System.out.println("\t" + "3. Abundant Shade");
            
            System.out.print("Please select from the options above: ");
            shade = keyboard.nextInt();
            
            while (shade < 1 || shade > 3)
                  {
                     System.out.print("Selection Invalid! Please select from the options above: ");
                     shade = keyboard.nextInt();
                  }
            
            switch (shade)
            {
               case 1:
                  amountOfShade = "Little";
                  break;
               case 2:
                  amountOfShade = "Moderate";
                  break;
               case 3:
                  amountOfShade = "Abundant";
                  break;
               default:
                  amountOfShade = "Invalid";
                  break;      
            }
            
            return amountOfShade;
         } //END OF METHOD: setAmountOfShade
}