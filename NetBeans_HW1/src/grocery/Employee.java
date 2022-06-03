
package grocery;

/**
 *
 * @author Jd3ab
 */
public class Employee {

     String id;
     String name;
     //String phone;
     String address;
     Double salary;
     String shiftTime;
    
    
    public Employee(String id, String name, String address, Double salary, String shiftTime) {
        this.id = id;
        this.name = name;
        //this.phone = phone;
        this.address = address;
        this.salary = salary;
        this.shiftTime = shiftTime;
    }
    
    //getters and setters for Employee Class
    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String name() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getPhone() {
//        return this.phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }

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
        return this.shiftTime;
    }

    public void setShift(String shiftTime) {
        this.shiftTime = shiftTime;
    }
    public void printEmp(){
        System.out.println(id);
        System.out.println(name);
        //System.out.println(phone);
        System.out.println(address);
        System.out.println(salary);
        System.out.println(shiftTime);
    }
}
