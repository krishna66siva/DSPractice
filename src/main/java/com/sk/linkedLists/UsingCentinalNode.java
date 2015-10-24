package com.sk.linkedLists;

/**
 * Created by suppalamethi on 10/9/2015.
 */
public class UsingCentinalNode<T> {

    int size = 0;
    private Node<T> head;
    private Node<T> tail;

    public UsingCentinalNode() {
        this.head = new Node(null, null);
        this.tail = this.head;
    }

    public int add(T data, int position) {
        Node tmp = head;
        int index = 0;

        while (tmp != tail) {
            if (index == position) {
                tmp.next = new Node(data, tmp.next);
                size++;
                return index;
            }
            index++;
            tmp = tmp.next;
        }
        tail = tmp.next = new Node(data, null);
        size++;
        return index;
    }

    /**
     * Add an element to the end of the list
     *
     * @param data
     * @return
     */
    public int add(T data) {
        Node<T> tmp = head;
        int index = 0;

        while (tmp != tail) {
            tmp = tmp.next;
            ++index;
        }
        tail = new Node(data, null);
        tmp.next = tail;

        ++size;

        return index;
    }

    public boolean remove(int position) {

        if (position < 0 || position >= size) {
            System.out.println("Out of bounds");
            return false;
        }

        Node tmp = head;
        int index = 0;

        while (tmp != tail) {
            if (index == position) {
                if (tmp.next.next == null) {
                    tmp.next = null;
                } else {
                    tmp.next = tmp.next.next;
                }
                size--;
                return true;
            }
            tmp = tmp.next;
            index++;
        }
        return false;
    }

    public String toString() {
        StringBuilder dataString = new StringBuilder();
        if (size != 0) {
            for (Node tmp = head.next; tmp != tail.next; tmp = tmp.next) {
                dataString.append(tmp.data + " ");
            }
            dataString.append(" \nSize:" + size);

        } else {
            dataString.append("No Elements in the list");
        }
        return dataString.toString();
    }

    private class Node<T> {
        private Node<T> next;
        private T data;

        public Node(T data, Node<T> next) {
            this.next = next;
            this.data = data;
        }
    }


}
