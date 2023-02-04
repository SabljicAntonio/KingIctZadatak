package com.struczad.avionlet.requests;

import java.util.Date;

public class FlightsRequest {
    private String depAirport;
    private String arrAirport;
    private String depDate;
    private String retDate;
    private String numOfPass;
    private String currency;

    public FlightsRequest() {
        this.depAirport = null;
        this.arrAirport = null;
        this.depDate = null;
        this.retDate = null;
        this.numOfPass = null;
        this.currency = null;
    }

    public FlightsRequest(String depAirport, String arrAirport, String depDate, String retDate, String numOfPass, String currency) {
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
        this.depDate = depDate;
        this.retDate = retDate;
        this.numOfPass = numOfPass;
        this.currency = currency;
    }

    public String getDepAirport() {
        return depAirport;
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public String getDepDate() {
        return depDate;
    }

    public String getRetDate() {
        return retDate;
    }

    public String getNumOfPass() {
        return numOfPass;
    }

    public String getCurrency() {
        return currency;
    }

    public void setDepAirport(String depAirport) {
        this.depAirport = depAirport;
    }

    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    public void setRetDate(String retDate) {
        this.retDate = retDate;
    }

    public void setNumOfPass(String numOfPass) {
        this.numOfPass = numOfPass;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "flightsRequest{" +
                "depAirport='" + depAirport + '\'' +
                ", arrAirport='" + arrAirport + '\'' +
                ", depDate=" + depDate +
                ", retDate=" + retDate +
                ", numOfPass=" + numOfPass +
                ", currency='" + currency + '\'' +
                '}';
    }
}
