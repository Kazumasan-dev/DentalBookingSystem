/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dentalbookingsystem;

/**
 *AUTHOR:MUHAMMAD AIMAN,SITI NUR AZRINA ,ASYRAF NABIL
 *MATRIC NO:S74699,S74720,S74594
 *CLASS :Login.java
 *DESC : class that have data field and method for Login
 */
import java.util.ArrayList;
public class Login {
    //create arrayList that store multiple object of class user
    private ArrayList<User> users;
    
    //class constructor
    public Login() {
        users = new ArrayList<>();
        users.add(new Patient("Aiman", "aiman1234"));
        users.add(new Patient("Asyraf", "acap1234"));
        users.add(new Staff("Azrina", "rina1234"));

    }
    
    
    //method to authenticate username and password entered by user
    public User authenticate(String username, String password) {
        //for each loop to reach each object in users array list
        for (User u : users) {
            //condition to check the username and password entered by user
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;//return value of user
            }
        }
        return null;//return null if password and username not match
        
    }
}

