/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dentalbookingsystem;

/**

 *AUTHOR : MUHAMMAD AIMAN,SITI NUR AZRINA ,ASYRAF NABIL
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
                
                //display menu
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
                         
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter IC Number: ");
                        String ic = scanner.nextLine();
                        System.out.print("Service Type: ");
                        String service = scanner.nextLine();
                        System.out.print("Date (dd-mm-yyyy): ");
                        String date = scanner.nextLine();
                        System.out.print("Time (e.g., 10:00 AM): ");
                        String time = scanner.nextLine();
                        //create object for appointment class
                         Appointment appt = new Appointment(appointmentCounter++, name, ic, service, date, time);
                        if (currentUser  instanceof Patient) {
                            ((Patient) currentUser ).bookAppointment(appt);
                        } else if (currentUser  instanceof Staff) {
                            ((Staff) currentUser ).bookAppointment(appt);
                        }
                        break;
                        
                    //case 2: view booked appointment
                    case "2":
                        //invoke method to view appoint from user class
                        currentUser.viewAppointments();
                        break;
                        
                    //case3: to edit appointment
                    case "3":
                        System.out.print("Enter Appointment ID to edit: ");
                        int editId = Integer.parseInt(scanner.nextLine());
                        System.out.print("New Service: ");
                        String newService = scanner.nextLine();
                        System.out.print("New Date: ");
                        String newDate = scanner.nextLine();
                        System.out.print("New Time: ");
                        String newTime = scanner.nextLine();
                        if (currentUser  instanceof Patient) {
                            ((Patient) currentUser ).editAppointment(editId, newService, newDate, newTime);
                        } else if (currentUser  instanceof Staff) {
                            ((Staff) currentUser ).editAppointment(editId, newService, newDate, newTime);
                        }
                        break;
                        
                    //case:4 to cancel an appointment
                    case "4":
                       System.out.print("Enter Appointment ID to cancel: ");
                        int cancelId = Integer.parseInt(scanner.nextLine());
                        if (currentUser  instanceof Patient) {
                            ((Patient) currentUser ).cancelAppointment(cancelId);
                        } else if (currentUser  instanceof Staff) {
                            ((Staff) currentUser ).cancelAppointment(cancelId);
                        }
                        break;
                        
                    //case 5: to make payment or appointment
                    case "5":
                        System.out.print("Enter Appointment ID to make payment: ");
                        int payId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter payment amount: ");
                        double amount = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter payment method (Cash/Card): ");
                        String method = scanner.nextLine();
                        
                        if (currentUser  instanceof Patient) {
                            ((Patient) currentUser ).makePayment(payId, amount, method);
                        } else if (currentUser  instanceof Staff) {
                            ((Staff) currentUser ).makePayment(payId, amount, method);
                        }
                        break;
                        
                    //Case 6: log out from system
                    case "6":
                        currentUser  = null;
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
