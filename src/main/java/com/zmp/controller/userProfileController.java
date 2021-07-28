package com.zmp.controller;

import com.zmp.model.User;
import com.zmp.model.dto.UserFormDto;
import com.zmp.repositories.UserRepository;
import com.zmp.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to manage user profile view
 */
@Controller
@RequestMapping("/userprofile")
public class userProfileController {

    private final UserRepository repository;
    private final UserService userService;
    private User user;

    public userProfileController(UserRepository repository, UserService userService){
        this.userService = userService;
        this.repository = repository;
    }

    @GetMapping
    public String user(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = auth.getName();
        User user = repository.findByEmail(currentPrincipalName);
        this.user = user;
        UserFormDto dto = new UserFormDto();
        dto = dto.setFormDto(user);
        model.addAttribute("dto", dto);
        return "userProfile";
    }

    @PostMapping
    public String editPassword(@ModelAttribute("dto") UserFormDto userFormDto){
        String password = userFormDto.getNewPw();
        user.setPassword(password);
        userService.editPassword(user);
        return "redirect:/logout";
    }
}
