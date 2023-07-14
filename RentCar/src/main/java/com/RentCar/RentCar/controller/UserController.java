package com.RentCar.RentCar.controller;

import com.RentCar.RentCar.dto.RegistrationDto;
import com.RentCar.RentCar.entity.User;
import com.RentCar.RentCar.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //handler method to handle login page request
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

    //handle method to handle user registration form submit request
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result, Model model) {


        User existingEmail = userService.findByEmail(user.getEmail());
        if (existingEmail != null && existingEmail.getEmail() != null && !existingEmail.getEmail().isEmpty()) {
            result.rejectValue("email", null, "There is already a user with same email id");
        }
        User existingPesel = userService.findByPesel(user.getPesel());
        if (existingPesel != null && existingPesel.getPesel() != null && !existingPesel.getPesel().isEmpty()) {
            result.rejectValue("pesel", null, "There is already a user with same pesel");
        }
        if (!user.isPasswordsMatch(user.getPassword(), user.getConfirmPassword())) {
            result.rejectValue("confirmPassword", null, "Passwords do not match");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";

    }

    //handler method to handle show all Guest Users from admin side
    @GetMapping("/admin/administration_users")
    public String findGuestUsers(Model model) {
        List<User> users = userService.getUsersByRoleId(2L);
        model.addAttribute("users", users);
        return "admin/administration_users";
    }

    //handler method to handle delete guest user from admin side
     @GetMapping("/admin/administration_users/{userId}/delete")
    public String deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteById(userId);
        return "redirect:/admin/administration_users";
    }
    //handler method to handle view guest user  from admin side
    @GetMapping("/admin/administration_users/{userId}/view")
    public String showGuestUser(@PathVariable("userId") Long userId, Model model) {
        User user = userService.findUserById(userId);

        if (user != null) {
            model.addAttribute("user", user);
            return "admin/view_user";
        } else {
            // Obsługa braku znalezionego użytkownika - np. przekierowanie na stronę błędu
            return "/admin/administration_users";
        }
    }
}


