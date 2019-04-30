package com.nokia.microserivice2.nokiamicroserivice2.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nokia.microserivice2.nokiamicroserivice2.DTO.City;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
