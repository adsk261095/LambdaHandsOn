package com.github.aman;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class LambdaExercise {
    public static void printList(List<Person>people){
        for(Person p: people){
            System.out.println(p);
        }
    }

    public static List<Person> filter(List<Person> people, Condition c){
        List<Person> p = new ArrayList<Person>();
        for (Person i: people){
            if(c.test(i)){
                p.add(i);
            }
        }
        return p;
    }
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Aman", "singh", 24),
                new Person("Mom", "singh", 48),
                new Person("Papa", "singh", 51),
                new Person("Amol", "singh", 18)
        );

        Collections.sort(people, (p1,p2) -> p1.getFirstname().compareTo(p2.getFirstname()));

        printList(people);


        //filter names beginning with 'A'
        List<Person> p = filter(people, (p1)->p1.getFirstname().startsWith("A"));
        printList(p);

        printList(filter(people, (p1) -> true));
    }
}

interface Condition{
    boolean test(Person p);
}