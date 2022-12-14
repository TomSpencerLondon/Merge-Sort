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

    assertThat(sort(List.of(1, 3, 2))).isEqualTo(List.of(1, 2, 3));
    assertThat(sort(List.of(2, 1, 3))).isEqualTo(List.of(1, 2, 3));
    assertThat(sort(List.of(2, 1, 3))).isEqualTo(List.of(1, 2, 3));
    assertThat(sort(List.of(3, 2, 1))).isEqualTo(List.of(1, 2, 3));
    assertThat(sort(List.of(1, 2, 3, 4))).isEqualTo(List.of(1, 2, 3, 4));
    assertThat(sort(List.of(2, 1, 3, 4))).isEqualTo(List.of(1, 2, 3, 4));
    assertThat(sort(List.of(4, 3, 2, 1))).isEqualTo(List.of(1, 2, 3, 4));
    assertThat(sort(List.of(1, 3, 1, 2))).isEqualTo(List.of(1, 1, 2, 3));
    assertThat(sort(List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9, 3)))
        .isEqualTo(List.of(1, 1, 2, 3, 3, 3, 4, 5, 5, 5, 6, 7, 8, 9, 9, 9));
  }

  private List<Integer> sort(List<Integer> list) {
    List<Integer> result = new ArrayList<>();
    if (list.size() == 0) {
      return result;
    }
    int middle = list.get(0);
    List<Integer> middles = list.stream().filter(x -> x == middle).toList();
    List<Integer> lessers = list.stream().filter(x -> x < middle).toList();
    List<Integer> greaters = list.stream().filter(x -> x > middle).toList();

    result.addAll(sort(lessers));
    result.addAll(middles);
    result.addAll(sort(greaters));
    return result;
  }
}
