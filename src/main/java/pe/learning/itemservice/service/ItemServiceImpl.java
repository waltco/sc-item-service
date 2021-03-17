package pe.learning.itemservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.learning.itemservice.model.Item;
import pe.learning.itemservice.model.Product;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    final RestTemplate restTemplate;

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays
                .asList(restTemplate.getForObject("http://localhost:8001/products/", Product[].class));
        return products.stream().map(Item::new).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());
        Product product = restTemplate.getForObject("http://localhost:8001/product/{id}", Product.class, pathVariables);
        return new Item(product,quantity);
    }
}
