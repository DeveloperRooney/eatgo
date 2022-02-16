package com.hancoding.eatgo.web;

import com.hancoding.eatgo.domain.*;
import com.hancoding.eatgo.service.RestaurantService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestaurantService restaurantService;

//    @SpyBean(RestaurantService.class)
//    private RestaurantService restaurantService;
//
//    @SpyBean(RestaurantRepositoryImpl.class) // test에 의존성 주입
//    private RestaurantRepository restaurantRepository;
//
//    @SpyBean(MenuItemRepositoryImpl.class)
//    private MenuItemRepository menuItemRepository;

    @Test
    @DisplayName("음식점 리스트")
    public void list() throws Exception {

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1L, "hancoding", "Daejeon"));
        given(restaurantService.getRestaurants()).willReturn(restaurants);

        mvc.perform(get("/restaurants")).andExpect(status().isOk())
                .andExpect(content().string(containsString("hancoding")));
    }
    
    @Test
    @DisplayName("음식점 상세정보")
    public void detail() throws Exception {

        Restaurant restaurant = new Restaurant(1L, "chelsea", "chelsea");
        restaurant.addMenuItem(new MenuItem("hello"));
        given(restaurantService.getRestaurant(1L)).willReturn(restaurant);

        mvc.perform(get("/restaurants/1")).andExpect(status().isOk())
                .andExpect(content().string(containsString("chelsea")))
                .andExpect(content().string(containsString("hello")));
    }

    @Test
    public void create() throws Exception {

        Restaurant restaurant = new Restaurant(1L, "hancoding", "Daejeon");

        mvc.perform(post("/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"hancoding\",\"address\":\"Daejeon\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/restaurants/1"))
                .andExpect(content().string(containsString("{}")));

        verify(restaurantService).addRestaurant(any());
    }
}