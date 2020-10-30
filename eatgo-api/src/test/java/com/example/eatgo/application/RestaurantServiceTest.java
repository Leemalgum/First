package com.example.eatgo.application;

import com.example.eatgo.domain.Restaurant;
import com.example.eatgo.domain.RestaurantRepository;
import com.example.eatgo.domain.RestaurantRepositoryImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantServiceTest {

    private RestaurantService restaurantService;
    
    @Before
    public void setUp(){
        RestaurantRepository restaurantRepository = new RestaurantRepositoryImpl();
        restaurantService = new RestaurantService(restaurantRepository);
        
    }

    @Test
    public void getRestaurant(){
        Restaurant restaurant = restaurantService.getRestaurant(1004L);

        assertThat(restaurant.getId(), is(1004L));
    }
}