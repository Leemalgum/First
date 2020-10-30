package com.example.eatgo.interfaces;

import com.example.eatgo.domain.MenuItem;
import com.example.eatgo.domain.MenuItemRepository;
import com.example.eatgo.domain.Restaurant;
import com.example.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //component의 일종
public class RestaurantController {

    @Autowired //Spring이 자동으로 repository 객체를 생성, 연결해줌
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
//        Restaurant restaurant = restaurantService.getRestaruantById(id); //기본 정보 + 메뉴 정보


        Restaurant restaurant = restaurantRepository.findById(id);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);
        restaurant.addMenuItem(new MenuItem("Kimchi"));

        return restaurant;
    }
}
