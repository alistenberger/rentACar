import java.io.*;
import java.util.*;
//Company.java
//Company class

public class Company implements Serializable {
  //Instance Variables
  private ArrayList<Location> locations;
  protected Admin admin;
  protected Employee user;
  private boolean isAdminUser;
  protected ArrayList<Customer> customers;
  //end Instance Variables
    
  //begin Class Methods
    
  //Null Constructor
  public Company() {
    this.locations = new ArrayList<Location>();
    this.admin = new Admin();
    this.user = null;
    this.isAdminUser = false;
    this.customers = new ArrayList<Customer>();
  }//end Null Constructor
  
  //Constructor
  public Company(ArrayList<Location> iLocations, Admin iAdmin, ArrayList<Customer> iCustomers) {
    this.locations = iLocations;
    this.admin = iAdmin;
    this.user = null;
    this.customers = iCustomers;
  }//end Constructor

  public void setLocations(ArrayList<Location> newLocations) {
    this.locations = newLocations;
  }//end setLocations
  
  public ArrayList<Location> getLocations() {
    return this.locations;
  }//end getLocations
  
  public void setAdmin(Admin newAdmin) {
    this.admin = newAdmin;
  }//end setAdmin
  
  public Admin getAdmin() {
    return this.admin;
  }//end getAdmin
  
  public void setUser(Employee newUser) {
    this.user = newUser;
  }//end setUser
  
  public Employee getUser() {
    return this.user;
  }//end getUser
  
  public void addLocation(Location newLocation) {
    this.locations.add(newLocation);
  }//end addLocation
  
  public void setCustomers(ArrayList<Customer> newCustomers) {
    this.customers = newCustomers;
  }//end setCustomers
  
  public Location getLocation() {
    int i = 0;
    System.out.println("Please select a location: ");
    for (Location indivLocation : locations) {
      System.out.print(i + ": ");
      System.out.println(indivLocation.getName());
      i++;
    }//end for each
    Scanner locationNumberScan = new Scanner(System.in);
    int locationNumberInt = locationNumberScan.nextInt();
    return locations.get(locationNumberInt);
  }//end getLocation
  
  public void setAdminUserTrue() {
    this.isAdminUser = true;
  }//end setAdminUserTrue
  
  public void setAdminUserFalse() {
    this.isAdminUser = false;
  }//end setAdminUserFalse
  
  public boolean getIsAdminUser() {
    return this.isAdminUser;
  }//end getIsAdminUser
  
  public void logIn() {
    boolean keepGoingLogIn = true;
    while (keepGoingLogIn) { //establish keepgoing loop
      System.out.print("Please enter your username: "); //print a message asking for the user's username
      Scanner usernameScan = new Scanner(System.in); //use scanner on System.in to capture user input
      String usernameString = usernameScan.nextLine(); //assign the scan to a string
      System.out.println("");
      System.out.print("Please enter your password: "); //print a message asking for the user's password
      Scanner passwordScan = new Scanner(System.in);//use scanner on system.in to capture user input
      String passwordString = passwordScan.nextLine(); //assign the scan to a string
      boolean loginVerifyVar = loginVerify(usernameString, passwordString); //pass the gathered variables to loginVerify function
      if (loginVerifyVar) { //if loginVerify returns true, call the menu evaluator and end keepgoing
        keepGoingLogIn = false;
        menuEvaluator();
      } else { //if loginVerify returns false, notify the user of a failed attempt
        System.out.println("Invalid credentials, please try again.");
      }//end conditionals
    }//end while loop - keepGoingLogIn
  }//end logIn
  
  public boolean loginVerify(String username, String password) { //parameters come from logIn method
    boolean isValidCredential = false;
    while (!isValidCredential) {
      if (username.equals(getAdmin().getUsername()) && password.equals(getAdmin().getPassword())) {
        //if the user credentials matches the admin credentials, set bool to true, break, and call adminMenu
        isValidCredential = true;
        setAdminUserTrue();
        break;
      } else if (!username.equals(getAdmin().getUsername()) && !password.equals(getAdmin().getPassword())){ //if the user logging in is not admin, look through the employees in each location
        for (Location indivLocation : locations) { //iterate through each location
          for (Employee indivEmployee : indivLocation.getEmployees()) { //get the arraylist of employees for each location
            if (username.equals(indivEmployee.getUserName()) && password.equals(indivEmployee.getPassword())) {
              //evaluates the supplied credentials against each employee's credentials
              //if there's a match, set the isValidCredential to true and break the loop
              isValidCredential = true;
              break;
            }//end employee username and password eval
          }//end nested for each evaluating individual employees credentials
        }//end for each loop for individual locations
      } else {
        System.out.println("Invalid credentials");
      }//end credential validation else conditional
    }//end while
    return isValidCredential;
  }//end loginVerify
  
  public void menuEvaluator() { //evaluates which menu method to call
    boolean isUserAdmin = getIsAdminUser(); //if user is an admin, the class variable 'isAdminUser'
    //will have been set to true by the loginVerify method. 
    if (isUserAdmin) {
      adminMenu(); //if the user is an admin, pull up admin menu
    } else {
      employeeMenu(); //if the user is not an admin, they can access the employee menu
    }//end conditionals for menu evaluation
  }//end menuEvaluator
  
  public void mainMenu() {
    System.out.println("Welcome to Rent-A-Car's employee terminal.");
    boolean keepGoingMainMenu = true;
    while (keepGoingMainMenu) {
      System.out.println("Please select an option from the menu below: ");
      System.out.println("0: Log In");
      System.out.println("1: Exit");
      Scanner userChoiceMainMenuScan = new Scanner(System.in);
      String userChoiceMainMenuStr = userChoiceMainMenuScan.nextLine();
      if (userChoiceMainMenuStr.equals("0")) { //allows user to login to system
        logIn();
      } else if (userChoiceMainMenuStr.equals("1")) { //method of user stopping program
        keepGoingMainMenu = false;
        System.out.println("Goodbye!");
      } else {
        System.out.println("I do not recognize that command."); //filters out undesired input
      }//end conditionals
    }//end while loop - keepGoingMainMenu
  }//end mainMenu
  
  public void adminMenu() { //admin menu to access admin user type functions
    boolean keepGoingAdminMenu = true;
    while (keepGoingAdminMenu) {
      System.out.println("Welcome admin. Please select an option from the menu below.");
      System.out.println("0: Manage Employees");
      System.out.println("1: Manage Inventory");
      System.out.println("2: Manage Locations");
      System.out.println("3: Log Out");
      Scanner adminChoiceScan = new Scanner(System.in);
      String adminChoiceStr = adminChoiceScan.nextLine();
      //start menu conditionals
      if (adminChoiceStr.equals("0")) {
        manageEmployeesMenu();
      } else if (adminChoiceStr.equals("1")) {
        manageInventoryMenu();
      } else if (adminChoiceStr.equals("2")) {
        manageLocationMenu();
      } else if (adminChoiceStr.equals("3")) {
        System.out.println("Goodbye!");
        setAdminUserFalse();
        saveData();
        keepGoingAdminMenu = false;
      } else {
        System.out.println("I'm sorry, I don't recognize that command.");
      }//end menu conditionals
    }//end while loop -adminMenu
    setAdminUserFalse(); //sets the 'isAdminUser' class variable to false before the menu is left
    //so the next user isn't given access to admin menu
  }//end adminMenu
  
  public void manageEmployeesMenu() { //admin menu to add, remove, edit, or list employees
    boolean keepGoingEmployeeManagement = true;
    while (keepGoingEmployeeManagement) {
      System.out.println("Employee Management Menu");
      System.out.println("Please select an option from the menu below");
      System.out.println("0: Add new employee");
      System.out.println("1: Delete employee");
      System.out.println("2: List employees");
      System.out.println("3: Back");
      Scanner choiceEmployeeMenuScan = new Scanner(System.in);
      String choiceEmployeeMenuStr = choiceEmployeeMenuScan.nextLine();
      if (choiceEmployeeMenuStr.equals("0")) {
        addEmployee();
      } else if (choiceEmployeeMenuStr.equals("1")) {
        deleteEmployee();
      } else if (choiceEmployeeMenuStr.equals("2")) {
        for (Location indivLocation : locations) {
          indivLocation.listEmployees();
        } //end for each loop
      } else if (choiceEmployeeMenuStr.equals("3")) {
        keepGoingEmployeeManagement = false;
      } else {
        System.out.println("I'm sorry, I don't recognize that command.");
      }//end conditionals- employee management menu
    }//end while loop- employee menu
  }//end manageEmployeesMenu
  
  public void manageLocationMenu() {
    boolean keepGoingManageLocations = true;
    while (keepGoingManageLocations) {
      System.out.println("Location Management Menu");
      System.out.println("Please select an option from the menu below");
      System.out.println("0: Add new location");
      System.out.println("1: Delete location");
      System.out.println("2: List location");
      System.out.println("3: Back");
      Scanner choiceLocationManagementScan = new Scanner(System.in);
      String choiceLocationManagementStr = choiceLocationManagementScan.nextLine();
      if (choiceLocationManagementStr.equals("0")) {
        addLocation();
      } else if (choiceLocationManagementStr.equals("1")) {
        deleteLocation();
      } else if (choiceLocationManagementStr.equals("2")) {
        int i = 0;
        for (Location indivLocation : locations) {
          System.out.println(i + ": " + indivLocation.getName());
          i++;
        }//end for each loop printing all locations
      } else if (choiceLocationManagementStr.equals("3")) {
        keepGoingManageLocations = false;
      } else {
        System.out.println("Command not recognized. Please try again.");
      }//end conditionals- location management
    }//end while keepGoingManageLocations
  }//end manageLocationMenu
  
  public void manageInventoryMenu() { //admin menu to add, remove, edit, or list vehicles
    boolean keepGoingManageInventory = true;
    while (keepGoingManageInventory) {
      System.out.println("Inventory Management Menu");
      System.out.println("Please select an option from the menu below");
      System.out.println("0: Add new vehicle");
      System.out.println("1: Delete vehicle");
      System.out.println("2: List vehicles");
      System.out.println("3: Back");
      Scanner choiceInventoryManagementScan = new Scanner(System.in);
      String choiceInvManagementStr = choiceInventoryManagementScan.nextLine();
      if (choiceInvManagementStr.equals("0")) {
        addVehicle();
      } else if (choiceInvManagementStr.equals("1")) {
        deleteVehicle();
      } else if (choiceInvManagementStr.equals("2")) {
        for (Location indivLocation : locations) {
          System.out.println("Location: " + indivLocation.getName());
          System.out.println("Available: ");
          indivLocation.listAvailableVehicles();
          System.out.println("Rented out: ");
          indivLocation.listRentedVehicles();
        }//end for each loop
      } else if (choiceInvManagementStr.equals("3")) {
        keepGoingManageInventory = false;
      } else {
        System.out.println("I'm sorry, I don't recognize that command.");
      }//end conditionals- inventory menu
    }//end while loop- inventory management
  }//end manageInventoryMenu
  
  public void listCustomers() {
    int i = 0;
    System.out.println("Customer Listing");
    System.out.println("Last, First");
    for (Customer indivCustomer : customers) {
      System.out.print(i + ": ");
      System.out.println(indivCustomer.getFullName());
      i++;
    }//end for each loop printing customers
  }//end list customers

  public Customer selectCustomer() {
    System.out.println("Please select a customer from the following list");
    listCustomers();
    Scanner custSelectionScan = new Scanner(System.in);
    int custSelectionInt = custSelectionScan.nextInt();
    Customer tempCustomer = customers.get(custSelectionInt);
    return tempCustomer;
  }//end selectCustomer
  
  public Vehicle selectAvailableVehicle() {
    System.out.println("Please select which location the vehicle is located at.");
    Location tempLocation = getLocation();
    System.out.println("Please select the vehicle");
    tempLocation.listAvailableVehicles();
    Scanner vehicleIndexScan = new Scanner(System.in);
    int vehicleIndexInt = vehicleIndexScan.nextInt();
    Vehicle tempVehicle = tempLocation.getVehiclesOnLot().get(vehicleIndexInt);
    tempLocation.getVehiclesOnLot().remove(vehicleIndexInt);
    return tempVehicle;
  }//end select vehicle  
  
  public Vehicle selectRentedVehicle() {
    System.out.println("Please select the location from which the vehicle was rented.");
    Location tempLocation = getLocation();
    System.out.println("Please select the vehicle");
    tempLocation.listRentedVehicles();
    Scanner vehicleIndexScan = new Scanner(System.in);
    int vehicleIndexInt = vehicleIndexScan.nextInt();
    Vehicle tempVehicle = tempLocation.getVehiclesOnLoan().get(vehicleIndexInt);
    tempLocation.getVehiclesOnLoan().remove(vehicleIndexInt);
    return tempVehicle;
  }//end selectRentedVehicle
  
  public void customerManagementMenu() {
    boolean keepGoingCustomerMenu = true;
    while (keepGoingCustomerMenu) {
      System.out.println("Welcome to the customer management interface. Please select an option from the menu below.");
      System.out.println("0. Add customer");
      System.out.println("1. Delete customer");
      System.out.println("2. List all customers");
      System.out.println("3. Back");
      Scanner customerMenuScan = new Scanner(System.in);
      String customerChoiceStr = customerMenuScan.nextLine();
      if (customerChoiceStr.equals("0")) {
        addCustomer();
      } else if (customerChoiceStr.equals("1")) {
        deleteCustomer();
      } else if (customerChoiceStr.equals("2")) {
        listCustomers();
      } else if (customerChoiceStr.equals("3")) {
        keepGoingCustomerMenu = false;
      } else {
        System.out.println("I'm sorry, I don't recognize that command.");
      }//end conditionals- customer menu selection
    } //end while loop- customer menu
    //add, delete, or edit customers
    saveData();
  }//end customerManagementMenu
  
  public void transactionMenu(String typeTransaction) {
    //for transaction assigning vehicle to customer
    if (typeTransaction.equals("out")) {
      Location transactionLocation = getLocation();
      Customer transactionCustomer = selectCustomer();
      Vehicle transactionVehicle = selectAvailableVehicle();
      //use vehicle's .setCheckedOutBy() to assign the customer to it
      transactionVehicle.setCheckedOutBy(transactionCustomer);
      //set Date rented 
      System.out.println("Please enter today's date");
      Date todaysDate = createDate();
      transactionVehicle.setDateRented(todaysDate);
      System.out.print("Please enter the number of days the vehicle has been rented for: ");
      Scanner numDaysScan = new Scanner(System.in);
      int numDaysInt = numDaysScan.nextInt();
      transactionVehicle.setDaysRented(numDaysInt);
      //create temp variable for bill by multiplying vehicle cost per day by days rented
      double tempBill = numDaysInt * transactionVehicle.getCostPerDay();
      //add bill to customer
      System.out.println("The total cost will be " + tempBill);
      transactionCustomer.setBill(tempBill);
      //move vehicle from on lot array to rented array
      transactionLocation.getVehiclesOnLoan().add(transactionVehicle);
      transactionCustomer.setVehicleRented(transactionVehicle);
      transactionVehicle.setCheckedOutBy(transactionCustomer);
      saveData();
    } else if (typeTransaction.equals("in")) { 
      //for customer returning vehicle
      Location transactionLocation = getLocation();
      Customer transactionCustomer = selectCustomer();
      Vehicle transactionVehicle = selectRentedVehicle();
        //check if late
      boolean lateStatus = transactionCustomer.getLateReturn();
        //if late, assign fee
      if (lateStatus) {
          System.out.println("Adding late fee to transaction.");
      }//end late check
        //use .setCheckedOutBy() to set to null
      transactionVehicle.setCheckedOutBy(null);
      transactionVehicle.setDateRented(null);
      transactionVehicle.setDaysRented(0);
      transactionCustomer.setVehicleRented(null);
      transactionCustomer.setBill(0);
          //move vehicle from rented array to on lot array
      transactionLocation.getVehiclesOnLot().add(transactionVehicle);
      System.out.println("Transaction Completed.");
      saveData();
    }//end transaction evaluation
  }//end transactionMenu
  
  public void transactionSubMenu() { //sub menu to decide which type of transaction to begin
    boolean keepGoingMakeTransaction = true;
    while (keepGoingMakeTransaction) {
      System.out.println("Is the customer renting or returning the vehicle?");
      System.out.println("0: Renting");
      System.out.println("1: Returning");
      Scanner transactionChoiceScan = new Scanner(System.in);
      String transactionChoiceStr = transactionChoiceScan.nextLine();
      if (transactionChoiceStr.equals("0")) {
        transactionMenu("out");
        keepGoingMakeTransaction = false;
      } else if (transactionChoiceStr.equals("1")) {
        transactionMenu("in");
        keepGoingMakeTransaction = false;
      } else {
        System.out.println("I'm sorry, I don't recognize that command.");
      }//end conditionals- transaction choice
    }//end while loop- transaction choice
  }//end transactionSubMenu
  //record transaction function? name the function logTransaction()
  
  public void employeeMenu() { //employee menu to access employee user type functions
    boolean keepGoingEmployeeMenu = true;
    while (keepGoingEmployeeMenu) {
      System.out.println("Welcome, please select an option from the menu below");
      System.out.println("0: Customer Management");
      System.out.println("1: Inventory Management");
      System.out.println("2: Make Transaction");
      System.out.println("3: Log Out");
      Scanner employeeChoiceScan = new Scanner(System.in);
      String employeeChoiceStr = employeeChoiceScan.nextLine();
      //begin menu conditionals
      if (employeeChoiceStr.equals("0")) {
        customerManagementMenu();
      } else if (employeeChoiceStr.equals("1")) {
        manageInventoryMenu();
      } else if (employeeChoiceStr.equals("2")) {
        transactionSubMenu();
      } else if (employeeChoiceStr.equals("3")) {
        System.out.println("Goodbye!");
        keepGoingEmployeeMenu = false;
      } else {
        System.out.println("I'm sorry, I don't recognize that command.");
      }//end menu conditionals 
    }//end while loop- employee menu
  }//end employeeMenu
  
  public void addEmployee() {
    System.out.println("Please enter the employee's last name: ");
    Scanner eLastNameScan = new Scanner(System.in);
    String lastName = eLastNameScan.nextLine();
    System.out.println("Please enter the employee's first name: ");
    Scanner eFirstNameScan = new Scanner(System.in);
    String firstName = eFirstNameScan.nextLine();
    System.out.println("Please enter the employee's desired username: "); //should institute a checkUsername function to verify no matches
    Scanner eUserNameScan = new Scanner(System.in);
    String userName = eUserNameScan.nextLine();
    System.out.println("Please enter the employee's desired password: ");
    Scanner ePasswordScan = new Scanner(System.in);
    String password = ePasswordScan.nextLine();
    Employee tempEmployee = new Employee(lastName, firstName, userName, password);
    System.out.println("You will now be asked to add the employee to a location.");
    Location tempLocation = getLocation();
    tempLocation.addEmployeeLoc(tempEmployee);
    saveData();
  }//end addEmployee
  
  public void deleteEmployee() {
    //Need a type of lookup to find employee to delete.
    //either have to choose location first then access employee arraylist
    //or find a way to select the array containing found employee
    int i = 0;
    Location tempLocation = null;
    System.out.println("Please enter a search term to find the employee to be deleted.");
    Scanner searchTermScan = new Scanner(System.in);
    String searchTerm = searchTermScan.nextLine();
    for (Location indivLocation : locations) {
      if (indivLocation.getEmployees().contains(searchTerm)) {
        tempLocation = locations.get(i);
        int deleteIndex = indivLocation.getEmployees().indexOf(searchTerm);
        Employee tempEmployee = tempLocation.getEmployees().get(deleteIndex);
        System.out.println(searchTerm +" found at " + tempLocation.getName());
        System.out.println("Is " + tempEmployee.getLastName() + ", " + tempEmployee.getFirstName() +
        " who you were looking for? (Y/N)");
        Scanner userChoiceDeleteScan = new Scanner(System.in);
        String userChoiceDeleteStr = userChoiceDeleteScan.nextLine();
        if (userChoiceDeleteStr.toUpperCase().equals("Y")) {
          System.out.println("User: " + tempEmployee.getLName() + ", " + tempEmployee.getFName() +
          " will be deleted.");
          tempLocation.getEmployees().remove(deleteIndex);
          System.out.println("User deleted");
        } else if (userChoiceDeleteStr.toUpperCase().equals("N")) {
          System.out.println(searchTerm + " returned inadequate results, please try another term.");
        } else {
          System.out.println("I'm sorry, I don't recognize that command.");
        } //end delete conditionals
      } else {
        System.out.println(searchTerm + " not found at " + indivLocation.getName());
        i++;
        System.out.println("Searching at: " + locations.get(i).getName());
      }//end conditionals
    }//end for
    saveData();
  }//end deleteEmployee
  
  public Address createAddress() {
    System.out.print("Address Line 1: ");
    Scanner addressLine1Scan = new Scanner(System.in);
    String addressLine1Str = addressLine1Scan.nextLine();
    System.out.println("");
    System.out.print("Address Line 2: ");
    Scanner addressLine2Scan = new Scanner(System.in);
    String addressLine2Str = addressLine2Scan.nextLine();
    System.out.println("");
    System.out.print("City: ");
    Scanner cityNameScan = new Scanner(System.in);
    String cityNameStr = cityNameScan.nextLine();
    System.out.println("");
    System.out.print("State: ");
    Scanner stateNameScan = new Scanner(System.in);
    String stateNameStr = stateNameScan.nextLine();
    System.out.println("");
    System.out.print("Zip Code: ");
    Scanner zipCodeScan = new Scanner(System.in);
    String zipCodeStr = zipCodeScan.nextLine();
    System.out.println("");
    Address tempAddress = new Address(addressLine1Str, addressLine2Str, cityNameStr, stateNameStr, zipCodeStr);
    return tempAddress;
  }//end createAddress
  
  public Date createDate() {
    System.out.println("You are creating a date instance. Use integers only.");
    System.out.println("For instance: for January 1st 1900 you would input 1, 1, and 1900");
    System.out.print("Month: ");
    Scanner monthScan = new Scanner(System.in);
    int monthInt = monthScan.nextInt();
    System.out.println("");
    System.out.print("Day: ");
    Scanner dayScan = new Scanner(System.in);
    int dayInt = dayScan.nextInt();
    System.out.println("");
    System.out.print("Year: ");
    Scanner yearScan = new Scanner(System.in);
    int yearInt = yearScan.nextInt();
    System.out.println("");
    Date tempDate = new Date(monthInt, dayInt, yearInt);
    return tempDate;
  }//end createDate
  
  public Vehicle createVehicle() {
    Vehicle tempVehicle = new Vehicle();
    System.out.println("How many doors does the vehicle have?");
    Scanner numDoorsScan = new Scanner(System.in);
    int numDoorsInt = numDoorsScan.nextInt();
    tempVehicle.setNumDoors(numDoorsInt);
    System.out.println("What is the number of passengers that can be held?");
    Scanner numPassengersScan = new Scanner(System.in);
    int numPassengersInt = numPassengersScan.nextInt();
    tempVehicle.setNumPassengers(numPassengersInt);
    System.out.println("What is the vehicle's make?");
    Scanner makeScan = new Scanner(System.in);
    String makeString = makeScan.nextLine();
    tempVehicle.setMake(makeString);
    System.out.println("What is the vehicle's model?");
    Scanner modelScan = new Scanner(System.in);
    String modelString = makeScan.nextLine();
    tempVehicle.setModel(modelString);
    System.out.println("What is the vehicle's year?");
    Scanner yearScan = new Scanner(System.in);
    String yearString = yearScan.nextLine();
    tempVehicle.setYear(yearString);
    return tempVehicle;
  }//end createVehicle
  
  public Payment createPayment() {
    Payment tempPayment = new Payment();
    System.out.println("Please select a card type.");
    System.out.println("0) Debit");
    System.out.println("1) Credit");
    Scanner cardChoiceScan = new Scanner(System.in);
    String cardChoiceStr = cardChoiceScan.nextLine();
    if (cardChoiceStr.equals("0")) {
      tempPayment.setCardType(TypeCard.DEBIT);
    } else if (cardChoiceStr.equals("1")) {
      tempPayment.setCardType(TypeCard.CREDIT);
    } else {
      System.out.println("I'm sorry, I don't recognize that command.");
    } //end conditionals create card type
    System.out.println("Please select a card brand.");
    System.out.println("0) VISA");
    System.out.println("1) MASTERCARD");
    System.out.println("2) AMEX");
    System.out.println("3) DISCOVER");
    Scanner cardBrandScan = new Scanner(System.in);
    String cardBrandStr = cardBrandScan.nextLine();
    if (cardBrandStr.equals("0")) {
      tempPayment.setCardBrand(BrandCard.VISA);
    } else if (cardBrandStr.equals("1")) {
      tempPayment.setCardBrand(BrandCard.MASTERCARD);
    } else if (cardBrandStr.equals("2")) {
      tempPayment.setCardBrand(BrandCard.AMEX);
    } else if (cardBrandStr.equals("3")) {
      tempPayment.setCardBrand(BrandCard.DISCOVER);
    } else {
      System.out.println("I'm sorry, I don't recognize that command.");
    }//end conditionals- card brand selection
    System.out.println("Please enter the card number: ");
    Scanner cardNumScan = new Scanner(System.in);
    String cardNumStr = cardNumScan.nextLine();
    tempPayment.setCardNumber(cardNumStr);
    System.out.println("Please enter the expiration date");
    Date tempEXPDate = createDate();
    tempPayment.setEXPDate(tempEXPDate);
    System.out.println("Now please enter the full name as it appears on the card");
    Scanner fullNameScan = new Scanner(System.in);
    String fullNameStr = fullNameScan.nextLine();
    tempPayment.setNameOnCard(fullNameStr);
    return tempPayment;
  }//end createPayment
 
  public void addLocation() {
    System.out.println("What is the name of the new location?");
    Scanner locationNameScan = new Scanner(System.in);
    String locationNameStr = locationNameScan.nextLine();
    System.out.println("What is the address of the new location?");
    Address tempAddress = createAddress();
    Location tempLocation = new Location();
    tempLocation.setName(locationNameStr);
    tempLocation.setAddress(tempAddress);
    locations.add(tempLocation);
    saveData();
  }//end addLocation
  
  public void deleteLocation() {
    System.out.println("What is the name of the location?");
    Scanner locationNameScan = new Scanner(System.in);
    String locationNameStr = locationNameScan.nextLine();
    for (int i = 0; i < locations.size(); i++) {
      Location indivLocation = locations.get(i);
      if (indivLocation.getName().toUpperCase().equals(locationNameStr.toUpperCase())) {
        System.out.println(indivLocation.getName() + " will be deleted, are you sure? (Y/N)");
        Scanner userChoiceDeleteScan = new Scanner(System.in);
        String userChoiceDeleteStr = userChoiceDeleteScan.nextLine();
        if (userChoiceDeleteStr.toUpperCase().equals("Y")) {
          locations.remove(i);
          System.out.println("Location deleted");
        } else if (userChoiceDeleteStr.toUpperCase().equals("N")) {
          System.out.println("Location will not be deleted.");
        } else {
          System.out.println("I don't understand that command, please try again.");
        }//end location delete conditionals 
      } else {
        System.out.println("Searching...");
      }//end search conditionals
    }//end for loop iterating through locations
    saveData();
  }//end deleteLocation
  
  public void addVehicle() {
    System.out.println("What location will this vehicle be added to?");
    Location tempLocation = getLocation();
    Vehicle tempVehicle = createVehicle();
    tempVehicle.setOwnLocation(tempLocation);
    tempLocation.addVehicleInv(tempVehicle);
    saveData();
  }//end addVehicle
  
  public void deleteVehicle() {
    System.out.println("What location has the vehicle?");
    Location tempLocation = getLocation();
    System.out.println("Select which vehicle you wish to delete. Please enter the number at the start of the listing");
    tempLocation.listAvailableVehicles();
    Scanner vehicleNumScan = new Scanner(System.in);
    int vehicleNumInt = vehicleNumScan.nextInt();
    System.out.println("Vehicle: " + tempLocation.getVehiclesOnLot().get(vehicleNumInt).listFullName() + " will be deleted.");
    tempLocation.deleteVehicleInv(vehicleNumInt);
    System.out.println("Vehicle deleted.");
    saveData();
  }//end deleteVehicle
  
  public void addCustomer() {
    Customer tempCustomer = new Customer();
    System.out.println("Customer Creation Interface");
    System.out.println("Please enter the customer's first name");
    Scanner custFNameScan = new Scanner(System.in);
    String custFNameStr = custFNameScan.nextLine();
    tempCustomer.setFName(custFNameStr);
    System.out.println("Now, please enter the customer's last name");
    Scanner custLNameScan = new Scanner(System.in);
    String custLNameStr = custLNameScan.nextLine();
    tempCustomer.setLName(custLNameStr);
    System.out.println("Please enter the customer's date of birth");
    Date tempDate = createDate();
    tempCustomer.setDOB(tempDate);
    System.out.println("Now you will be asked to add the customer's address information.");
    Address tempAddress = createAddress();
    tempCustomer.setAddress(tempAddress);
    System.out.println("Now you will be asked to enter the customer's payment information");
    Payment tempPayment = createPayment();
    tempCustomer.setPaymentInfo(tempPayment);
    System.out.println("Customer successfully created");
    customers.add(tempCustomer);
    saveData();
  }//end addCustomer
    
  public void deleteCustomer() {
    System.out.println("Please select the customer below that you wish to delete.");
    listCustomers();
    Scanner custDeleteIndexScan = new Scanner(System.in);
    int custDeleteIndexInt = custDeleteIndexScan.nextInt();
    customers.remove(custDeleteIndexInt);
    System.out.println("Customer deleted");
    saveData();
  }//end deleteCustomer
  
  public void saveData() {
    try {
      FileOutputStream outFile = new FileOutputStream("RentACarSystem.dat");
      ObjectOutputStream outObj = new ObjectOutputStream(outFile);
      outObj.writeObject(locations);
      outObj.writeObject(customers);
      outObj.close();
      outFile.close();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }//end try
  }//end saveData
  
  public void loadData() {
    try {
      FileInputStream inFile = new FileInputStream("RentACarSystem.dat");
      ObjectInputStream inObj = new ObjectInputStream(inFile);
      locations = (ArrayList) inObj.readObject();
      customers = (ArrayList) inObj.readObject();
      inObj.close();
      inFile.close();
      setLocations(locations);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }//end try 
  }//end loadData
  
  public static void main(String[] args) {
    Company company = new Company();
    company.loadData();
    Location flagshipStore = new Location();
    flagshipStore.setName("Flagship Store");
    company.locations.add(flagshipStore);
    company.mainMenu();
  }//end Main
}//end Company
