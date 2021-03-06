package com.github.aman;

public class Lambda {

    public static void main(String[] args) {

        /**
         * Lambda function
         */
        Greeting greeting = s->{
            System.out.println("String length is: " + s.length());
        };

        greeting.greet("aman");

        /**
         * Annonomous inner class
         */
        Greeting g = new Greeting() {
            @Override
            public void greet(String s) {
                System.out.println("string is: " + s);
            }
        };
        g.greet("amol");

        //calling the default method
        greeting.show();
        g.show();
    }

}

/**
 * Functional interface:
 * an interface with only one abstract method
 * is called functional interface
 * @FunctionalInterface annotation indicates the interface
 * is a functional interface, it is optional but recommended to use
 */
@FunctionalInterface
interface Greeting{
    void greet(String s);
    default void show(){
        System.out.println("shows my name");
    }
}