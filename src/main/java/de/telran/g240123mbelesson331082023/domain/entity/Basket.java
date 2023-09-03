package de.telran.g240123mbelesson331082023.domain.entity;


import java.util.List;

public interface Basket {
    double getTotalPrice();
    void addProduct(Product product);
    List<Product> getProducts();
}
