/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dentalbookingsystem;

/**
 *
 **AUTHOR : MUHAMMAD AIMAN,SITI NUR AZRINA ASYRAF,NABIL
 * MATRIC NO:S74699,S74720,S74594
 *CLASS :Dentalbookinsystem.java
 *DESC : main class to implement all class
 */
import java.util.Scanner;
public class DentalBookingSystem {
 public static void main(String[] args) {
        //create scanner class object
        Scanner scanner = new Scanner(System.in);
        //create and oject for scanner class
        Login login = new Login();
        //Declare a User variable named currentUser and initialize it to null
        User currentUser = null;
        int appointmentCounter = 1;
        //while condition equal to true
        System.out.println("========WELCOME TO DENTAL APPOINTMENT SYSTEM========");
        while (true) {
            if (currentUser == null) {
                //prompt user to enter username
                System.out.print("Please insert Username: ");
                //scanner accept input username from user
                String user = scanner.nextLine();
                //prompt user to enter password
                System.out.print("Please insert Password: ");
                //scanner accept input password  from user
                String pass = scanner.nextLine();
                //autheticate username and password using method invoked from login class
                currentUser = login.authenticate(user, pass);
                 
                if (currentUser == null) {
                    //if password or username not match
                    System.out.println("Invalid login. Try again.");
                }
            } else {
                
                
                System.out.println("\n1. Make Appointment");
                System.out.println("2. View Appointments");
                System.out.println("3. Edit Appointment");
                System.out.println("4. Cancel Appointment");
                System.out.println("5. Make Payment");
                System.out.println("6. Logout");
                System.out.print("Choose option: ");
                String choice = scanner.nextLine();
                System.out.println("");
                 //switch case to determine action for user selection
                switch (choice) {
                    //case 1: accept data from user to make new appointment
                    case "1":
                        //prompt and accept name from user
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        //prompt and accept Ic number
                        System.out.print("Enter IC Number: ");
                        String ic = scanner.nextLine();
                        //prompt and accept service type from user
                        System.out.print("Service Type: ");
                        String service = scanner.nextLine();
                        //prompt and accept date from user
                        System.out.print("Date (dd-mm-yyyy): ");
                        String date = scanner.nextLine();
                        //prompt and accept time from user
                        System.out.print("Time (e.g., 10:00 AM): ");
                        String time = scanner.nextLine();
                        //create object for appointment class
                        Appointment appt = new Appointment(appointmentCounter++, name, ic, service, date, time);
                        //add new appointment to array list invoking addappoinment method from user class
                        currentUser.addAppointment(appt);
                        //display to tell user appointment successfulyy created
                        System.out.println("Appointment created.\n");
                        System.out.println("============================================");
                        break;
                    //case 2: view booked appointment
                    case "2":
                        //invoke method to view appoint from user class
                        currentUser.viewAppointments();
                        break;
                    //case3: to edit appointment
                    case "3":
                        currentUser.viewAppointments();
                        //prompt and accept appoinment id from user
                        System.out.print("Enter Appointment ID to edit: ");
                        int editId = Integer.parseInt(scanner.nextLine());
                        //prompt and accept new service from user
                        System.out.print("New Service: ");
                        String newService = scanner.nextLine();
                        //prompt and accept new date from user
                        System.out.print("New Date: ");
                        String newDate = scanner.nextLine();
                        //prompt and accept new time from user
                        System.out.print("New Time: ");
                        String newTime = scanner.nextLine();
                        //invoke editappointment method from user class
                        currentUser.editAppointment(editId, newService, newDate, newTime);
                        //display to tell user appointment successfulyy edited
                        System.out.println("Appointment updated.\n");
                        break;
                    //case:4 to view appointment
                    case "4":
                        //invoke method to display appointment
                        currentUser.viewAppointments();
                        //prompt and accept appointmentid from user
                        System.out.print("Enter Appointment ID to cancel: ");
                        int cancelId = Integer.parseInt(scanner.nextLine());
                        //invoke method to cancel appointment from user class
                        currentUser.cancelAppointment(cancelId);
                        //display to tell user appointment successfulyy cancelled
                        System.out.println("Appointment cancelled.\n");
                        break;
                    //case 5: to make payment or appointment
                    case "5":
                        //display all appointment by invoking method view appointment
                        currentUser.viewAppointments();
                        //prompt and accept appointmentid from user
                        System.out.print("Enter Appointment ID to make payment: ");
                        int payId = Integer.parseInt(scanner.nextLine());
                        //prompt and accept payment amount from user
                        System.out.print("Enter payment amount: ");
                        double amount = Double.parseDouble(scanner.nextLine());
                        //prompt and accept payment method from user
                        System.out.print("Enter payment method (Cash/Card): ");
                        String method = scanner.nextLine();
                        //invoke makepayment method from user class
                        currentUser.makePayment(payId, amount, method);
                        System.out.println("Payment successfull.\n");
                        break;
                    //Case 6: log out from syste,
                    case "6":
                        //set object to null
                        currentUser = null;
                        //display to indicate user succesfully logout
                        System.out.println("Logged out.");
                        break;
                    // user enter invalid option
                    default:
                        System.out.println("Invalid option.");
                }
            }
        }
    }
}
