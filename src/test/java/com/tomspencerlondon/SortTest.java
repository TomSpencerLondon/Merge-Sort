package com.tomspencerlondon;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SortTest {

  @Test
  void testSort() {
    assertThat(sort(List.of())).isSorted();
    assertThat(sort(List.of(1))).isSorted();
    assertThat(sort(List.of(1, 2))).isSorted();
    assertThat(sort(List.of(2, 1))).isSorted();

    assertThat(sort(List.of(1, 3, 2)))
        .isEqualTo(List.of(1, 2, 3));
    assertThat(sort(List.of(2, 1, 3)))
        .isEqualTo(List.of(1, 2, 3));
    assertThat(sort(List.of(2, 1, 3)))
        .isEqualTo(List.of(1, 2, 3));
    assertThat(sort(List.of(3, 2, 1)))
        .isEqualTo(List.of(1, 2, 3));
    assertThat(sort(List.of(1, 2, 3, 4)))
        .isEqualTo(List.of(1, 2, 3, 4));
    assertThat(sort(List.of(2, 1, 3, 4)))
        .isEqualTo(List.of(1, 2, 3, 4));
    assertThat(sort(List.of(4, 3, 2, 1)))
        .isEqualTo(List.of(1, 2, 3, 4));
  }

  private List<Integer> sort(List<Integer> list) {
    if (list.size() <= 1) {
      return list;
    } else if (list.size() == 2) {
      int first = list.get(0);
      int second = list.get(1);
      if (first > second) {
        return List.of(second, first);
      } else {
        return List.of(first, second);
      }
    } else {
      int middle = list.get(0);
      List<Integer> lessers = list.stream().filter(x -> x < middle).toList();
      List<Integer> greaters = list.stream().filter(x -> x > middle).toList();

      List<Integer> result = new ArrayList<>();
      result.addAll(sort(lessers));
      result.add(middle);
      result.addAll(sort(greaters));
      return result;
    }
  }
}
