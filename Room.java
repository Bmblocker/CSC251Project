import java.util.Scanner;

public class Room
{
   
   // FIELDS
      
      // Variables
      private String nameOfRoom;
      private double roomLength; // Length of room in feet
      private double roomWidth;  // Width of room in feet
      private String amountOfShade;  // Amount of shade the room gets (Can be Little, Moderate, or Abundant)
      //private double reqCooling; // Required Cooling Capacity (Hint: this is a calculated amount based on the attributes above -
                                 // make sure to avoid having a stale value for this. Try Using method. 
      
      // Constants
      private final double LITTLE_SHADE = 1.15;  // If the room has little shade, then the BTU capacity should be increased by 15%
      private final double MODERATE_SHADE = 1;   // If room get moderate shade, then the BTU capacity is should not be changed
      private final double ABUNDANT_SHADE = .9;  // If the room has abundant shade, then the BTU capacity should be decreased by 10%
           
   // CONSTRUCTORS 
      public Room()
      {
         roomWidth = 0;
         roomLength = 0;
      } // END OF CONSTRUCTOR: Room (no args)
      
      public Room(String name, double wid, double len, String shade)
      {
         nameOfRoom = name;
         roomWidth = wid;
         roomLength = len;
         amountOfShade = shade;   
                                
      } // END OF CONSTRUCTOR: Room (args)
   
   // METHODS
      // Accessors
      
         public String getName()
         {
            return nameOfRoom;
         }
         
         public double getRoomWidth()
         {
            return roomWidth;
         }
         
         public double getRoomLength()
         {
            return roomLength;
         }
         public String getAmountOfShade()
         {
            return amountOfShade;
         }
      
         public double getArea()
         {
            return roomLength * roomWidth;
         }
         
         public double getReqCooling()
         {
            // Local Variables
            double area;
            double cooling;
            double coolingReq;
            String shade = amountOfShade;
            
            area = getArea(); // roomLength * roomWidth
            
            if (area < 250)
            {
               cooling = 5500;
            }  
               else if (area <= 500)
               {
                  cooling = 10000;
               }
               else if (area < 1000)
               {
                  cooling = 17500;
               }
               else 
               {
                  cooling = 24000;
               }
            
            if (shade.equalsIgnoreCase("Little"))
            {
               coolingReq = cooling * LITTLE_SHADE;             
            }
               else if (shade.equalsIgnoreCase("Moderate"))
               {
                  coolingReq = cooling * MODERATE_SHADE;               
               }
               else if (shade.equalsIgnoreCase("Abundant"))
               {
                  coolingReq = cooling * ABUNDANT_SHADE;                
               }
               else
               {
                  System.out.println("Value for shade is invalid. Please enter one of the following values for shade: Little, Moderate, or Abundant");
                  coolingReq = 0;
               }
            
            return coolingReq;
         }
         
      // Mutators
    
         public void setName(String name)
         {   
            nameOfRoom = name;
         } //END OF METHOD: setName
         
         public void setRoomWidth(double wid)
         {
            roomWidth = wid;
         } //END OF METHOD: setRoomWidth
         
         public void setRoomLength(double len)
         {
            roomLength = len;
         } //END OF METHOD: setRoomLength
         
         public void setAmountOfShade()
         {
            int shade;
         
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
            
         } //END OF METHOD: setAmountOfShade
         
         
         
         
   

} ////////////////////////////////////    END OF CLASS   /////////////////////////////////////////