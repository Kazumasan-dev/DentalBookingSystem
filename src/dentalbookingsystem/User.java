/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dentalbookingsystem;

/**
 *AUTHOR : MUHAMMAD AIMAN
 *CLASS :USER
 *DESC : CLASS THAT HAS METHOD AND DATA FIELD FOR USER
 * 
 */
import java.util.ArrayList;

public class User {
    
    //declare instance variable
    private String username;
    private String password;
    //declare appointment array list //aggregation with appointment class
    private ArrayList<Appointment> appointments; 
    
    //class constructor with parameter username and password
    public User(String username, String password) {
        setUsername(username);//setUsername
        setPassword(password);//setpassword
        this.appointments = new ArrayList<>();
    }
    //method to set and get username and password
    public void setUsername(String username) {
        this.username=username;
    }
    public String getUsername() {
        return username;
    }
    
    public void setPassword(String password) {
        this.password=password;
    }
    public String getPassword() {
        return password;
    }
    
   //method to add appointment object to appointment list
    public void addAppointment(Appointment a) {
        appointments.add(a);//add appointment to list
    }
    //method to cancel appointment
    public void cancelAppointment(int appointmentId) {
        //for loop to read all object saved in appointments list
        for(int i=0;i<appointments.size();i++){
            //condition to check the appointment id entered by user 
            if(appointments.get(i).getId()==appointmentId){
                //remove appointment from list if the id match
                appointments.remove(i);
            }
        }
       
    }
    //method to edit appointment
    public void editAppointment(int appointmentId, String service, String date, String time) {
        //for each loop to read all object in appointment list
        for (Appointment a : appointments) {
            //condition to check id entered by user an did in object 
            if (a.getId() == appointmentId) {
                //set new service , date and time
                a.setService(service);
                a.setDate(date);
                a.setTime(time);
            }
        }
    }
    //view appointments method 
    public void viewAppointments() {
        //condition to check if the appointmenst list is empty
        if (appointments.isEmpty()) {
            //display message to tell user no appointment found
            System.out.println("No appointments found.");
        }
        //for each loop read all appointment in appointment list
        for (Appointment a : appointments) {
            //display apointment 
            System.out.println(a);
        }
    }
    // method to make payment
    public void makePayment(int appointmentId, double amount, String method) {
        ////for each loop to read all object in appointment list
        for (Appointment a : appointments) {
            //condition to check id 
            if (a.getId() == appointmentId) {
                
                //condition to check either payment have been made
                if (a.getPayment() == null) {
                    //set payment method and amount
                    a.setPayment(amount, method);
                    //display payment succesfull
                    System.out.println("Payment successful.");
                    
                    //if paymentt has been made
                } else {
                    
                    System.out.println("Payment already made for this appointment.");
                }
                return;
            }
        }
        //if appointment id not match
        System.out.println("Appointment not found.");
    }
}

