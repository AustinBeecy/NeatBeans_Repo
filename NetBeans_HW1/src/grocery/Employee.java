
package grocery;

/**
 *
 * @author Jd3ab
 */
public class Employee {

     String emp_id;
     String emp_name;
     //String phone;
     String address;
     Double salary;
     String shiftTime;
    
    
    public Employee(String emp_id, String emp_name, String address, Double salary, String shiftTime) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        //this.phone = phone;
        this.address = address;
        this.salary = salary;
        this.shiftTime = shiftTime;
    }
    
    //getters and setters for Employee Class
    public String getID() {
        return this.emp_id;
    }

    public void setID(String id) {
        this.emp_id = id;
    }

    public String name() {
        return this.emp_name;
    }

    public void setName(String name) {
        this.emp_name = name;
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
        System.out.println(emp_id);
        System.out.println(emp_name);
        //System.out.println(phone);
        System.out.println(address);
        System.out.println(salary);
        System.out.println(shiftTime);
    }
}
