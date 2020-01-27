package com.github.aman;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class javaStreams {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Aman", "singh", 24),
                new Person("Mom", "singh", 48),
                new Person("Papa", "singh", 51),
                new Person("Amol", "singh", 18)
        );

        //it takes consumer functional interface
        //is run in parallel on different threads
        people.forEach((p)->System.out.println(p));

        //using annonomous functions
//        people.forEach(new Consumer<Person>() {
//            @Override
//            public void accept(Person person) {
//                System.out.println(person);
//            }
//        });


        people.stream().forEach(p->System.out.println(p.getFirstname()));

        people.stream()
        .filter(p->p.getFirstname().startsWith("A"))
        .forEach(p->System.out.println(p));

        long count = people.stream()
        .filter(p->p.getFirstname().startsWith("A"))
        .count();

        System.out.println(count);

        List<Person> filterPersons = people.stream()
        .filter(p->p.getFirstname().startsWith("M"))
        .collect(Collectors.toList());

        filterPersons.forEach(x->System.out.println(x));

        /*
        using parallelstream the collections is divided
        into portions where each portion is executed on a different thread
         */
        people.parallelStream()
        .map(p->p.getFirstname() + "deep")
        .forEach((x)->System.out.println(x));


    }
}
