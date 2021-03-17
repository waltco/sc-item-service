package pe.learning.itemservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.learning.itemservice.model.Item;
import pe.learning.itemservice.service.ItemService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    final ItemService itemService;

    @GetMapping("/items")
    public List<Item> findAll(){
        return itemService.findAll();
    }


    @GetMapping("/item")
    public Item findItemById(@RequestParam(name="id") Long id,
                             @RequestParam(name="quantity") Integer quantity){
        return itemService.findById(id,quantity);
    }
}
