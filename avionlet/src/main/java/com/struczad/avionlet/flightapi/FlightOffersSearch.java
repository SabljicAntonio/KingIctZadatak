package com.struczad.avionlet.flightapi;

import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.google.gson.Gson;
import com.struczad.avionlet.dto.ResultDTO;
import com.struczad.avionlet.model.FlightOfferSearchEntity;
import com.struczad.avionlet.repository.FlightOfferSearchEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class FlightOffersSearch {
    private final FlightOfferSearchEntityRepository flightOfferSearchEntityRepository;
    @Autowired
    public FlightOffersSearch(FlightOfferSearchEntityRepository flightOfferSearchEntityRepository) {
        this.flightOfferSearchEntityRepository = flightOfferSearchEntityRepository;
    }


    public LinkedList<ResultDTO> getFlightResults(String originLocationCode,
                                                         String destinationLocationCode,
                                                         String departureDate,
                                                         String returnDate,
                                                         String adults,
                                                         String currencyCode) throws ResponseException { //ovo pretvorit u metodu*/

        flightOfferSearchEntityRepository.deleteAll();

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



        Gson gson = new Gson();

        for(FlightOfferSearch res: flightOffersSearches) {
            FlightOfferSearchEntity emp = new FlightOfferSearchEntity();
            emp.setFlightOfferSearchJson(gson.toJson(res));
            flightOfferSearchEntityRepository.save(emp);
        }
        //spremanje u bazu
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

        return resultList;

    }

    public LinkedList<ResultDTO> getFlightResultsCached() throws ResponseException { //ovo pretvorit u metodu*/

        LinkedList<ResultDTO> resultList = new LinkedList<>();
        Gson gson = new Gson();
        List<FlightOfferSearchEntity> entityList = flightOfferSearchEntityRepository.findAll();
        FlightOfferSearch[] flightOffersSearches = new FlightOfferSearch[entityList.size()];


        for(int i=0; i<entityList.size(); i++) {
            FlightOfferSearchEntity flightOfferSearchEntity = entityList.get(i);
            FlightOfferSearch flightOfferSearch = gson.fromJson(flightOfferSearchEntity.getFlightOfferSearchJson(), FlightOfferSearch.class);
            flightOffersSearches[i] = flightOfferSearch;
        }

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


        return resultList;

    }
}