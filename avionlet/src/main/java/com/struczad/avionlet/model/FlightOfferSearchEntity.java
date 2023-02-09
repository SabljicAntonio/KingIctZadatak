package com.struczad.avionlet.model;

import jakarta.persistence.*;


@Entity
@Table(name = "FlightOfferSearchTable")
public class FlightOfferSearchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Lob
    private String FlightOfferSearchJson;

    public FlightOfferSearchEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightOfferSearchJson() {
        return FlightOfferSearchJson;
    }

    public void setFlightOfferSearchJson(String flightOfferSearchJson) {
        FlightOfferSearchJson = flightOfferSearchJson;
    }


}
