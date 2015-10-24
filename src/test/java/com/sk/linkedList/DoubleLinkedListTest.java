package com.sk.linkedList;

import com.sk.linkedLists.DoubleLinkedList;
import org.junit.Test;

/**
 * Created by suppalamethi on 10/18/2015.
 */
public class DoubleLinkedListTest {

    @Test
    public void testDoubleLinkedList() {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList();

        doubleLinkedList.addLast(100);
        DoubleLinkedList.Node node20 = doubleLinkedList.addLast(20);
        DoubleLinkedList.Node node40 = doubleLinkedList.addLast(40);

        DoubleLinkedList.Node node10 = doubleLinkedList.addLast(10);
        System.out.println("DLL::" + doubleLinkedList.toString());
        System.out.println("Size::" + doubleLinkedList.size());

        DoubleLinkedList.Node node16 = doubleLinkedList.add(16, 3);
        System.out.println("DLL after adding 16 at position 3::" + doubleLinkedList.toString());
        System.out.println("Size::" + doubleLinkedList.size());

        doubleLinkedList.removeFirst();
        System.out.println("DLL after removing first node - ::" + doubleLinkedList.toString());
        System.out.println("Size::" + doubleLinkedList.size());


        doubleLinkedList.remove(node40);
        System.out.println("DLL after removing node - " + node40.toString() + "::" + doubleLinkedList.toString());
        System.out.println("Size::" + doubleLinkedList.size());

        doubleLinkedList.remove(node20);
        System.out.println("DLL after removing node - " + node20.toString() + "::" + doubleLinkedList.toString());
        System.out.println("Size::" + doubleLinkedList.size());

        doubleLinkedList.remove(node16);
        System.out.println("DLL after removing node - " + node16.toString() + "::" + doubleLinkedList.toString());
        System.out.println("Size::" + doubleLinkedList.size());

        doubleLinkedList.remove(node10);
        System.out.println("DLL after removing node - " + node10.toString() + "::" + doubleLinkedList.toString());
        System.out.println("Size::" + doubleLinkedList.size());
    }
}
