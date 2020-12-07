import java.io.*;
import java.util.*;
//User.java
//Abstract User class

public abstract class User implements Serializable {
  
  //Instance variables
  protected String lName;
  protected String fName;
  protected String type;
  //End Instance Variables
  
  //Class Methods  
  public void setName(String lastName, String firstName) {
    this.lName = lastName;
    this.fName = firstName;
  } //end set name
  
  public void setLName(String newLName) {
    this.lName = newLName;
  }//end setLName
  
  public void setFName(String newFName) {
    this.fName = newFName;
  }//end setFName
  
  public String getFirstName() {
    return this.fName;
  } // end getFirstName
  
  public String getLastName() {
    return this.lName;
  } // end getLastName
  
  public String getFullName() {
    String fullName = "";
    fullName += getLastName();
    fullName += ", ";
    fullName += getFirstName();
    return fullName;
  } // end getFullName
  
  public void setType(String typeUser) {
    this.type = typeUser;
  } //end setType
  
  public String getType() {
    return this.type;
  } // end getType
  //End Class Methods
} // end User
