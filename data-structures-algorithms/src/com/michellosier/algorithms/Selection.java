package com.michellosier.algorithms;

import java.util.Scanner;

//Find smallest smallest item in array and exchange with first entry, then next
//O(n^2) compares and N exchanges
//Doesn't take advantage of initial order. Set could already be in order and still you have to iterate through each item
//Swaping is minimal linear to array size
public class Selection{
   public static void sort(Comparable[] items) {
        int n = items.length;
        for (int i = 0; i < n; i++){ //iterate through each item
            int min = i; //set index of current smallest value
            for (int j = i+1; j < n; j++){ //compare all array items against current minimal value
                if(less(items[j], items[min])){ //if item is less than current minimum
                    min = j; //set as minimum
                }
            }
            swap(items, i, min); //swap minimal value to current index
        }
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
    private static void show(Comparable[] items) {
        for (Comparable item : items)  {
            System.out.println(item + " ");
        }
    }

    // Test whether the array entries are in order.
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {  // Read strings from standard input, sort them, and print.
        Scanner input = new Scanner(System.in);
        String[] a = input.nextLine().split(",");
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

