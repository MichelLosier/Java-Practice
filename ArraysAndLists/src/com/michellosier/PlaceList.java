package com.michellosier;

import java.util.Iterator;
import java.util.LinkedList;

public class PlaceList {
    public static void main(String[] args){
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Amsterdam");
        placesToVisit.add("Cologne");
        placesToVisit.add("Bacharach");
        placesToVisit.add("Frankfurt");
        placesToVisit.add("Koblenz");
        placesToVisit.add("Oberwesel");

        printList(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList){
        Iterator<String> placeIterator = linkedList.iterator();
        while(placeIterator.hasNext()){
            System.out.println("Visiting " + placeIterator.next());
        }
    }
}
