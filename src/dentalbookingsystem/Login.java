/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dentalbookingsystem;

/**
 *AUTHOR : SITI NUR AZRINA
 *CLASS :Login.JAVA
 *DESC : CLASS THAT HAS METHOD AND DATA FIELD FOR Login
 */
import java.util.ArrayList;
public class Login {
    //create arrayList that store multiple object of class user
    private ArrayList<User> users;
    //class constructor
    public Login() {
        users = new ArrayList<>();
        users.add(new User("Aiman", "aiman1234"));
        users.add(new User("Asyraf", "acap1234"));
        users.add(new User("Azrina", "rina1234"));

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
        return null;//return null if password and username no match
        
    }
}

