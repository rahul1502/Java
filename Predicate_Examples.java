package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Predicate_Examples {

    public static void main(String[] args) {

        // test()
        Predicate<Integer> predicateEqual = x -> (x == 10);

        System.out.println(predicateEqual.test(12));

        // isEqual()
        Predicate<String> predicateIsEqual = Predicate.isEqual("HI_THERE");

        System.out.println(predicateIsEqual.test("HI_THERE"));

        // and()
        Predicate<Integer> grt = x -> (x > 10);
        Predicate<Integer> less = x -> (x < 20);

        System.out.println(grt.and(less).test(15));

        // or()

        System.out.println(grt.or(less).test(50));

        // negate
        Predicate<Integer> predicateNegate = x -> (x == 50);

        System.out.println(predicateNegate.negate().test(50));

        // Predicate as a stream filter (print even numbers)
        Predicate<Integer> checkEven = (x -> x % 2 == 0);

        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(checkEven)
                .forEach(System.out::println);

        // Predicate as an argument to a method
        List<String> list = Arrays.asList("A", "AA", "B", "BB", "CC", "C");

        System.out.println(filterList(list, x -> x.startsWith("B")));

        System.out.println(filterList(list, x -> x.startsWith("B") && x.length() == 2));

    }

    static List<String> filterList(List<String> list, Predicate<String> predicate) {
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

}
