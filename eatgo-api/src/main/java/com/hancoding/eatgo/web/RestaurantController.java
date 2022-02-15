package com.hancoding.eatgo.web;

import com.hancoding.eatgo.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> list() {

        List<Restaurant> list = new ArrayList<>();
        list.add(new Restaurant(1L, "hancoding", "Daejeon"));
        return list;
    }

}
