package com.struczad.avionlet.services;

import com.amadeus.exceptions.ResponseException;
import com.struczad.avionlet.dto.ResultDTO;
import com.struczad.avionlet.flightapi.FlightOffersSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class AvionLetService {
    private final FlightOffersSearch flightOffersSearch;
    @Autowired
    public AvionLetService(FlightOffersSearch flightOffersSearch) {
        this.flightOffersSearch = flightOffersSearch;
    }

    public LinkedList<ResultDTO> getResults() throws ResponseException {
        return flightOffersSearch.getFlightResults();
    }
}
