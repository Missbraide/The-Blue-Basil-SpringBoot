package com.tbb.TheBlueBasil.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping(value = {"/", "index"})
    public String viewHomePage(){return "index";}
}
