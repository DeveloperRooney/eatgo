package com.hancoding.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {

    private List<Restaurant> list = new ArrayList<>();

    public RestaurantRepository() {
        list.add(new Restaurant(1L, "hancoding", "Daejeon"));
        list.add(new Restaurant(2L, "hancoding", "Daejeon"));
    }

    public List<Restaurant> findAll() {
        return list;
    }

    public Restaurant findById(Long id) {
        Restaurant restaurant = list.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);

        return restaurant;
    }
}
