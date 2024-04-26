package com.example.UnitTesting_RestAPI.service;

import com.example.UnitTesting_RestAPI.model.Item;
import com.example.UnitTesting_RestAPI.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retrieveItems(){
        return new Item(1,"Ball", 10, 100);
    }

    public List<Item> retrieveAllItems(){
        List<Item> items = itemRepository.findAll();
        for(Item item : items){
            item.setValue(item.getPrice()* item.getQuantity());
        }
        return items;
    }

    public Item retrieveSpecificItem(int id) {
        return itemRepository.findById(id).orElse(null);
    }
}
