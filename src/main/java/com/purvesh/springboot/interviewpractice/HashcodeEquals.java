package com.purvesh.springboot.interviewpractice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * https://stackoverflow.com/questions/2265503/why-do-i-need-to-override-the-equals-and-hashcode-methods-in-java?page=1&tab=votes#tab-top
 * Override only equals
 * <p>
 * If only equals is overriden, then when you call myMap.put(first,someValue) first will hash to some bucket and
 * when you call myMap.put(second,someOtherValue) it will hash to some other bucket (as they have a different hashCode).
 * So, although they are equal, as they don't hash to the same bucket, the map can't realize it and both of them stay in the map.
 * <p>
 * Although it is not necessary to override equals() if we override hashCode(), let's see what would happen in this particular
 * case where we know that two objects of MyClass are equal if their importantField is equal but we do not override equals().
 * <p>
 * <p>
 * Override only hashCode
 * <p>
 * If you only override hashCode then when you call myMap.put(first,someValue) it takes first, calculates its hashCode and stores it in a given bucket.
 * Then when you call myMap.put(second,someOtherValue) it should replace first with second as per the Map Documentation because they are equal
 * (according to the business requirement).
 * <p>
 * But the problem is that equals was not redefined, so when the map hashes second and iterates through the bucket
 * looking if there is an object k such that second.equals(k) is true it won't find any as second.equals(first) will be false.
 * <p>
 * Hope it was clear.
 * <p>
 * https://stackoverflow.com/questions/26674729/how-will-hashmap-key-behave-if-hash-code-is-overridden-such-that-it-returns-only
 * Q: How will Hashmap key behave if hash code is overridden such that it returns only a constant number?
 * Ans:
 * They will be placed in a linked list structure in the map, assuming you didn't override the equals method to always return true.
 * Different keys may have the same hashCode, but if all the keys have the same hashCode,
 * your HashMap would become a linked list, which defeats the purpose of using this structure in the first place.
 * You would lose any performance given by an hashmap, that can retrieve items from a collection in O(1) time for objects
 * with different hashes, which is what we want to achieve when using HashMaps.
 * <p>
 * https://stackoverflow.com/questions/1894377/understanding-the-workings-of-equals-and-hashcode-in-a-hashmap
 */
public class HashcodeEquals {

    public static void main(String[] args) {
        testHashcodeEquals();
    }

    private static void testHashcodeEquals() {
        //same objects
        Person p1 = new Person(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0);
        Person p2 = new Person(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0);
        Person p3 = new Person(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0);
        Person p4 = new Person(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0);
        if (p1 == p2)
            System.out.println(true);
        else
            System.out.println(false);
        if (p1.equals(p2))
            System.out.println(true);
        else
            System.out.println(false);

        Map<Person, String> map = new HashMap<>();
        map.put(p1, "Purvesh" + p1.hashCode());
        map.put(p2, "Purvesh2" + p2.hashCode());
        map.put(p3, "Purvesh3" + p3.hashCode());
        map.put(p4, "Purvesh4" + p4.hashCode());

        System.out.println("map = " + map);
        System.out.println("map.get(e1) = " + map.get(p1));
        System.out.println("map.get(e2) = " + map.get(p2));
        System.out.println("map.get(e3) = " + map.get(p3));
        System.out.println("map.get(e4) = " + map.get(p4));
    }
}

@ToString
@Builder
@AllArgsConstructor
class Person {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }*/

    @Override
    public int hashCode() {
        return 1; //Objects.hash(id, name, age, gender, department, yearOfJoining, salary);
    }

    /*@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((name == null) ? 0 : name.hashCode());
        return result;
    }*/
}
