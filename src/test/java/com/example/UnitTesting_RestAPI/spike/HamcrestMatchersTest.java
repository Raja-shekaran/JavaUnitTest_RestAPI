package com.example.UnitTesting_RestAPI.spike;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {
    @Test
    public void learning()
    {
        List<Integer> list = Arrays.asList(12,15,45);
        assertThat(list, hasSize(3));
        assertThat(list, hasItems(12,45));
        assertThat(list, everyItem(greaterThan(10)));

        assertThat("",isEmptyString());
        assertThat("ABCDE",containsString("DE"));
    }
}
