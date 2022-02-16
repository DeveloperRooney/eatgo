package com.hancoding.eatgo.service;

import com.hancoding.eatgo.domain.MenuItemRepository;
import com.hancoding.eatgo.domain.Restaurant;
import com.hancoding.eatgo.domain.RestaurantRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant getRestaurant(Long id) {

        Restaurant restaurant = restaurantRepository.findById(id);

        return restaurant;
    }
}
