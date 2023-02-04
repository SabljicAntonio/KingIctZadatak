package com.struczad.avionlet.services;

import com.amadeus.exceptions.ResponseException;
import com.struczad.avionlet.dto.ResultDTO;
import com.struczad.avionlet.flightapi.FlightOffersSearch;
import com.struczad.avionlet.requests.FlightsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public LinkedList<ResultDTO> getResults(FlightsRequest flightsRequest) throws ResponseException {
        String originLocationCode = flightsRequest.getDepAirport();
        String destinationLocationCode = flightsRequest.getArrAirport();
        String departureDate = flightsRequest.getDepDate();
        String returnDate = flightsRequest.getRetDate();
        String adults = flightsRequest.getNumOfPass();
        String currencyCode = flightsRequest.getCurrency();

        return flightOffersSearch.getFlightResults(originLocationCode,destinationLocationCode,departureDate,returnDate,adults,currencyCode);
    }
}
