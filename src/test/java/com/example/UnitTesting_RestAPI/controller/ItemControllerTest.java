package com.example.UnitTesting_RestAPI.controller;

import com.example.UnitTesting_RestAPI.model.Item;
import com.example.UnitTesting_RestAPI.service.ItemBusinessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void getItem_basic() throws Exception
    {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/dummy-item").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

        //JSONAssert.assertEquals(expected,content,strict)
    }

    @Test
    public void getRealItem_basic() throws Exception
    {
        when(itemBusinessService.retrieveItems()).thenReturn(
                new Item(2,"Bat",10,10)
        );

        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/real-item").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"Bat\",\"price\":10,\"quantity\":10}"))
                .andReturn();
    }

    @Test
    public void retrieveAllItems_basic() throws Exception
    {
        when(itemBusinessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(3, "Ball", 20, 10), new Item(4, "Book", 30, 10))
        );

        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/all-items").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"name\":\"Ball\",\"price\":20,\"quantity\":10,\"value\":0},{}]"))
                .andReturn();
    }

    @Test
    public void retrieveSpecificItem_basic() throws Exception
    {
        when(itemBusinessService.retrieveSpecificItem(1001)).thenReturn(new Item(1001, "Item1", 10, 20));

        RequestBuilder request = MockMvcRequestBuilders.get("/api/v1/get-item/1001").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\":\"Item1\",\"price\":10,\"quantity\":20}"))
                .andReturn();
    }
}