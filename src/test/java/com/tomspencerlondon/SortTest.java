package com.tomspencerlondon;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class SortTest {

  @Test
  void testSort() {
    assertThat(sort(List.of())).isSorted();
    assertThat(sort(List.of(1))).isSorted();
    assertThat(sort(List.of(1, 2))).isSorted();
    assertThat(sort(List.of(2, 1))).isSorted();
  }

  private List<Integer> sort(List<Integer> list) {
    if (list.size() <= 1) {
      return list;
    } else {
      int first = list.get(0);
      int second = list.get(1);

      if (first > second) {
        return List.of(second, first);
      } else {
        return List.of(first, second);
      }
    }
  }
}
