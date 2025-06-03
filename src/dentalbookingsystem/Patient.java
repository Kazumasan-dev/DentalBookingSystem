/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dentalbookingsystem;

/**
 *AUTHOR :MUHAMMAD AIMAN,SITI NUR AZRINA ,ASYRAF NABIL
 *MATRIC NO:S74699,S74720,S74594
 *CLASS :Patient.java
 *DESC : A subclass for user that focus on method implementation for patient
 */
public class Patient extends User {
    //class constructor
    public Patient(String username, String password) {
        super(username, password);
    }
    //method to book appointment
    public void bookAppointment(Appointment appointment) {
        
        addAppointment(appointment);
        //display message when user successfully book an appointment
        System.out.println("Appointment booked successfully by patient: " + username);
    }

    @Override
    public void cancelAppointment(int appointmentId) {
       for (int i = 0; i < appointments.size(); i++) {
           //condition to ensure id and username match
            if (appointments.get(i).getId() == appointmentId && appointments.get(i).getName().equals(this.username)) {
                appointments.remove(i);//remove appointment
                //display if appointment cancelled sucessfully
                System.out.println("Appointment cancelled/deleted successfully.");
                return;
            }
        }
       //display if the appointmentid and username not match 
        System.out.println("Appointment not found or does not belong to you.");
    }

    @Override
    public void editAppointment(int appointmentId, String service, String date, String time) {
         for (Appointment a : appointments) {
             //condition to ensure id and username match
            if (a.getId() == appointmentId && a.getName().equals(this.username)) {
                //set new service
                a.setService(service);
                //set new date
                a.setDate(date);
                //set new time
                a.setTime(time);
                //display if appointment successfully updated
                System.out.println("Appointment updated successfully.");
                return;
            }
        }
        //display if the appointmentid and username not match 
        System.out.println("Appointment not found or does not belong to you.");
    }

    @Override
    public void viewAppointments() {
        
        for (Appointment appointment : appointments) {
            //condition only to display appointment that booked by specific current patient
            if (appointment.getName().equals(this.username)) {
                System.out.println(appointment);
                
            }else{
               //display if no appointment match with patient username
               System.out.println("No appointments found for patient: " + username);
            }
            
        }
        
    }

    @Override
    //method to make payment for patient
    public void makePayment(int appointmentId, double amount, String method) {
        for (Appointment a : appointments) {
            //check if appoint id and username match 
            if (a.getId() == appointmentId && a.getName().equals(this.username)) {
                if (a.getPayment() == null) {
                    a.setPayment(amount, method);
                    //display if payment successful
                    System.out.println("Payment successful.");
                } else {
                    //display if payment already been made
                    System.out.println("Payment already made for this appointment.");
                }
                
            }
        }
        //display if no appointment found
        System.out.println("Appointment not found or does not belong to you.");
    }
    
}
