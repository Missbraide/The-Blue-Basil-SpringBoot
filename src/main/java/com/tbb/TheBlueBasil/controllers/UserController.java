package com.tbb.TheBlueBasil.controllers;

import com.tbb.TheBlueBasil.models.User;
import com.tbb.TheBlueBasil.services.MenuService;
import com.tbb.TheBlueBasil.services.ReservationService;
import com.tbb.TheBlueBasil.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = "users")
public class UserController {
    UserService userService;
    MenuService menuService;
    ReservationService reservationService;

    @Autowired
    public UserController(UserService userService, MenuService menuService, ReservationService reservationService) {
        this.userService = userService;
        this.reservationService = reservationService;
        this.menuService = menuService;
    }

    @GetMapping
    public String getAllUsers(Model model, Principal principal){

        log.info(principal.getName());
        model.addAttribute("users",userService.findAll());

        return "users";
    }

    @PostMapping("/findUsername")
    public RedirectView findUsername(@RequestParam(required = false) String email, RedirectAttributes redirectAttributes){

        try {

//            redirectAttributes.addFlashAttribute("user", userService.findByUsername(username);
        } catch (RuntimeException ex){
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("user_not_found",String.format("Username: %s not found!",email));
            return new RedirectView("/students");
        }
        return new RedirectView("/students");
    }


    @GetMapping(value="/newuserform")
    public String newUserForm(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }

    @PostMapping("/saveupdateuser")
    public String saveUpdateUser(RedirectAttributes model, @ModelAttribute("user") User user){
      userService.saveOrUpdate(user);
        model.addFlashAttribute("user",userService.findByEmail(user.getEmail()));
        return "signup";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") String email) {

        // call delete employee method
        this.userService.deleteUserById(email);
        return "redirect:/saveupdateuser";
    }

}
