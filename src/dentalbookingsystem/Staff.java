/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dentalbookingsystem;



/**
 *AUTHOR :MUHAMMAD AIMAN,SITI NUR AZRINA ,ASYRAF NABIL
 *MATRIC NO:S74699,S74720,S74594
 *CLASS :Patient.java
 *DESC : A subclass for user that focus on method implementation for staff
 */
public class Staff extends User {

    public Staff(String username, String password) {
        super(username, password);
    }
    //method to book appointment
    public void bookAppointment(Appointment appointment) {
        //invoke metod addAppointment to add new apppointment to appointment arraylist
        addAppointment(appointment);
        //display message when user successfully book an appointment
        System.out.println("Appointment booked successfully by staff: " + username);
    }

    @Override
    public void cancelAppointment(int appointmentId) {
        //loop to read all appointment in appointment arraylist
         for (int i = 0; i < appointments.size(); i++) {
            //condition to check if the selected appointmentid is the same as the id in arraylist appointments
            if (appointments.get(i).getId() == appointmentId) {
                appointments.remove(i);//removes appointment for array list
                System.out.println("Appointment cancelled/deleted successfully.");
                
            }
        }
        //display if no match appointment id found
        System.out.println("Appointment not found.");
    }

    @Override
    public void editAppointment(int appointmentId, String service, String date, String time) {
        //read all appointment from appointments array list
         for (Appointment a : appointments) {
            //check if id given by user match with appointment id in appointment arraylist
            if (a.getId() == appointmentId) {
                //set new service
                a.setService(service);
                //set new date
                a.setDate(date);
                //set new time
                a.setTime(time);
                //display when user succefully edit the appointment
                System.out.println("Appointment updated successfully.");
                
            }
        }
        //display if no match appointment id found
        System.out.println("Appointment not found.");
    }

    @Override
    public void viewAppointments() {
        //condition to check either the appointment arraylist is empty
         if (appointments.isEmpty()) {
            //display if the appointment is empty
            System.out.println("No appointments found.");
            
        } else {
            //read all appointment from appointment array list
            for (Appointment appointment : appointments) {
                //display all the appointment
                System.out.println(appointment);
            }
        }
    }

    @Override
    public void makePayment(int appointmentId, double amount, String method) {
          //read all appointment from appointment array list
          for (Appointment a : appointments) {
            //check if id given by user match with appointment id in appointment arraylist
            if (a.getId() == appointmentId) {
                //if payment is equal to null(not paid)
                if (a.getPayment() == null) {
                    //set payment 
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
        System.out.println("Appointment not found.");
    
    }
    
}
