package de.telran.g240123mbelesson331082023.service;

import de.telran.g240123mbelesson331082023.domain.entity.Basket;
import de.telran.g240123mbelesson331082023.domain.entity.Client;
import de.telran.g240123mbelesson331082023.domain.entity.Product;
import de.telran.g240123mbelesson331082023.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonClientService implements ClientService{

    @Autowired
    private ClientRepository repository;

    @Autowired
    private ProductService productService;

    @Override
    public List<Client> getAll() {
        return repository.getClients();
    }

    @Override
    public Client getById(int id) {
        return repository.findById(id);
    }

    @Override
    public void add(Client customer) {
        repository.addClient(customer.getName());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        int idToDelete = repository.getClients().stream().filter(x -> x.getName().equals(name)).findFirst().get().getId();
        repository.deleteById(idToDelete);
    }

    @Override
    public int getCount() {
        return repository.getClients().size();
    }

    @Override
    public double getTotalPriceById(int id) {
        return repository.findById(id).getBasket().getTotalPrice();
    }

    @Override
    public double getAveragePriceById(int id) {
        Basket cart = repository.findById(id).getBasket();
        return cart.getTotalPrice() / cart.getProducts().size();
    }

    @Override
    public void addToCartById(int customerId, int productId) {
        Client customer = repository.findById(customerId);
        Product product = productService.getById(productId);
        customer.getBasket().addProduct(product);
    }

    @Override
    public void deleteFromCart(int customerId, int productId) {
        Client customer = repository.findById(customerId);
        customer.getBasket().getProducts().removeIf(x -> x.getId() == productId);
    }

    @Override
    public void clearCart(int customerId) {
        Client customer = repository.findById(customerId);
        customer.getBasket().getProducts().clear();
    }

}
