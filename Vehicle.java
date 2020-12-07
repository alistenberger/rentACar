import java.io.*;
import java.util.*;
//Vehicle.java
//Vehicle class for vehicle inventory

public class Vehicle implements Serializable {
  //Instance Variables
  protected double costPerDay;
  protected int numPassengers;
  protected float odometer;
  protected int numDoors;
  protected double costInsurance;
  protected Location ownLocation;
  protected Customer checkedOutBy;
  protected Date dateRented;
  protected int daysRented;
  protected String year;
  protected String make;
  protected String model;
  //end Instance Variables

  //Class Methods
  //Null Constructor
  public Vehicle() {
    this.costPerDay = 50;
    this.numPassengers = 0;
    this.odometer = 0;
    this.numDoors = 0;
    this.costInsurance = 50;
    this.ownLocation = null;
    this.checkedOutBy = null;
    this.dateRented = null;
    this.daysRented = 0;
    this.year = null;
    this.make = null;
    this.model = null;
  } //end Null Constructor
  
  //Constructor
  public Vehicle(//start constructor parameters
  double iCostPerDay, 
  int iNumPassengers, 
  float iOdometer, 
  int iNumDoors, 
  double iCostInsurance, 
  Location iOwnLocation, 
  Customer iCheckedOutBy, 
  Date iDateRented, 
  int iDaysRented, 
  String iYear, 
  String iMake, 
  String iModel) { //end constructor parameters
    this.costPerDay = iCostPerDay;
    this.numPassengers = iNumPassengers;
    this.odometer = iOdometer;
    this.numDoors = iNumDoors;
    this.costInsurance = iCostInsurance;
    this.ownLocation = iOwnLocation;
    this.checkedOutBy = iCheckedOutBy;
    this.dateRented = iDateRented;
    this.daysRented = iDaysRented;
    this.year = iYear;
    this.make = iMake;
    this.model = iModel;
  } //end Constructor
    
  public void setCostPerDay(double newCostPerDay) {
    this.costPerDay = newCostPerDay;
  } //end setCostPerDay
  
  public double getCostPerDay() {
    return this.costPerDay;
  } //end getCostPerDay
  
  public void setNumPassengers(int newNumPassengers) {
    this.numPassengers = newNumPassengers;
  } //end setNumPassengers
  
  public int getNumPassengers() {
    return this.numPassengers;
  } //end getNumPassengers
  
  public void setOdometer(float newOdometer) {
    this.odometer = newOdometer;
  } //end setOdometer
  
  public float getOdometer() {
    return this.odometer;
  } //end getOdometer
  
  public void setNumDoors(int newNumDoors) {
    this.numDoors = newNumDoors;
  } //end setNumDoors
  
  public int getNumDoors() {
    return this.numDoors;
  } //end getNumDoors
  
  public void setCostInsurance(double newCostInsurance) {
    this.costInsurance = newCostInsurance;
  } //end setCostInsurance
  
  public double getCostInsurance() {
    return this.costInsurance;
  } //end getCostInsurance
  
  public void setOwnLocation(Location newOwnLocation) {
    this.ownLocation = newOwnLocation;
  } //end setOwnLocation
  
  public Location getOwnLocation() {
    return this.ownLocation;
  } //end getOwnLocation
  
  public void setCheckedOutBy(Customer newCheckedOutBy) {
    this.checkedOutBy = newCheckedOutBy;
  } //end setCheckedOutBy
  
  public Customer getCheckedOutBy() {
    return this.checkedOutBy;
  } //end getCheckedOutBy
  
  public void setDateRented(Date newDateRented) {
    this.dateRented = newDateRented;
  } //end setDateRented
  
  public Date getDateRented() {
    return this.dateRented;
  } //end getDateRented
  
  public void setDaysRented(int newDaysRented) {
    this.daysRented = newDaysRented;
  } //end setDaysRented
  
  public int getDaysRented() {
    return this.daysRented;
  } //end getDaysRented
  
  public void setYear(String newYear) {
    this.year = newYear;
  } //end setYear
  
  public String getYear() {
    return this.year;
  } //end getYear
  
  public void setMake(String newMake) {
    this.make = newMake;
  } //end setMake
  
  public String getMake() {
    return this.make;
  } //end getMake
  
  public void setModel(String newModel) {
    this.model = newModel;
  } //end setModel
  
  public String getModel() {
    return this.model;
  } //end getModel
  
  public String listFullName() {
    String fullVehicleName = getYear() + " " +getMake() + " " + getModel();
    return fullVehicleName;
  }//end listFullName
  //end Class Methods
  
  /*
  //Class Test
  public static void main(String[] args) {
    Location testLocation = new Location();
    Date testDOB = new Date(5, 5, 5555);
    Date testEXPDate = new Date(1, 1, 1111);
    Payment testCard = new Payment(TypeCard.DEBIT, BrandCard.VISA, "5555555", testEXPDate, "testNameForCard");
    Address testAddress = new Address("555 Fake Street", "Apt. 5", "Fakesville", "IN", "46069");
    Customer testCustomer = new Customer(testDOB, testAddress, testCard, false, null, 0, null, null);
    Date testDate = new Date();
    Vehicle testVehicle = new Vehicle(56.50, 5, 157.8f, 4, 98.00, testLocation,
    testCustomer, testDate, 5, "2020", "Dodge", "Challenger");
    System.out.println(testVehicle.getCostPerDay());
    System.out.println(testVehicle.getNumPassengers());
    System.out.println(testVehicle.getOdometer());
    System.out.println(testVehicle.getNumDoors());
    System.out.println(testVehicle.getCostInsurance());
    System.out.println(testVehicle.getOwnLocation());
    System.out.println(testVehicle.getCheckedOutBy());
    System.out.println(testVehicle.getDateRented());
    System.out.println(testVehicle.getDaysRented());
    System.out.println(testVehicle.getYear());
    System.out.println(testVehicle.getMake());
    System.out.println(testVehicle.getModel());
    System.out.println(testVehicle.getCheckedOutBy().getAddress().getAddress1());
    System.out.println("Card Number: " + testVehicle.getCheckedOutBy().getPaymentInfo().getCardNumber());
  } //end main
  //end Class Test
  */
} //end Vehicle
