package com.purvesh.springboot.interviewpractice;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Question: Given a setof integers, task is to put all 1s then 0s and then 2s
 * <p>
 * List can only contain 0,1,2
 * Size of list <=100
 * <p>
 * Given Input List A = {0,1,2,2,1,0}
 * Answer is   1,1,0,0,2,2
 */
public class InterviewPractice2 {

    private static Predicate<List<Integer>> verifyList() {
        List<Integer> validNumbers = Arrays.asList(0, 1, 2);
        return integers -> integers.stream().allMatch(integer -> validNumbers.contains(integer));
    }

    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(0, 1, 2, 2, 1, 0);
        if (!verifyList().test(inputList)) {
            return;
        }
        //Collections.sort(inputList); this gives natural order which is wrong.
        List<Integer> resultList = unnaturalOrder().apply(inputList);

        System.out.println("resultList = " + resultList);

    }

    private static UnaryOperator<List<Integer>> unnaturalOrder() {
        return integers -> {
            List<Integer> zeros = integers.stream().filter(integer -> integer == 0).collect(Collectors.toList());
            List<Integer> ones = integers.stream().filter(integer -> integer == 1).collect(Collectors.toList());
            List<Integer> twos = integers.stream().filter(integer -> integer == 2).collect(Collectors.toList());

            System.out.println("Stream.of(zeros, ones, twos).flatMap(x -> x.stream()).collect(Collectors.toList()) = " + Stream.of(zeros, ones, twos).flatMap(Collection::stream).collect(Collectors.toList()));
            return Stream.of(ones, zeros, twos).flatMap(x -> x.stream()).collect(Collectors.toList());
        };
    }
}
