package com.zmp.api;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import com.zmp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * API for Users
 * this class can be used to communicate with the database (Rest endpoint)
 */

@RestController
@RequestMapping("/api/users")
public class UsermanagementRestController {

    UserRepository userRepository;
    UserService userService;

    /**
     * Constructor is called on application start
     */
    public UsermanagementRestController(UserRepository userRepository, UserService userService){
        this.userRepository= userRepository;
        this.userService = userService;
    }

    /**
     * Function to get a list of all users by GET request
     * @return returns A HTTP responsentity with a list of all users
     */
    @GetMapping("/userlist")
    public List<User> test() {
        return userRepository.findAll();
    }

    /**
     * Function to delete a user by DELETE request
     * @return returns A HTTP responsentity with status code 200 if success
     */
    @DeleteMapping( "/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id){
        System.out.println("deleting User");
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Function to edit a user by POST request
     * @return returns A HTTP responsentity with the newly edited User
     */
    @PostMapping("/edit")
    public void editUser(@RequestBody User user){
        userService.updateUser(user);
    }

    /**
     * Function to edit a user by POST request
     * @return returns A HTTP responsentity with the newly edited User
     */
    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody User user){
        user.setUsername(user.getFirstName()+user.getLastName());
        List<User> users  = userService.getAllUsers();
        for(User tmp : users){
            if(tmp.getEmail().equals(user.getEmail())){
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
