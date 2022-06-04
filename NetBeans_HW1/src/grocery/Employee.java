
package grocery;

import javafx.beans.property.*;
import java.sql.Date;

/*
The Employee class containing the constructor and getters/setters
*/
public class Employee {

     String empid;
     String empname;
     String address;
     Double salary;
     String shift;
    
    
    public Employee(String emp_id, String emp_name, String address, Double salary, String shiftTime) {
        this.empid = emp_id;
        this.empname = emp_name;
        this.address = address;
        this.salary = salary;
        this.shift = shiftTime;
    }
    
    public String getID() {
        return this.empid;
    }

    public void setID(String id) {
        this.empid = id;
    }

    public String name() {
        return this.empname;
    }

    public void setName(String name) {
        this.empname = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalary() {
        return this.salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getShift() {
        return this.shift;
    }

    public void setShift(String shiftTime) {
        this.shift = shiftTime;
    }
    public void printEmp(){
        System.out.println(empid);
        System.out.println(empname);
        System.out.println(address);
        System.out.println(salary);
        System.out.println(shift);
    }
}
