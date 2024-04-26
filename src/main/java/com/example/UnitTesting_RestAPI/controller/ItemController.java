package com.example.UnitTesting_RestAPI.controller;

import com.example.UnitTesting_RestAPI.model.Item;
import com.example.UnitTesting_RestAPI.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item getDummyItem()
    {
        return new Item(1,"Ball", 10, 100);
    }

    @GetMapping("/real-item")
    public Item getRealItem()
    {
        return businessService.retrieveItems();
    }

    @GetMapping("/all-items")
    public List<Item> getAllItems()
    {
        return businessService.retrieveAllItems();
    }

    @GetMapping("/get-item/{id}")
    public Item getSpecificItem(@PathVariable int id)
    {
        return businessService.retrieveSpecificItem(id);
    }

}
