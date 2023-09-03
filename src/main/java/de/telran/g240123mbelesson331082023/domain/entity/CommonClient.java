package de.telran.g240123mbelesson331082023.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CommonClient implements Client {
    private int id;
    private String name;
    private Basket basket;
}
