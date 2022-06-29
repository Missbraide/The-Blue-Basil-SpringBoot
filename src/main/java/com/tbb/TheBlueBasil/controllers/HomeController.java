package com.tbb.TheBlueBasil.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller @Slf4j
public class HomeController {
    @GetMapping(value = {"/", "index"})
    public String viewHomePage(){return "index";}

    @GetMapping(value = {"/our-story"})
    public String viewOurStoryPage(){return "our-story";}

    @GetMapping(value = {"/menu"})
    public String viewOurMenuPage(){return "menu";}


    @GetMapping(value = {"/reservation"})
    public String viewReservationPage(){return "reservation";}

}

//    @GetMapping("/login")
//    public String login(){
//        return "login";
//    }
//
//    @GetMapping("/403")
//    public String accessDenied(){
//        return "403";
//    }
//}

