package com.github.aman;

import java.lang.reflect.Array;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class ExceptionHandeling {
    public static void main(String[] args) {

        int a[] = {1, 2, 3, 4};
        int k = 0;
        divide(a, k, wrapperLambda((value, key) -> System.out.println(value / key)));
    }

    private static void divide(int[] a, int k, BiConsumer<Integer, Integer> c) {
        for (int i : a) {
            c.accept(i, k);
        }

    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            } catch (ArithmeticException e) {
                System.out.println(e);
            }
        };
    }
}

