
package grocery;


public class Product {
    String productID;
    String name; 
    Double price;
    String description;
    String supID; 
    String areaID;
    
    public Product(String id, String name, Double price, String description, String supID, String areaID){
        this.productID = id;
        this.name = name;
        this.price = price; 
        this.description = description; 
        this.supID = supID; 
        this.areaID = areaID;
    }
    
 public String getProductID()
   {
     return this.productID;
   }
   public void setProductID(String productID)
   {
       this.productID = productID;     
    }
   public double getPrice()
   {
     return this.price;
   }
   public void setPrice(double price)
   {
       this.price = price; 
   }
   public String getDescription()
   {
     return this.description;
   }
   public void setDescription(String description)
   {
       this.description = description; 
   }
   public void setName(String name){
       this.name = name; 
   }
   public String getName(){
       return this.name; 
   }
   public void setSupID(String supID){
       this.supID = supID; 
   }
   public String getSupID(){
       return this.supID; 
   }
    public void setAreaID(String areaID){
       this.areaID = areaID; 
   }
   public String getAreaID(){
       return this.areaID; 
   }
}