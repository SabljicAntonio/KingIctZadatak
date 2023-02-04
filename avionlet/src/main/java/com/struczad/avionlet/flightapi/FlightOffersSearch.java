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

    public static LinkedList<ResultDTO> getFlightResults(String originLocationCode,
                                   String destinationLocationCode,
                                   String departureDate,
                                   String returnDate,
                                   String adults,
                                   String currencyCode) throws ResponseException { //ovo pretvorit u metodu*/

        Amadeus amadeus = Amadeus
                .builder("LOGAnsNM3wjjueRtOLrYIAa6JLBQAJzE","BZSbIb9K2lHkEE40")
                .build();


        FlightOfferSearch[] flightOffersSearches = null;

        if(returnDate == null) {
            flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
                    Params.with("originLocationCode", originLocationCode)
                            .and("destinationLocationCode", destinationLocationCode)
                            .and("departureDate", departureDate) //format yyyy-mm-dd
                            .and("adults", Integer.valueOf(adults))
                            .and("currencyCode", currencyCode));
        } else {
             flightOffersSearches = amadeus.shopping.flightOffersSearch.get(
                    Params.with("originLocationCode", originLocationCode)
                            .and("destinationLocationCode", destinationLocationCode)
                            .and("departureDate", departureDate) //format yyyy-mm-dd
                            .and("returnDate", returnDate) //format yyyy-mm-dd
                            .and("adults", Integer.valueOf(adults))
                            .and("currencyCode", currencyCode));
        }



        if (flightOffersSearches[0].getResponse().getStatusCode() != 200) {
            System.out.println("Wrong status code: " + flightOffersSearches[0].getResponse().getStatusCode());
            System.exit(-1);
        }

        LinkedList<ResultDTO> resultList = new LinkedList<>();
        Arrays.stream(flightOffersSearches).forEach((offer) -> {
            ResultDTO resultDTO = new ResultDTO(
                offer.getItineraries()[0].getSegments()[0].getDeparture().getIataCode(),
                offer.getItineraries()[0].getSegments()[offer.getItineraries()[0].getSegments().length-1].getArrival().getIataCode(),
                offer.getItineraries()[0].getSegments()[0].getDeparture().getAt(),
                offer.getItineraries().length == 2 ? offer.getItineraries()[offer.getItineraries().length-1].getSegments()[0].getDeparture().getAt() : null,
                String.valueOf(offer.getItineraries()[0].getSegments().length - 1),
                offer.getItineraries().length == 2 ? String.valueOf(offer.getItineraries()[offer.getItineraries().length-1].getSegments().length - 1) : null,
                String.valueOf(offer.getTravelerPricings().length),
                offer.getPrice().getCurrency(),
                offer.getPrice().getGrandTotal()
            );
            resultList.add(resultDTO);
        });

        // Rezultati se trebaju spremiti u bazu takoder

        return resultList;

    }
}