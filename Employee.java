import java.io.*;
import java.util.*;
//Employee.java extends User abstract class
//Employee class for operating program

public class Employee extends User implements Serializable {
  //Instance Variables 
  private String userName;
  private String password;
  //end Instance Variables

  //Class Methods
  //Null Constructor
  public Employee() {
    this.lName = "Doe";
    this.fName = "John";
    this.userName = "anonymousEmployee";
    this.password = "employeePassword";
    this.type = "employee";
  } //end Null Constructor

  //Constructor
  public Employee(String iLastName, String iFirstName, String iUserName, String iPassword) {
    this.lName = iLastName;
    this.fName = iFirstName;
    this.userName = iUserName;
    this.password = iPassword;
    this.type = "employee";
  } //end Constructor

  public void setLName(String newLastName) {
    this.lName = newLastName;
  } //end setLName
  
  public String getLName() {
    return this.lName;
  } // end getLName
  
  public void setFName(String newFirstName) {
    this.fName = newFirstName;
  } //end setFName
  
  public String getFName() {
    return this.fName;
  } //end getFName
  
  public void setUserName(String newUserName) {
    this.userName = newUserName;
  } //end setUserName
  
  public String getUserName() {
    return this.userName;
  } //end getUserName
  
  public void setPassword(String newPassword) {
    this.password = newPassword;
  } //end setPassword
  
  public String getPassword() {
    return this.password;
  } //end getPassword
  
  public void setType(String newType) {
    this.type = newType;
  } //end setType
  
  public String getType() {
    return this.type;
  } //end getType
  
  //end Class Methods
  /*
  //class Test
  public static int main(String[] args) {
    Employee newEmployee = new Employee("Person", "Employed", "emplPers", "DefaultPassword");
    newEmployee.getLName();
    newEmployee.getFName();
    newEmployee.getUserName();
    newEmployee.getPassword();
    newEmployee.getType();
    return(0);
  } //end main
  //end class test
  */
} //end Employee
