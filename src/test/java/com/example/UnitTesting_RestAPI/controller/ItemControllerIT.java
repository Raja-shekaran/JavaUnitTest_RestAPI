package com.example.UnitTesting_RestAPI.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.springframework.boot.test.context.SpringBootTest.*;

//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String response = this.restTemplate.getForObject("/api/v1/all-items", String.class);
//        System.out.println(response);
        JSONAssert.assertEquals("[{\"name\":\"Item1\"},{\"name\":\"Item2\"},{\"name\":\"Item3\"},{\"name\":\"Item4\"}]",response,false);
    }
}
