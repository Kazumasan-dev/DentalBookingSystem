/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dentalbookingsystem;

/**
 *AUTHOR:MUHAMMAD AIMAN,SITI NUR AZRINA ,ASYRAF NABIL
 *MATRIC NO:S74699,S74720,S74594
 *CLASS :User.java
 *DESC : Super class for patient and staff 

 */
import java.util.ArrayList;

public abstract class User {
    
    //declare instance variable
    protected String username;
    protected String password;
    //declare appointment array list //aggregation with appointment class
    protected ArrayList<Appointment> appointments; 
    
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
    public abstract void cancelAppointment(int appointmentId);
       
    
    //method to edit appointment
    public abstract void editAppointment(int appointmentId, String service, String date, String time);
    
    //view appointments method 
    public abstract void viewAppointments();
    
    // method to make payment
    public abstract void makePayment(int appointmentId, double amount, String method);
}

