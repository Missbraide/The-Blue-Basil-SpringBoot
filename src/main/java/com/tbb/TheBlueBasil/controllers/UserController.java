package com.tbb.TheBlueBasil.controllers;

import com.tbb.TheBlueBasil.models.User;
import com.tbb.TheBlueBasil.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(value = "users")
public class UserController {

BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // display list of users
    @GetMapping("/listUsers")
    public String viewUsersPage(Model model) {
        model.addAttribute("listUsers",userService.getAllUsers());
        return "user";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model) {
        // create model attribute to bind form data
        User user = new User();
        model.addAttribute("user", user);
        return "new-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        // save user to database
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
     userService.saveUsers(user);
        return "redirect:/users/listUsers";
    }



    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get user from the service
        User user = userService.getUserById(id);

        // set  user as a model attribute to pre-populate the form
        model.addAttribute("user", user);
        return "update-user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {

        // call delete  user method
        this. userService.deleteUserById(id);
        return "redirect:/users/listUsers";
    }

//    @PostMapping("/findUserName")
//    public RedirectView findUserId(@RequestParam(required = false) String email, RedirectAttributes redirectAttributes){
//        log.warn("email: " + email);
//        try {
//            redirectAttributes.addFlashAttribute("user", userService.findByEmail(email));
//        } catch (RuntimeException ex){
//            ex.printStackTrace();
//            redirectAttributes.addFlashAttribute("user_not_found",String.format("Username: %s not found!", email));
//            return new RedirectView("/listUsers");
//        }
//        return new RedirectView("/listUsers");
//    }

}
//    UserService userService;
//    MenuService menuService;
//    ReservationService reservationService;
//
//    @Autowired
//    public UserController(UserService userService, MenuService menuService, ReservationService reservationService) {
//        this.userService = userService;
//        this.reservationService = reservationService;
//        this.menuService = menuService;
//    }
//
//    @GetMapping
//    public String getAllUsers(Model model, Principal principal){
//
//        log.info(principal.getName());
//        model.addAttribute("users",userService.findAll());
//
//        return "users";
//    }
//
//    @PostMapping("/findUsername")
//    public RedirectView findUsername(@RequestParam(required = false) String email, RedirectAttributes redirectAttributes){
//
//        try {
//
////            redirectAttributes.addFlashAttribute("user", userService.findByUsername(username);
//        } catch (RuntimeException ex){
//            ex.printStackTrace();
//            redirectAttributes.addFlashAttribute("user_not_found",String.format("Username: %s not found!",email));
//            return new RedirectView("/students");
//        }
//        return new RedirectView("/students");
//    }
//
//
//    @GetMapping(value="/newuserform")
//    public String newUserForm(Model model){
//        model.addAttribute("user",new User());
//        return "signup";
//    }
//
//    @PostMapping("/saveupdateuser")
//    public String saveUpdateUser(RedirectAttributes model, @ModelAttribute("user") User user){
//        userService.saveOrUpdate(user);
//        model.addFlashAttribute("user",userService.findByEmail(user.getEmail()));
//        return "signup";
//    }
//
//    @GetMapping("/deleteUser/{id}")
//    public String deleteUser(@PathVariable(value = "id") String email) {
//
//        // call delete user method
//        this.userService.deleteUserById(email);
//        return "redirect:/saveupdateuser";
//    }
//
//}