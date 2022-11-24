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
      int first = list.get(0);
      int middle = list.get(1);
      int last = list.get(2);
      List<Integer> lessers = new ArrayList<>();
      List<Integer> greaters = new ArrayList<>();
      if (first < middle) {
        lessers.add(first);
      }
      if (last < middle) {
        lessers.add(last);
      }

      if (last > middle) {
        greaters.add(last);
      }
      List<Integer> result = new ArrayList<>();
      result.addAll(lessers);
      result.add(middle);
      result.addAll(greaters);
      return result;
    }
  }
}
