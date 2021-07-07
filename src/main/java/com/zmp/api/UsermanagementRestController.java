package com.zmp.api;

import com.zmp.model.User;
import com.zmp.repositories.UserRepository;
import com.zmp.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
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

    //diese methode funktioniert noch nicht
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/edit")
    public void ediUser(@RequestBody User user){
        userService.updateUser(user);
    }
}
