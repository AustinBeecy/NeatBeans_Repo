/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netbeans_hw1;

/**
 *
 * @author Jd3ab
 */
public class Employee {
    String name; 
    String Id; 
    int salary; 
    int phone; 
   
    //getters and setters for Employee Class
    
    public String name()
   {
     return this.name;
   }
   public void setName(String name)
   {
       this.name = name; 
   }
   public String getID()
   {
     return this.Id;
   }
   public void setID(String Id)
   {
       this.Id = Id; 
   }
    public int getSalary()
   {
     return this.salary;
   }
   public void setSalary(int salary)
   {
       this.salary = salary; 
   }
   public int getPhone()
   {
     return this.phone;
   }
   public void setPhone(int phone)
   {
       this.phone = phone;
    }
}