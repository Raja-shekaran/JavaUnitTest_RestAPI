package com.example.UnitTesting_RestAPI.repository;

import com.example.UnitTesting_RestAPI.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
