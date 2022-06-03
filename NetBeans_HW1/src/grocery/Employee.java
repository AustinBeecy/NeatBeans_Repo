
package grocery;


public class Employee {

     String empID;
     String empName;
     String address;
     Double salary;
     String shift;
    
    
    public Employee(String emp_id, String emp_name, String address, Double salary, String shiftTime) {
        this.empID = emp_id;
        this.empName = emp_name;
        this.address = address;
        this.salary = salary;
        this.shift = shiftTime;
    }
    
    public String getID() {
        return this.empID;
    }

    public void setID(String id) {
        this.empID = id;
    }

    public String name() {
        return this.empName;
    }

    public void setName(String name) {
        this.empName = name;
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
        System.out.println(empID);
        System.out.println(empName);
        System.out.println(address);
        System.out.println(salary);
        System.out.println(shift);
    }
}
