package com.example.UnitTesting_RestAPI.service;

import com.example.UnitTesting_RestAPI.model.Item;
import com.example.UnitTesting_RestAPI.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    void getAllItems() {
        when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(3, "Ball", 20, 10), new Item(4, "Book", 30, 10)));

        List<Item> items = itemBusinessService.retrieveAllItems();

        assertEquals(200,items.get(0).getValue());
        assertEquals(300,items.get(1).getValue());
    }

    @Test
    void getItemById() {
        when(itemRepository.findById(1001)).thenReturn(Optional.of(new Item(1001, "Item1", 10, 20)));

        Item item = itemBusinessService.retrieveSpecificItem(1001);

        assertEquals("Item1",item.getName());
    }

}