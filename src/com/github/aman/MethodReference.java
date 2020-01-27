package com.github.aman;

import java.util.Scanner;

public class MethodReference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        /*
        Using lambda functions
         */
        Thread t = new Thread(()->printMessage(name));
        
        /*
        Using Method References: It can only be used if lambda doesn't
        take any argument and function which is being called doesn't takes any argument
         */

        Thread td = new Thread(MethodReference::printBlankMessage);
        
        /*
        Using annonomyus inner classes
         */
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                printMessage(name);
            }
        });

        t.start();
        th.start();
        td.start();
    }

    private static void printBlankMessage() {
        System.out.println("this is called form method reference");
    }

    private static void printMessage(String name) {
        System.out.println("Hi My name is: " + name);
    }

}

//interface forLambda{
//    public void printing();
//}
