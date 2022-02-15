package com.hancoding.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private List<Restaurant> list = new ArrayList<>();

    public RestaurantRepositoryImpl() {
        list.add(new Restaurant(1L, "hancoding", "Daejeon"));
        list.add(new Restaurant(2L, "hancoding", "Daejeon"));
    }

    @Override
    public List<Restaurant> findAll() {
        return list;
    }

    @Override
    public Restaurant findById(Long id) {
        Restaurant restaurant = list.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);

        return restaurant;
    }
}
