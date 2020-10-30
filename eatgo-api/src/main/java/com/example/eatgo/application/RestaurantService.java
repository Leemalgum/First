package com.example.eatgo.application;

import com.example.eatgo.domain.Restaurant;
import com.example.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant getRestaurant(Long id){
        Restaurant restaurant = restaurantRepository.findById(id);
        return restaurant;

    }
}
