package com.sk.linkedList;

import com.sk.linkedLists.MyLinkedList;
import org.junit.Test;

/**
 * Created by suppalamethi on 10/8/2015.
 */
public class LinkedListTest {

    @Test
    public void test() {
        MyLinkedList list = new MyLinkedList();

        list.add(15);
        list.add(16);
        list.add(10);
        list.add(8);
        list.traverse();

        System.out.println("Deleting 16");
        list.delete(16);
        list.traverse();
    }

}
