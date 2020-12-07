import java.io.*;
import java.util.*;
//Admin.java
//Administrator class for program
//use getters and setters to pull in most recent variables wherever Admin is logged in
//i.e. If logged into company, admin would set ArrayList<Employee> using Company.getEmployees()

public class Admin implements Serializable {
  //Instance Variables
  private String username;
  private String password;
  private ArrayList<Location> allLocations;
  //end Instance Variables
  
  //Begin Class Methods
  
  //Null Constructor
  public Admin() {
    this.username = "admin";
    this.password = "012345";
  }//end Null Constructor
  
  //Constructor
  public Admin(String iUsername, String iPassword) {
    this.username = iUsername;
    this.password = iPassword;
  }//end Constructor
  
  public void setUsername(String newUsername) {
    this.username = newUsername;
  }//end setUsername
  
  public String getUsername() {
    return this.username;
  }//end getUsername
  
  public void setPassword(String newPassword) {
    this.password = newPassword;
  }//end setPassword
  
  public String getPassword() {
    return this.password;
  }//end getPassword
  
  /*these don't necessarily need to be admin functions, just ONLY accessible by an admin user
  public void addEmployee() {
    //code here
  }//end addEmployee
  
  public void deleteEmployee() {
    //code here
  }//end deleteEmployee
  
  public void addLocation() {
    //code here
  }//end addLocation
  
  public void deleteLocation() {
    //code here
  }//end deleteLocation
  
  public void addVehicle() {
  }//end addVehicle
  
  public void deleteVehicle() {
  }//end deleteVehicle
  */
  //end class methods
}//end Admin

