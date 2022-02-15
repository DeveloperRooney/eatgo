package com.hancoding.eatgo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class Restaurant {

    private final Long id;
    private final String name;
    private final String address;

    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getInformation() {
        return name + " in " + address;
    }
}
