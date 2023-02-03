package com.struczad.avionlet.controllers;

import com.amadeus.exceptions.ResponseException;
import com.struczad.avionlet.dto.ResultDTO;
import com.struczad.avionlet.services.AvionLetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;

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

    /*@PostMapping("/results")
    public String getResults(@ModelAttribute Model model) throws ResponseException {
        model.addAttribute("search-results",avionLetService.getResults());
        return "results";
    }*/
    @GetMapping("/results")
    public String getResults(Model model) throws ResponseException {
        model.addAttribute("results",avionLetService.getResults());
        return "results";
    }

}
