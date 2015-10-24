package com.sk.linkedLists;

/**
 * Created by suppalamethi on 10/18/2015.
 */
public class DoubleLinkedListCentinalNode {

    private Node head;
    private Node tail;
    private int size = 0;

    public DoubleLinkedListCentinalNode() {
        this.head = this.tail = new Node(null, null, null);
        this.size = 0;
    }

    /**
     * Add an element to the last of the list
     *
     * @param data
     */
    public Node addLast(int data) {

        Node newNode = new Node(data, null, null);

        if (isEmpty()) { // No elements, head and tail at same location
            tail = newNode;
            head.next = newNode;
            tail.prev = head;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return newNode;
    }

    public Node add(Integer data, int position) {

        if (position < 0) {
            System.out.println("Out of bounds");
            return null;
        }
        if (position >= size) {
            return addLast(data);
        }

        Node tmp = head;
        int index = 0;

        Node newNode = new Node(data, null, null);

        while (tmp != tail) {
            if (index == position) {
                newNode.prev = tmp;
                newNode.next = tmp.next;
                tmp.next = newNode;
                size++;
            }
            tmp = tmp.next;
            index++;
        }
        return newNode;
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
                    tmp.next.next.prev = tmp;
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

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // remove first node
    public boolean removeFirst() {
        if (!isEmpty()) {
            if (head.next.next != null) {
                head.next = head.next.next;
            } else {
                head.next = null;
            }
            size--;
            return true;
        }
        return false;
    }

    // Remove node
    public boolean remove(Node node) {
        if (!isEmpty()) {
            node.prev.next = node.next;
            size--;
            return true;
        }
        return false;
    }

    public int get(int position) {
        Node tmp = head;
        int index = 0;
        while (tmp != tail) {
            if (index == position) {
                return tmp.next.data;
            }
            tmp = tmp.next;
            index++;
        }
        return 0;
    }


    public String toString() {
        StringBuilder listData = new StringBuilder();
        if (size != 0) {
            for (Node tmp = head.next; tmp != tail.next; tmp = tmp.next) {
                listData.append(tmp.data + ",");
            }
            listData.deleteCharAt(listData.length() - 1);
        } else {
            listData.append("List is empty");
        }
        return listData.toString();
    }


    protected class Node {
        private Node next;
        private Node prev;
        private Integer data;

        public Node(Integer data, Node prev, Node next) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
