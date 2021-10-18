package de2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Question2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 24, 14, 8, 2, 58);
        List<Integer> sortedList = list.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        sortedList.forEach(System.out::println);
    }
}
