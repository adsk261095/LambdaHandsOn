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
    }

}

/**
 * Functional interface
 */
interface Greeting{
    void greet(String s);
}