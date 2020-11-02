package com.example.eatgo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAll();

    Optional<Restaurant> findById(Long id); //optional은 restaurant가 있는지 없는지 직접 구분하는 타입

    Restaurant save(Restaurant restaurant);
}
