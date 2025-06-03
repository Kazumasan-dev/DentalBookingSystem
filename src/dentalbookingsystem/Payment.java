/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dentalbookingsystem;

/**
 *AUTHOR:MUHAMMAD AIMAN,SITI NUR AZRINA ,ASYRAF NABIL
 *MATRIC NO:S74699,S74720,S74594
 *CLASS :Payment.java
 *DESC : Class that contain method and data field for payment
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