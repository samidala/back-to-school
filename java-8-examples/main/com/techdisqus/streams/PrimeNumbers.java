package com.techdisqus.streams;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeNumbers {

	public static List<Integer> generate(int series) {
        Set<Integer> set = new TreeSet<>();
        return Stream.iterate(1, i -> ++i)
                .filter(i -> i %2 != 0)
                .filter(i -> {
                	System.out.println(i);
                    set.add(i);
                    return 0 == set.stream()
                            .filter(p -> p != 1)
                            .filter(p -> !Objects.equals(p, i))
                            .filter(p -> i % p == 0)
                            .count();
                })
                .limit(series)
                .collect(Collectors.toList());
    }

	public static void main(String[] args) {
		System.out.println(generate(10));
	}
}
