package com.tomspencerlondon;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class SortTest {

  @Test
  void testSort() {
    assertThat(sort(asList())).isSorted();
    assertThat(sort(asList(1))).isSorted();
  }

  private List<Integer> sort(List<Integer> list) {
    return list;
  }
}
