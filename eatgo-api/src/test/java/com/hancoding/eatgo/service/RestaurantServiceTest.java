package com.hancoding.eatgo.service;

import com.hancoding.eatgo.domain.MenuItemRepository;
import com.hancoding.eatgo.domain.Restaurant;
import com.hancoding.eatgo.domain.RestaurantRepository;
import com.hancoding.eatgo.domain.RestaurantRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantServiceTest {

    private RestaurantService restaurantService;
    RestaurantRepository restaurantRepository;

    @Before
    public void setUp() {
        restaurantRepository = new RestaurantRepositoryImpl();
        restaurantService = new RestaurantService(restaurantRepository);
    }

    @Test
    public void getRestaurant() {
        Restaurant restaurant = restaurantService.getRestaurant(1L);

        assertThat(restaurant.getName(), is("hancoding"));
    }

}