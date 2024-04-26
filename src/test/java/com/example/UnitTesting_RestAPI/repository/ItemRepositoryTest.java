package com.example.UnitTesting_RestAPI.repository;

import com.example.UnitTesting_RestAPI.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void findAll() {
        List<Item> items = itemRepository.findAll();
        assertEquals(4,items.size());
    }

    @Test
    void findById() {
        Optional<Item> item = itemRepository.findById(1001);
        System.out.println(item.get().getName());
        assertEquals("Item1",item.get().getName());
    }

}