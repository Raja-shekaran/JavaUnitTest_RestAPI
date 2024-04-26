package com.example.UnitTesting_RestAPI.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {
    @Test
    public void learning()
    {
        List<Integer> list = Arrays.asList(12,15,45);

        assertThat(list).hasSize(3).contains(12,15).allMatch(x -> x > 10);
    }
}
