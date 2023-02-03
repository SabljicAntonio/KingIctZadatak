package com.struczad.avionlet.flightapi;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.google.gson.Gson;
import com.struczad.avionlet.dto.ResultDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;

@Component
public class FlightOffersSearch {

    public static void main(String[] args) throws ResponseException { //ovo pretvorit u metodu

        Amadeus amadeus = Amadeus
                .builder("LOGAnsNM3wjjueRtOLrYIAa6JLBQAJzE","BZSbIb9K2lHkEE40")
                .build();

        //promjenit da se dohvaca na parametre
        FlightOfferSearch[] flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
                Params.with("originLocationCode", "SYD")
                        .and("destinationLocationCode", "BKK")
                        .and("departureDate", "2023-05-02") //format yyyy-mm-dd
                        .and("returnDate", "2023-11-08") //format yyyy-mm-dd
                        .and("adults", 1)
                        .and("currencyCode", "USD"));



        if (flightOffersSearches[0].getResponse().getStatusCode() != 200) {
            System.out.println("Wrong status code: " + flightOffersSearches[0].getResponse().getStatusCode());
            System.exit(-1);
        }
        // Rezultati se trebaju spremiti u bazu takoder

        LinkedList<ResultDTO> resultList = new LinkedList<>();
        //Arrays.stream(flightOffersSearches).forEach((offer) -> System.out.println(offer)); //tu se izlistaju sve ponude na konzoli
        /*Arrays.stream(flightOffersSearches).forEach((offer) -> {
            ResultDTO resultDTO = new ResultDTO(
                    offer.getItineraries().
            );

        });*/
    }
}