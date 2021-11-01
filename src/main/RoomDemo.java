import java.util.*;
import java.io.*;


public class RoomDemo{
   static ArrayList<Room> roomList = new ArrayList<Room>(); 

   public static void main(String[] args){
      String filename = "Rooms2.txt";
      File file = new File(filename);
      
      try{
         readRoomsFromFile(file);
      }   
      catch(FileNotFoundException f){
         System.out.println("You must have the wrong directory... ");
      }
      
     showRoomsInfo(roomList);
   }
   
   static void readRoomsFromFile(File file) throws FileNotFoundException{
      Scanner inputFile = new Scanner(file);   
            
            while (inputFile.hasNext()){
               String name = inputFile.nextLine();
               double length = Double.parseDouble(inputFile.nextLine());
               double width = Double.parseDouble(inputFile.nextLine());
               String shade = inputFile.nextLine();
               
               String acManufacturer = inputFile.nextLine();
               String acType = inputFile.nextLine();
               double acCoolingCapacity = Double.parseDouble(inputFile.nextLine());
               inputFile.nextLine();
               
               AirConditioner ac = new AirConditioner(acManufacturer, acType, acCoolingCapacity);
               
               roomList.add(new Room(name, length, width, shade, ac));
            }
   }   
   
   static void showRoomsInfo(ArrayList<Room> roomList){
      for (Room room: roomList){
            System.out.println(room.toString());
      }
   }
   
}