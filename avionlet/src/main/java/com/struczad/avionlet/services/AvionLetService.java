package com.struczad.avionlet.services;

import com.amadeus.exceptions.ResponseException;
import com.struczad.avionlet.dto.ResultDTO;
import com.struczad.avionlet.flightapi.FlightOffersSearch;
import com.struczad.avionlet.requests.FlightsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

@Service
public class AvionLetService {
    private final FlightOffersSearch flightOffersSearch;
    @Autowired
    public AvionLetService(FlightOffersSearch flightOffersSearch) {
        this.flightOffersSearch = flightOffersSearch;
    }

    public LinkedList<ResultDTO> getResults(FlightsRequest flightsRequest) throws ResponseStatusException {
        LinkedList<ResultDTO> results;
        String originLocationCode = flightsRequest.getDepAirport();
        String destinationLocationCode = flightsRequest.getArrAirport();
        String departureDate = flightsRequest.getDepDate();
        String returnDate = flightsRequest.getRetDate();
        String adults = flightsRequest.getNumOfPass();
        String currencyCode = flightsRequest.getCurrency();

        if(originLocationCode.equals("") || destinationLocationCode.equals("") || departureDate.equals("") || adults.equals("") || currencyCode.equals("")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fill manditory fields!");
        }

        if(returnDate.equals("")) {
            returnDate = null;
        }
        try {
            results = flightOffersSearch.getFlightResults(originLocationCode, destinationLocationCode, departureDate, returnDate, adults, currencyCode);
        }
        catch(ResponseException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong paramaters for searching!");
        }

        return results;
    }
}
