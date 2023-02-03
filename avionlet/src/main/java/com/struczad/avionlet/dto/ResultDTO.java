package com.struczad.avionlet.dto;

public class ResultDTO {
    private final String departureAirport;
    private final String arrivalAirport;
    private final String departureDate;
    private final String returnDate;
    private final String numberOfLayoversDeparture;
    private final String numberOfLayoversReturn;
    private final String numberOfTravellers;
    private final String currency;
    private final String finalPrice;

    public ResultDTO(String departureAirport,
                     String arrivalAirport,
                     String departureDate,
                     String returnDate,
                     String numberOfLayoversDeparture,
                     String numberOfLayoversReturn,
                     String numberOfTravellers,
                     String currency,
                     String finalPrice) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.numberOfLayoversDeparture = numberOfLayoversDeparture;
        this.numberOfLayoversReturn = numberOfLayoversReturn;
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

    public String getReturnDate() {
        return returnDate;
    }

    public String getNumberOfLayoversDeparture() {
        return numberOfLayoversDeparture;
    }

    public String getnumberOfLayoversReturn() {
        return numberOfLayoversReturn;
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

    @Override
    public String toString() {
        return "ResultDTO{" +
                "departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", numberOfLayoversDeparture='" + numberOfLayoversDeparture + '\'' +
                ", numberOfLayoversReturn='" + numberOfLayoversReturn + '\'' +
                ", numberOfTravellers='" + numberOfTravellers + '\'' +
                ", currency='" + currency + '\'' +
                ", finalPrice='" + finalPrice + '\'' +
                '}';
    }
}
