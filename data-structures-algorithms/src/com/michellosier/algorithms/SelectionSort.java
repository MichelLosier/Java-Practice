package com.michellosier.algorithms;

import java.util.Scanner;

public class SelectionSort {
    public static void sort(Comparable[] a) {

    }

    private static boolean  less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] set, int i, int j) {
        Comparable temp = set[i];
        set[i] = set[j];
        set[j] = temp;
    }

    // Print the array, on a single line.
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
    }

    // Test whether the array entries are in order.
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args)
    {  // Read strings from standard input, sort them, and print.
        Scanner input = new Scanner(System.in);
        String[] a = input.nextLine().split(" ");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

