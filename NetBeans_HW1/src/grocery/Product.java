
package grocery;


public class Product {
    String productID;
    String name; 
    Double price;
    String description;
    
    public Product(String id, String name, Double price, String description){
        this.productID = id;
        this.name = name;
        this.price = price; 
        this.description = description; 
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
}