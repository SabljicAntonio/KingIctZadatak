package com.struczad.avionlet.dto;

public class ResultDTO {
    private final String departureAirport;
    private final String arrivalAirport;
    private final String departureDate;
    private final String arrivalDate;
    private final String numberOfLayoversDeparture;
    private final String numberOfLayoversArrival;
    private final String numberOfTravellers;
    private final String currency;
    private final String finalPrice;

    public ResultDTO(String departureAirport,
                     String arrivalAirport,
                     String departureDate,
                     String arrivalDate,
                     String numberOfLayoversDeparture,
                     String numberOfLayoversArrival,
                     String numberOfTravellers,
                     String currency,
                     String finalPrice) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.numberOfLayoversDeparture = numberOfLayoversDeparture;
        this.numberOfLayoversArrival = numberOfLayoversArrival;
        this.numberOfTravellers = numberOfTravellers;
        this.currency = currency;
        this.finalPrice = finalPrice;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getNumberOfLayoversDeparture() {
        return numberOfLayoversDeparture;
    }

    public String getNumberOfLayoversArrival() {
        return numberOfLayoversArrival;
    }

    public String getNumberOfTravellers() {
        return numberOfTravellers;
    }

    public String getCurrency() {
        return currency;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

}
