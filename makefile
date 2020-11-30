Company.class: Company.java Admin.class Employee.class Location.class
	javac -g Company.java
Admin.class: Admin.java User.class
	javac -g Admin.java
Vehicle.class: Vehicle.java Customer.java Date.java
	javac -g Vehicle.java
Location.class: Location.java Employee.java Vehicle.java Address.java
	javac -g Location.java
Employee.class: Employee.java User.class
	javac -g Employee.java
Customer.class: Customer.java User.class Address.class Date.class Payment.class Vehicle.class
	javac -g Customer.java
User.class: User.java
	javac -g User.java
Payment.class: TypeCard.class BrandCard.class Date.class
	javac -g Payment.java
Date.class: Date.java
	javac -g Date.java
Address.class: Address.java
	javac -g Address.java
BrandCard.class: BrandCard.java
	javac -g BrandCard.java
TypeCard.class: TypeCard.java
	javac -g TypeCard.java
clean:
	rm *.class

