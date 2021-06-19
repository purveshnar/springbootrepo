package com.purvesh.springboot.interviewpractice;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * One person hands over the list of digits to Mr. String, But Mr. String understands only strings. Within strings also he understands only vowels. Mr. String needs your help to find the total number of pairs which add up to a certain digit D.
 *
 * The rules to calculate digit D are as follows:
 *
 * Take all digits and convert them into their textual representation.
 * Next, sum up the number of vowels i.e. {a, e, i, o, u} from all textual representation. This sum is digit D.
 * Now, once digit D is known find out all unordered pairs of numbers in input whose sum is equal to D.
 * Problem Statement: Given an array arr[] consisting of N ( 1 ≤ N ≤ 100 ) integers, the task is to convert each array element ( 1 ≤ arr[i] ≤ 100 ) into their respective textual representations and print the lowercase representation of the count of all possible pairs from the array whose sum is equal to the total count of vowels present in their textual representation. If the count exceeds 100 print “greater 100”.
 * Note: For the number 100, convert it to textual representation as hundred and not as one hundred.
 *
 * Examples:
 *
 * Input: arr[] = {1, 2, 3, 4, 5}
 * Output: one
 * Explanation:
 * 1 -> one -> o, e (2 vowels)
 * 2 -> two -> o (1 vowel)
 * 3 -> three -> e, e (2 vowels)
 * 4 -> four -> o, u (2 vowels)
 * 5 -> five – > i, e (2 vowels)
 * The total count of vowels in their textual representations = {2 + 1 + 2 + 2 + 2} = 9.
 * Now from the given array, only a single unordered pair {4, 5} sums up to 9. Therefore, the count is 1. Hence, the required output is “one“.
 *
 *
 *
 * Input: arr[] = {7, 4, 2, }
 * Output: zero
 * Explanation:
 * 7 -> seven -> e, e (2 vowels)
 * 4 -> four -> o, u (2 vowels)
 * 2 -> two -> o (1 vowel)
 * The total count of vowels in their textual representation = {2 + 2 + 1} = 5.
 * Now from the given array, no pair exists which adds up to 5. Therefore, the answer is “zero“.
 */
public class InterviewPractice3 {

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

            System.out.println("Stream.of(zeros, ones, twos).flatMap(x -> x.stream()).collect(Collectors.toList()) = " +
                    Stream.of(zeros, ones, twos).flatMap(Collection::stream).collect(Collectors.toList()));
            return Stream.of(ones, zeros, twos).flatMap(x -> x.stream()).collect(Collectors.toList());
        };
    }
}
