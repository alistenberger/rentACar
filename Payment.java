import java.io.*;
import java.util.*;
//Payment.java
//Payment class to store payment information

public class Payment implements Serializable {
  //Instance Variables
  private TypeCard cardType;
  private BrandCard cardBrand;
  private String cardNumber;
  private Date expDate;
  private String nameOnCard;
  //end Instance Variables
  
  //begin Class Methods
  
  //Null Constructor
  public Payment() {
    this.cardType = null;
    this.cardBrand = null;
    this.cardNumber = null;
    this.expDate = null;
    this.nameOnCard = null;
  }//end Null Constructor

  //Constructor
  public Payment( //begin constructor parameters
  TypeCard iCardType, 
  BrandCard iCardBrand, 
  String iCardNumber, 
  Date iEXPDate, 
  String iNameOnCard) { //end constructor parameters
    this.cardType = iCardType;
    this.cardBrand = iCardBrand;
    this.cardNumber = iCardNumber;
    this.expDate = iEXPDate;
    this.nameOnCard = iNameOnCard;
  }//end Constructor
  
  public void setCardType(TypeCard newCardType) {
    this.cardType = newCardType;
  }//end setCardType
  
  public TypeCard getCardType() {
    return this.cardType;
  }//end getCardType
  
  public void setCardBrand(BrandCard newCardBrand) {
    this.cardBrand = newCardBrand;
  }//end setCardBrand
  
  public BrandCard getCardBrand() {
    return this.cardBrand;
  }//end getCardBrand
  
  public void setCardNumber(String newCardNumber) {
    this.cardNumber = newCardNumber;
  }//end setCardNumber
  
  public String getCardNumber() {
    return this.cardNumber;
  }//end getCardNumber
  
  public void setEXPDate(Date newEXPDate) {
    this.expDate = newEXPDate;
  }//end setEXPDate
  
  public Date getEXPDate() {
    return this.expDate;
  }//end getEXPDate
  
  public void setNameOnCard(String newNameOnCard) {
    this.nameOnCard = newNameOnCard;
  }//end setNameOnCard
  
  public String getNameOnCard() {
    return this.nameOnCard;
  }//end getNameOnCard
  //end class methods
} //end Payment
