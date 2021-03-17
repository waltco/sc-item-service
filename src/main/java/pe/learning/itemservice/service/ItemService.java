package pe.learning.itemservice.service;

import pe.learning.itemservice.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();
    Item findById(Long id, Integer quantity);

}
