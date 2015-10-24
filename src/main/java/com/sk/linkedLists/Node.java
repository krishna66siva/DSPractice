package com.sk.linkedLists;

/**
 * Created by suppalamethi on 10/8/2015.
 */
public class Node {
    // Object representation of node
    int data;
    Node nextNode;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
    }

    /*@Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", nextNode=" + nextNode +
                '}';
    }*/

    @Override
    public String toString() {
        return "" + data;
    }
}
