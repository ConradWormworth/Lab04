/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author 612944
 */
public class userService {
    
   
    
    private final User adam = new User("adam", "password");
    private final User betty = new User("betty", "password");
    
    ArrayList<User> users = new ArrayList<>(Arrays.asList(adam, betty));
    

    public userService() {
       
    }
    
    public User Login(String username, String password){
    
        User loginAttempt = new User(username, password);
        
        for (int i = 0; i < users.size(); i++) {
            
            // Check attempt against existing usernames
            if (loginAttempt.getUsername().equals(users.get(i).getUsername())) {
                // ... If username exists, check if password matches
                if(loginAttempt.getPassword().equals(users.get(i).getUsername())) {
                    /// ... Successful login
                    loginAttempt.setPassword(null);
                    return loginAttempt;
                }
            }
        }
        // ... Failed login 
        return null;
    }
    
}
