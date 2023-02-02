package com.struczad.avionlet.controllers;

import com.struczad.avionlet.services.AvionLetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AvionLetController {

    @Autowired
    private final AvionLetService avionLetService;

    public AvionLetController(AvionLetService avionLetService) {
        this.avionLetService = avionLetService;
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @PostMapping("/results")
    public String getResults() {
        return "results";
    }
}
