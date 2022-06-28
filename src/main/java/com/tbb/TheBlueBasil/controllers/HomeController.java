package com.tbb.TheBlueBasil.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
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
