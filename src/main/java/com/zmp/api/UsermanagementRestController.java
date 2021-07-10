package com.zmp.api;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import com.zmp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsermanagementRestController {

    UserRepository userRepository;
    UserService userService;

    public UsermanagementRestController(UserRepository userRepository, UserService userService){
        this.userRepository= userRepository;
        this.userService = userService;
    }

    @GetMapping("/userlist")
    public List<User> test() {
        return userRepository.findAll();
    }

    @DeleteMapping( "/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id){
        System.out.println("deleting User");
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/edit")
    public void editUser(@RequestBody User user){
        userService.updateUser(user);
    }
}
