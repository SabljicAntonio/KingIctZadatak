package com.struczad.avionlet.controllers;

import com.amadeus.exceptions.ResponseException;
import com.struczad.avionlet.dto.ResultDTO;
import com.struczad.avionlet.requests.FlightsRequest;
import com.struczad.avionlet.services.AvionLetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;

@Controller
public class AvionLetController {

    private FlightsRequest prevSearch = new FlightsRequest();

    @Autowired
    private final AvionLetService avionLetService;

    public AvionLetController(AvionLetService avionLetService) {
        this.avionLetService = avionLetService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("flightsRequest",new FlightsRequest());
        return "index";
    }

    @PostMapping("/results")
    public String getResults(Model model, @ModelAttribute FlightsRequest flightsRequest) throws ResponseStatusException, ResponseException {
        System.out.println(flightsRequest);
        if(!flightsRequest.toString().equals(prevSearch.toString())) {
            prevSearch = flightsRequest;
            LinkedList<ResultDTO> res = avionLetService.getResults(flightsRequest);
            if(!res.isEmpty()) {
                model.addAttribute("results", res);
            }
        }
        else {
            prevSearch = flightsRequest;
            LinkedList<ResultDTO> res = avionLetService.getCachedResults();
            if(!res.isEmpty()) {
                model.addAttribute("results", res);
            }
        }
        return "results";
    }


}
