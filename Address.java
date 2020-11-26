import java.io.*;
import java.util.*;
//Address.java
//Address class for use in tracking customer addresses

public class Address {
  //Instance Variables
  private String address1;
  private String address2;
  private String city;
  private String state;
  private String zip;
  //end Instance Variables
    
  //Class Methods
  //Null Constructor
  public Address() {
    this.address1 = "";
    this.address2 = "";
    this.city = "";
    this.state = "";
    this.zip = "";
  } //end Null Constructor
  
  //Constructor
  public Address(String iAddress1, String iAddress2, String iCity, String iState, String iZip) {
    this.address1 = iAddress1;
    this.address2 = iAddress2;
    this.city = iCity;
    this.state = iState;
    this.zip = iZip;
  } //end Constructor

  public void setAddress1(String newAddress1) {
    this.address1 = newAddress1;
  } //end setAddress1
  
  public String getAddress1() {
    return this.address1;
  } //end getAddress1
  
  public void setAddress2(String newAddress2) {
    this.address2 = newAddress2;
  } //end setAddress2
  
  public String getAddress2() {
    return this.address2;
  } //end getAddress2
  
  public void setCity(String newCity) {
    this.city = newCity;
  } //end setCity
  
  public String getCity() {
    return this.city;
  } //end getCity
  
  public void setState(String newState) {
    this.state = newState;
  } //end setState
  
  public String getState() {
    return this.state;
  } //end getState
  
  public void setZip(String newZip) {
    this.zip = newZip;
  } //end setZip
  
  public String getZip() {
    return this.zip;
  } //end getZip
  
  //end Class Methods
  
  //class Test
  public static int main(String[] args) {
    Address customerAddress = new Address("555 Fake Street", "", "Fakesville", "IN", "46069");
    customerAddress.getAddress1();
    customerAddress.getAddress2();
    customerAddress.getCity();
    customerAddress.getState();
    customerAddress.getZip();
    return(0);
  } //end main
  //end class test
} //end Address

