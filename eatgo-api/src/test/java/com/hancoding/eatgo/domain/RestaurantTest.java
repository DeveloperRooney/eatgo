package com.hancoding.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTest {

    @Test
    public void create() {
        Restaurant restaurant = new Restaurant(1L, "hancoding", "Daejeon");

        assertThat(restaurant.getName() , is(""));
    }

    @Test
    public void information() {
        Restaurant restaurant = new Restaurant(1L, "han", "daejeon");

        assertThat(restaurant.getId(), is(1L));
    }

}