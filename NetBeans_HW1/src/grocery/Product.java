
package grocery;


public class Product {
    String productID;
    Double price;
    String description;
    
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
}