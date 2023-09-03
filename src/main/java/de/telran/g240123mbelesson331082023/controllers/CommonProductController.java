package de.telran.g240123mbelesson331082023.controllers;

import de.telran.g240123mbelesson331082023.domain.entity.Product;
import de.telran.g240123mbelesson331082023.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class CommonProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id) {
        return productService.getById(id);
    }

    @PatchMapping
    public void add(@RequestBody Product product) {
        productService.add(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        productService.deleteById(id);
    }

    @DeleteMapping("/delete_name/{name}")
    public void deleteByName(@PathVariable String name) {
        productService.deleteByName(name);
    }

    @GetMapping("/size")
    public int getCount() {
        return productService.getCount();
    }

    @GetMapping("/total_price")
    public double getTotalPrice() {
        return productService.getTotalPrice();
    }

    @GetMapping("/average_price")
    public double getAveragePrice() {
        return productService.getAveragePrice();
    }
}
