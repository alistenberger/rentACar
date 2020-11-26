import java.io.*;
import java.util.*;
//Customer.java
//Customer class
public class Customer extends User {
  //Instance Variables
  private Date dob;
  private Address address;
  private Payment paymentInfo;
  private boolean lateReturn;
  private Vehicle vehicleRented;
  private double bill;
  private Date returnDate;
  private Date rentDate;
  //end Instance Variables
  
  //Begin Class Methods
  //Null Constructor
  public Customer() {
    this.dob = new Date();
    this.address = new Address();
    this.paymentInfo = new Payment();
    this.lateReturn = false;
    this.vehicleRented = null;
    this.bill = 0;
    this.returnDate = null;
    this.rentDate = null;
  } //end Null Constructor
  
  //Constructor
  public Customer( //start constructor parameters
  Date iDOB,
  Address iAddress,
  Payment iPayment,
  boolean iLateReturn,
  Vehicle iVehicleRented,
  double iBill,
  Date iReturnDate,
  Date iRentDate) { //end constructor parameters
    this.dob = iDOB;
    this.address = iAddress;
    this.paymentInfo = iPayment;
    this.lateReturn = iLateReturn;
    this.vehicleRented = iVehicleRented;
    this.bill = iBill;
    this.returnDate = iReturnDate;
    this.rentDate = iRentDate;
  } //end Constructor
  
  public void setDOB(Date newDOB) {
    this.dob = newDOB;
  } //end setDOB
  
  public Date getDOB() {
    return this.dob;
  } //end getDOB
  
  public void setAddress(Address newAddress) {
    this.address = newAddress;
  } //end setAddress
  
  public Address getAddress() {
    return this.address;
  } //end getAddress
  
  public void setPaymentInfo(Payment newPaymentInfo) {
    this.paymentInfo = newPaymentInfo;
  }
  
  public Payment getPaymentInfo() {
    return this.paymentInfo;
  } //end getPaymentInfo
  
  public void setLateReturnTrue() {
    this.lateReturn = true;
  } //end setLateReturnTrue
  
  public void setLateReturnFalse() {
    this.lateReturn = false;
  } //end setLateReturnFalse
  
  public boolean getLateReturn() {
    return this.lateReturn;
  } //end getLateReturn
  
  public void setVehicleRented(Vehicle newVehicleRented) {
    this.vehicleRented = newVehicleRented;
  } //end setVehicleRented
  
  public Vehicle getVehicleRented() {
    return this.vehicleRented;
  } //end getVehicleRented
  
  public void setBill(double newBill) {
    this.bill = newBill;
  } //end setBill
  
  public double getBill() {
    return this.bill;
  } //end getBill
  
  public void setReturnDate(Date newReturnDate) {
    this.returnDate = newReturnDate;
  } //end setReturnDate
  
  public Date getReturnDate() {
    return this.returnDate;
  } //end getReturnDate
  
  public void setRentDate(Date newRentDate) {
    this.rentDate = newRentDate;
  } //end setRentDate
  
  public Date getRentDate() {
    return this.rentDate;
  } //end getRentDate
}//end Customer

