package src.com.michellosier.algorithms;

import java.util.Scanner;

//iterate through each item and put among those already considered - persist sort
//like sorting a hand of cards
//movement to the right, left of index is sorted
//O(n^2 / 2)
//Good for sets that may already be partially sorted already
//Good for sorting streamed values
public class Insertion{
    public static void sort(Comparable[] items) {
        int n = items.length;
        for (int i = 1; i < n; i++){ //for each item
            //swap to each item to the left if current value is less than its left
            //stop iteration if current value is greater than left, or we reach left limit
            for (int j = i; j > 0 && less(items[j], items[j-1]); j--){
                swap(items, j, j-1);
            }
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