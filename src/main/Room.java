import java.util.*;
import java.io.*;


public class Room{
   
   //Fields
   private String name;
   private double length;
   private double width;   
   private String shade;
   
   private AirConditioner ac = new AirConditioner();
   private ArrayList<String> roomInfo = new ArrayList<String>();
   
   
   //Constructors
   public Room(){
      name = "Unamed";
      shade = "Unknown";
   }
   
   public Room(String name, double length, double width, String shade){
      this.name = name;
      this.length = length;
      this.width = width;
      this.shade = shade;
   }
   
   
   public Room(String name, double length, double width, String shade, AirConditioner ac){
      this(name, length, width, shade);
      
      this.ac.setManufacturer(ac.getManufacturer());
      this.ac.setConditionerType(ac.getConditionerType());
      this.ac.setCoolingCapacity(ac.getCoolingCapacity());
   }
   
   //Field Setters
   public void setName(String name)
      {this.name = name;}
      
   public void setLength(double length)
      {this.length = length;}
      
   public void setWidth(double Width)
      {this.width = width;}
      
   public void setShade(String shade)
      {this.shade = shade;}
       
   public void setRoomInfo(){
      ArrayList<String> currentRoomInfo = new ArrayList<String>();
          
      currentRoomInfo.add(String.format("Room Name: %s",  getName()));
      currentRoomInfo.add(String.format("Room Area: %,.1f", getArea()));
      currentRoomInfo.add(String.format("Amount of Shade: %s ", getShade()));
      currentRoomInfo.add(String.format("BTUs Per Hour needed: %,.0f", getRequiredCooling()));
      currentRoomInfo.add(ac.toString());
      currentRoomInfo.add(String.format("This room %s adequately cooled.", getCoolingAdequancy()));
      
      this.roomInfo = currentRoomInfo;     
   }

   
   //Getters
   public String getName()
      {return name;}
      
   public double getLength()
      {return length;}
      
   public double getWidth()
      {return width;}
        
   public String getShade()
      {return shade;}
      
   public double getArea()
      {return length*width;}
      
      
   //Unique Behaviors
   private double getEffectOfShade(){
      double shadingEffect = 0;
      
      final double EFFECTS_OF_LITTLE_SHADE = 1.15 ;
      final double EFFECTS_OF_MODERATE_SHADE = 1 ;
      final double EFFECTS_OF_ABUNDANT_SHADE = .9 ;
      final double UNKNOWN_SHADE = 0 ;
      
         if (shade.equalsIgnoreCase("Little"))
            shadingEffect = EFFECTS_OF_LITTLE_SHADE;
         else if (shade.equalsIgnoreCase("Moderate"))
            shadingEffect = EFFECTS_OF_MODERATE_SHADE;
         else if (shade.equalsIgnoreCase("Abundant"))
            shadingEffect = EFFECTS_OF_ABUNDANT_SHADE;
         else
            shadingEffect = UNKNOWN_SHADE;
              
      return shadingEffect;
   }
       
   
   public double getAirConditionerCapacity(){
      double acHourlyBTUs = 0;
      double roomArea = getArea();
      
      final int SMALL_ROOM = 250;
      final int MEDIUM_ROOM = 500;
      final int LARGE_ROOM = 1000;
      
      final int LOW_CAPACITY = 5500;
      final int MIDDLE_CAPACITY = 10000;
      final int HIGH_CAPACITY = 17500;
      final int SUPER_CAPACITY = 24000;
      
      if (roomArea < SMALL_ROOM)
         { acHourlyBTUs = LOW_CAPACITY; }
      else if (roomArea <= MEDIUM_ROOM)
         { acHourlyBTUs = MIDDLE_CAPACITY; }
      else if (roomArea < LARGE_ROOM)
         { acHourlyBTUs = HIGH_CAPACITY; }
      else
         { acHourlyBTUs = SUPER_CAPACITY; }
      
      return acHourlyBTUs;
   }
   
   public double getRequiredCooling(){
      return getAirConditionerCapacity() * getEffectOfShade();
   }
   
   private boolean hasAdequateCooling(){
      return ac.getCoolingCapacity() >= getRequiredCooling()? true : false;
   }
   
   private String getCoolingAdequancy(){
      String coolingAdequancy = "is not";
      
      if (hasAdequateCooling()){
         coolingAdequancy = "is";
      }
      
      return coolingAdequancy;
   }
   
   public String toString(){
      setRoomInfo();
      
      String empty = "";
      String roomDescription = empty;
            
      for (String info: roomInfo){
         roomDescription += (info + "\n");
      }
      return roomDescription;
   }

}