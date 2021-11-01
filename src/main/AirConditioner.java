import java.util.*;

public class AirConditioner{
   //Fields
   private String manufacturer;
   private String conditionerType;
   private double coolingCapacity;
   
   //Constructors
   AirConditioner(){}
   
   AirConditioner(String manufacturer, String conditionerType, double coolingCapacity){
      this();
      this.setManufacturer(manufacturer);
      this.setConditionerType(conditionerType);
      this.setCoolingCapacity(coolingCapacity);
   }
   
   //Setters
   public void setManufacturer(String manufacturer){
      this.manufacturer = manufacturer;
   }
   
   public void setConditionerType(String conditionerType){
      this.conditionerType = conditionerType;
   }
   
   public void setCoolingCapacity(double coolingCapacity){
      this.coolingCapacity = coolingCapacity;
   }
   
   public ArrayList<String> getACInfo(){
      ArrayList<String> currentACInfo = new ArrayList<String>();
      
      acInfo.add(String.format("Air Conditioner Manufacturer: %s" + "\n", getManufacturer()));
      acInfo.add(String.format("Air Conditioner Type: %s" + "\n", getConditionerType()));
      acInfo.add(String.format("Air Conditioner Cooling Capacity (BTUs Per Hour): %,.0f", getCoolingCapacity()));
      
      return acInfo;
   }   
   
   //Getters
   public String getManufacturer(){
      return manufacturer;
   }
   
   public String getConditionerType(){
      return conditionerType;
   }
   
   public double getCoolingCapacity(){
      return coolingCapacity;
   }
    
   public String toString(){
      
      String empty = "";
      String acDescription = empty;
            
      for (String info: getACInfo()){
         acDescription += (info);
      }
      
      return acDescription;
   }  

}