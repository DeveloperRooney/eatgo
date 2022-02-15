package com.hancoding.eatgo.web;

import com.hancoding.eatgo.domain.MenuItem;
import com.hancoding.eatgo.domain.MenuItemRepository;
import com.hancoding.eatgo.domain.Restaurant;
import com.hancoding.eatgo.domain.RestaurantRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantRepositoryImpl restaurantRepository;
    private final MenuItemRepository menuItemRepository;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantRepository.findById(id);

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        return restaurant;
    }
}
