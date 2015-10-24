package com.sk.linkedList;

import com.sk.linkedLists.UsingCentinalNode;
import org.junit.Test;

/**
 * Created by suppalamethi on 10/16/2015.
 */
public class CentinalSingleLinkedListTest {

    @Test
    public void testCentinalLinkedList() {

        UsingCentinalNode usingCentinalNode = new UsingCentinalNode();

        usingCentinalNode.add(20);
        usingCentinalNode.add(45);
        usingCentinalNode.add(25);
        usingCentinalNode.add(35);

        System.out.println(usingCentinalNode.add(65, 2));

        System.out.println(usingCentinalNode.toString());

        System.out.println(usingCentinalNode.remove(0));
        System.out.println(usingCentinalNode.toString());
    }

    /*List<Integer> myList = new ArrayList();

    myList.add(12);
    myList.add(20);
    myList.add(40);
    myList.add(50);
    myList.add(60);
    System.out.println(myList.toString());
    myList.add(3, 80);
    System.out.println(myList.toString());
    myList.remove(5);
    System.out.println(myList.toString());*/

}
