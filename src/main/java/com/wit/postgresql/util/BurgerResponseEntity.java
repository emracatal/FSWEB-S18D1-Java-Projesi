package com.wit.postgresql.util;

import com.wit.postgresql.dto.BurgerResponse;
import com.wit.postgresql.entity.Burger;

import java.util.ArrayList;
import java.util.List;

public class BurgerResponseEntity {
    public static List<BurgerResponse> burgerToBurgerResponse(List<Burger>burgers){
        List<BurgerResponse> responses = new ArrayList<>();
        for(Burger burger: burgers){
            responses.add(new BurgerResponse(burger.getName(), burger.getPrice()));
        }
        return responses;
    }
}
