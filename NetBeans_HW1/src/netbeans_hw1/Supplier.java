/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netbeans_hw1;

/**
 *
 * @author Jd3ab
 */
public class Supplier {
   private String name; 
   private String address; 
   private String contactName; 
   private String contactPhone; 
   private String contactEmail; 
   
   public String getName()
   {
     return this.name;
   }
   public void setName(String name)
   {
       this.name = name; 
   }
     public String getAddress()
   {
     return this.address;
   }
   public void setAdress(String address)
   {
       this.address = address; 
   }
   public String getContactName()
   {
       return this.contactName; 
   }
   public void setContactName(String contactName)
   {
       this.contactName = contactName; 
   }
   public String getContactPhone()
   {
       return this.contactPhone; 
   }
   public void setContactPhone(String contactPhone)
   {
       this.contactPhone = contactPhone; 
   }
   public String getContactEmail()
   {
       return this.contactEmail; 
   }
   public void setContactEmail(String contactEmail)
   {
       this.contactEmail = contactEmail; 
   }
}
