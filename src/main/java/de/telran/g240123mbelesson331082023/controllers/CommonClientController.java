package de.telran.g240123mbelesson331082023.controllers;

import de.telran.g240123mbelesson331082023.domain.entity.Client;
import de.telran.g240123mbelesson331082023.domain.entity.CommonClient;
import de.telran.g240123mbelesson331082023.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class CommonClientController {

    @Autowired
    private ClientService service;


    @GetMapping
    public List<Client> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Client getByID(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping()
    public void createClient(@RequestBody CommonClient client) {
        service.add(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClientById(@PathVariable int id) {
        service.deleteById(id);
    }

    @DeleteMapping("/name/{name}")
    public void deleteClientByName(@PathVariable String name) {
        service.deleteByName(name);
    }

    @GetMapping("/get_count")
    public int getCount() {
        return service.getCount();
    }

    @GetMapping("/total_price/{id}")
    public double getTotalPriceById(@PathVariable int id) {
        return service.getTotalPriceById(id);
    }

    @GetMapping("/avg_price/{id}")
    public double getAveragePriceById(@PathVariable int id) {
        return service.getAveragePriceById(id);
    }

    @PatchMapping("/basket/add/{customer_id}/{product_id}")
    public void addToCartById(@PathVariable int customer_id, @PathVariable int product_id) {
        service.addToCartById(customer_id, product_id);
    }

    @PatchMapping("/basket/delete/{customer_id}/{product_id}")
    public void deleteFromCartById(@PathVariable int customer_id, @PathVariable int product_id) {
        service.deleteFromCart(customer_id, product_id);
    }

    @PatchMapping("/basket/clear/{customer_id}")
    public void clearBasket(@PathVariable int customer_id) {
        service.clearCart(customer_id);
    }
}
