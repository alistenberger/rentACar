import java.io.*;
import java.util.*;
//Date.java
//Date class for various uses

public class Date implements Serializable {
  //Instance Variables 
  private int month;
  private int day;
  private int year;
  //end Instance Variables

  //Class Methods
  //Null Constructor
  public Date() {
    this.month = 1;
    this.day = 1;
    this.year = 1;
  } //end Null Constructor
  
  //Constructor
  public Date(int iMonth, int iDay, int iYear) { //i means initial
    this.month = iMonth;
    this.day = iDay;
    this.year = iYear;
  } //end Constructor

  public void setMonth(int newMonth) { 
    this.month = newMonth;
  } //end setMonth
  
  public int getMonth() {
    return this.month;
  } //end getMonth
  
  public void setDay(int newDay) {
    this.day = newDay;
  } //end setDay
  
  public int getDay() {
    return this.day;
  } //end getDay
  
  public void setYear(int newYear) {
    this.year = newYear;
  } //end setYear
  
  public int getYear() {
    return this.year;
  } //end getYear
  //end Class Methods
  /*
//class test
  public static int main(String[] args) {
    Date birthDate = new Date(11, 9, 1991);
    System.out.print("Before: ");
    birthDate.getMonth();
    birthDate.getDay();
    birthDate.getYear();
    birthDate.setMonth(3);
    birthDate.setDay(5);
    birthDate.setYear(1986);
    System.out.print("After: ");
    birthDate.getMonth();
    birthDate.getDay();
    birthDate.getYear();
    return(0);
  } //end Main
  */
} //end Date
