import java.io.*;
import java.util.*;
//Admin.java
//Administrator class for program
//use getters and setters to pull in most recent variables wherever Admin is logged in
//i.e. If logged into company, admin would set ArrayList<Employee> using Company.getEmployees()

public class Admin {
  //Instance Variables
  private String username;
  private String password;
  //end Instance Variables
  
  //Begin Class Methods
  
  //Null Constructor
  public Admin() {
    this.username = "admin";
    this.password = "012345";
  }//end Null Constructor
  
  //Constructor
  public Admin(String newUsername, String newPassword) {
    this.username = newUsername;
    this.password = newPassword;
  }//end Constructor
  
  public void addEmployee() {
    //code here
  }//end addEmployee
  
  public void addManager() {
    //code here
  }//end addManager
  
  public void addOwner() {
    //code here
  }//end addOwner
  
  public void deleteEmployee() {
    //code here
  }//end deleteEmployee
  
  public void deleteOwner() {
    //code here
  }//end deleteOwner
  
  public void addLocation() {
    //code here
  }//end addLocation
  
  public void deleteLocation() {
    //code here
  }//end deleteLocation
  //end class methods
}//end Admin

