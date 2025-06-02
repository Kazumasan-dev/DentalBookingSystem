/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dentalbookingsystem;

/**
 **AUTHOR : ASYRAFF NABIL
 *CLASS :PAYMENT.JAVA
 *DESC : CLASS THAT HAS METHOD AND DATA FIELD FOR PAYMENT
 */
public class Payment {
    //declare instance variable for payment class
    private double amount;//variable for amount
    private String paymentMethod;//variable for paymentmethod
    
    //class constructor
    public Payment(double amount, String method) {
        //assign parameter to instance variable
        this.amount = amount;
        this.paymentMethod = method;
    }
     //to string method to return string statement
    @Override
    public String toString() {
        return "Payment Amount: RM" + amount + ", Method: " + paymentMethod;
    }
}