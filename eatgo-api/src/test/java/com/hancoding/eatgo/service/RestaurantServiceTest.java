package com.hancoding.eatgo.service;

import com.hancoding.eatgo.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class RestaurantServiceTest {

    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private MenuItemRepository menuItemRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1L, "hancoding", "Daejeon"));
        given(restaurantRepository.findAll()).willReturn(restaurants);

        Restaurant restaurant = new Restaurant(1L, "hancoding", "Daejeon");
        restaurant.addMenuItem(new MenuItem("Kimchi"));

        given(restaurantRepository.findById(1L)).willReturn(Optional.of(restaurant));
        restaurantService = new RestaurantService(
                restaurantRepository, menuItemRepository);
    }

    @Test
    public void getRestaurants() {
        assertThat(restaurantService.getRestaurants().get(0).getName(), is("hancoding"));
    }

    @Test
    public void getRestaurant() {
        Restaurant restaurant = restaurantService.getRestaurant(1L);
        MenuItem menuItem = restaurant.getMenuItems().get(0);

        assertThat(menuItem.getName(), is("Kimchi"));
    }

    @Test
    public void addRestaurant() {
        Restaurant restaurant = new Restaurant("hancoding", "Daejeon");
        Restaurant createdRestaurant = restaurantService.addRestaurant(restaurant);
        assertThat(createdRestaurant.getId(), is(1L));
    }

}