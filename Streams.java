package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {

        // Integer Stream
        IntStream
                .range(0, 10)
                .forEach(System.out::println);

        System.out.println("---------------------------");

        // Integer Stream with Skip
        IntStream
                .range(0, 10)
                .skip(5)
                .forEach(i -> System.out.println(i + " "));

        System.out.println("---------------------------");

        // Integer Stream with Sum
        int sum = IntStream
                .range(0, 10)
                .sum();
        System.out.println(sum);

        System.out.println("---------------------------");

        // Stream of Sorted and FindFirst
        Stream.of("Rahul", "Sam", "Alberto", "Ben", "David")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("---------------------------");

        // Stream from Array, sort, filter and print
        String[] names = {"Rahul", "Sam", "Alberto", "Ben", "David", "Gordon", "Alfred", "Gary", "Al"};
        Arrays.stream(names) // same as Stream.of(names)
                .filter(x -> x.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        System.out.println("---------------------------");

        // Avg of Squares of an int array
        Arrays.stream(new int[] {2, 5, 7, 8, 9, 4, 3, 5, 7, 8, 4, 7})
                .map(x -> x*x)
                .average()
                .ifPresent(System.out::println);

        // Stream from a list, filter items and print them
        List<String> people = Arrays.asList("Rahul", "Sam", "Alberto", "Ben", "David", "Gordon", "Alfred", "Gary", "Al");
        people.stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("d"))
                .forEach(System.out::println);

        System.out.println("---------------------------");

        // Stream from a list filter and save into another list
        List<String> list1 = Arrays.asList("Rahul", "Sam", "Alberto", "Ben", "David", "Gordon", "Alfred", "Gary", "Al", "Clifford");
        List<String> list2 = list1
                .stream()
                .filter(x -> x.contains("or"))
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(list2.toArray()));

        System.out.println("---------------------------");

        // Stream from a list filter and count invalid entries
        List<String> list3 = Arrays.asList("a,1,1", "o,3,6", "k,1,5", "g", "c,2,9", "l,6,9", "g,1,6", "h", "3");
        int count3 = (int) list3
                        .stream()
                        .map(x -> x.split(","))
                        .filter(x -> x.length == 3)
                        .count();
        System.out.println(count3);

        System.out.println("---------------------------");

        // Stream from a list, filter out bad elements and
        // parse a number and print the entries for which the number is greater than 5
        list3
                .stream()
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[2]) > 5)
                .forEach(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));

        System.out.println("---------------------------");

        // Stream from a list and store the entries in a HashMap
        Map<String, Integer> map1 = new HashMap<>();
        map1 = list3
                .stream()
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[2])
                ));
        for(String key: map1.keySet()) {
            System.out.println(key + " " + map1.get(key));
        }

        System.out.println("---------------------------");

        // Reduction - sum
        double total = Stream.of(6.7, 8.3, 7.3, 1.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println(total);

        System.out.println("---------------------------");

        // Reduction - summary statistics
        IntSummaryStatistics summaryStatistics = IntStream
                .of(4, 7, 8, 4, 2, 7, 3, 8, 3, 8)
                .summaryStatistics();
        System.out.println(summaryStatistics);

        System.out.println("---------------------------");

        // Parallel streams: using the parallel method print each String in the list.
        // note that in each execution the sequence will be different,
        Stream
                .of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15)
                .parallel()
                .forEach(System.out::println);

        System.out.println("---------------------------");

        // Parallel streams on Collections
        List<Integer> list4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        list4
                .parallelStream()
                .forEach(System.out::println);
    }
}
