package com.struczad.avionlet.repository;

import com.struczad.avionlet.model.FlightOfferSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightOfferSearchEntityRepository extends JpaRepository<FlightOfferSearchEntity, Integer> {
}