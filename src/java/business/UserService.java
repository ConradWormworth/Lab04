/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author 612944
 */
public class UserService {
    
    private final ArrayList<User> userList;
    User adam = new User("adam", "password");
    User betty = new User("betty", "password");
    
    public UserService()
    {
        userList = new ArrayList<>(2);
        userList.add(adam);
    }    

    
    /**
     * Checks the attempted login against a list of existing users.
     * Returns a User object with the accepted username and a null password
     * if login is successful; otherwise, simply returns null.
     * @param username
     * @param password
     * @return 
     */
    public User Login(String username, String password){
    
        User loginAttempt = new User(username, password);
        User checkedUser;
        for(int i = 0; i < userList.size(); i++){
            checkedUser = userList.get(i);
            if((loginAttempt.getUsername().equals(checkedUser.getUsername())) &&
                    (loginAttempt.getPassword().equals(checkedUser.getPassword()))){
                    
                    User returnableUser = new User(checkedUser.getUsername(), null);
                    return returnableUser;
            }
            
        }
    // If the attempted login does not match any existing users...
    return null;
    }
    
}
