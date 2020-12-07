import java.io.*;
import java.util.*;
//Location.java
//Location class to function as individual business objects

public class Location extends Company implements Serializable {
  //Instance Variables
  protected ArrayList<Employee> employees;
  protected ArrayList<Vehicle> vehiclesOnLot;
  protected ArrayList<Vehicle> vehiclesOnLoan;
  protected String name;
  protected Address address;
  //end Instance Variables
  
  //begin Class Methods
  
  //Null Constructor
  public Location() {
    this.employees = new ArrayList<Employee>();
    this.vehiclesOnLot = new ArrayList<Vehicle>();
    this.vehiclesOnLoan = new ArrayList<Vehicle>();
    this.name = "";
    this.address = new Address();
    this.admin = new Admin();
    this.user = null;
  }//end Null Constructor

  //Constructor
  public Location( //begin Constructor parameters
  ArrayList<Employee> iEmployees, 
  ArrayList<Vehicle> iVehiclesOnLot, 
  ArrayList<Vehicle> iVehiclesOnLoan, 
  String iName, 
  Address iAddress) { //end Constructor parameters
    this.employees = iEmployees;
    this.vehiclesOnLot = iVehiclesOnLot;
    this.vehiclesOnLoan = iVehiclesOnLoan;
    this.name = iName;
    this.address = iAddress;
    this.admin = new Admin();
    this.user = null;
  }//end Constructor
  
  public void setEmployees(ArrayList<Employee> newEmployees) {
    this.employees = newEmployees;
  }//end setEmployees
  
  public ArrayList<Employee> getEmployees() {
    return this.employees;
  }//end getEmployees
  
  public void setVehiclesOnLot(ArrayList<Vehicle> newVehiclesOnLot) {
    this.vehiclesOnLot = newVehiclesOnLot;
  }//end setVehiclesOnLot
  
  public ArrayList<Vehicle> getVehiclesOnLot() {
    return this.vehiclesOnLot;
  }//end getVehiclesOnLot
  
  public void setVehiclesOnLoan(ArrayList<Vehicle> newVehiclesOnLoan) {
    this.vehiclesOnLoan = newVehiclesOnLoan;
  }//end setVehiclesOnLoan
  
  public ArrayList<Vehicle> getVehiclesOnLoan() {
    return this.vehiclesOnLoan;
  }//end getVehiclesOnLoan
  
  public void setName(String newName) {
    this.name = newName;
  }//end setName
  
  public String getName() {
    return this.name;
  }//end getName
  
  public void setAddress(Address newAddress) {
    this.address = newAddress;
  }//end setAddress
  
  public Address getAddress() {
    return this.address;
  }//end getAddress
  
  public void listEmployees() {
    //for each loop to system.out each employee in employees.getName()
    int i = 0;
    System.out.println("");
    System.out.println("Location: " + getName());
    for (Employee employee : employees) {
      System.out.println(i + ": " + employee.getLName() +", " + employee.getFName());
      i++;
    } //end for loop
    System.out.println("");
  }//end listEmployees
  
  public void listAvailableVehicles() {
    int i = 0;
    //for each loop to system.out each vehicle on lot
    for (Vehicle vehicle : vehiclesOnLot) {
      System.out.println(i + ": " + vehicle.getYear() + " " + vehicle.getMake() 
      + " " + vehicle.getModel());
      i++;
    }//end for
  }//end listAvailableVehicles
  
  public void listRentedVehicles() {
    int i = 0;
    //for each loop to system.out each vehicle currently on loan
    for (Vehicle vehicle : vehiclesOnLoan) {
      System.out.println(i + ": " + vehicle.getYear() + " " + vehicle.getMake() 
      + " " + vehicle.getModel());
      i++;
    }//end for
  }//end listRentedVehicles
  
  public void addVehicleInv(Vehicle newVehicle) {
    vehiclesOnLot.add(newVehicle);
  }//end addVehicleInv
  
  public void addEmployeeLoc(Employee newEmployee) {
    employees.add(newEmployee);
  }//end addEmployeeLoc
  
  public void deleteVehicleInv(int i) {
    vehiclesOnLot.remove(i);
  }//end deleteVehicleInv
}//end Location
