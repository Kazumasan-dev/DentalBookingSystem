/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dentalbookingsystem;

/**
 *AUTHOR:MUHAMMAD AIMAN,SITI NUR AZRINA ,ASYRAF NABIL
 *MATRIC NO:S74699,S74720,S74594
 *CLASS :Appointment.JAVA
 *DESC :class that contain data field and method for Appointment class
 */
public class Appointment {
    //declare instance variable
    private int appointmentid;
    private String name;
    private String ic;
    private String service;
    private String date;
    private String time;
    private Payment payment; // Composition
    //class constructor 
    public Appointment(int appointmentid, String name, String ic, String service, String date, String time) {
        //assign parameter to instance variable
        this.appointmentid = appointmentid;
        setName(name);
        this.ic = ic;
        this.service = service;
        this.date = date;
        this.time = time;
        this.payment = null;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    // method get id to return appointment id
    public int getId() {
        return appointmentid;
    }
    //getter and setter return service 
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
    // method to set date
    public void setDate(String date) {
        this.date = date;
    }
    //method to set appointment time
    public void setTime(String time) {
        this.time = time;
    }
    // method set payment assign payment object to current instance variable
    public void setPayment(double amount, String method) {
        this.payment = new Payment(amount, method);
    }

    public Payment getPayment() {
        return payment;
    }
    //method to return string statement about paid appointment
    @Override
    public String toString() {
        return "Appointment ID: " + appointmentid + "\nName: " + name + ", ID: " + ic + "\nService: " + service +
               "\nDate: " + date + "\nTime: " + time +
               (payment == null ? "\nPayment: Not paid" : "\n" + payment.toString()) + "\n";
    }
}