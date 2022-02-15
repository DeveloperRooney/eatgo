package com.hancoding.eatgo.web;

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

    private final RestaurantRepositoryImpl repository;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        return repository.findAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
}
