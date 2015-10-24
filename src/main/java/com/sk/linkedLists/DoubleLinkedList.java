package com.sk.linkedLists;

/**
 * Created by suppalamethi on 10/23/2015.
 */
public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public DoubleLinkedList() {
        this.head = this.tail = new Node<T>(null, null, null);
        this.size = 0;
    }

    /**
     * Add an element to the last of the list
     *
     * @param data
     */
    public Node addLast(T data) {

        Node<T> newNode = new Node<T>(data, null, null);

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

    public Node<T> add(T data, int position) {

        if (position < 0) {
            System.out.println("Out of bounds");
            return null;
        }
        if (position >= size) {
            return addLast(data);
        }

        Node<T> tmp = head;
        int index = 0;

        Node<T> newNode = new Node<T>(data, null, null);

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

        Node<T> tmp = head;
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


    /**
     * remove first node
     *
     * @return the removed Node
     */
    public Node<T> removeFirst() {
        if (!isEmpty()) {
            Node<T> tmp = head.next;
            if (head.next.next != null) {
                head.next = head.next.next;
            } else {
                head.next = null;
            }
            size--;
            return tmp;
        }
        return null;
    }

    // Remove node
    public boolean remove(Node<T> node) {
        if (!isEmpty()) {
            node.prev.next = node.next;
            size--;
            return true;
        }
        return false;
    }

    public T get(int position) {
        Node<T> tmp = head;
        int index = 0;
        while (tmp != tail) {
            if (index == position) {
                return tmp.next.data;
            }
            tmp = tmp.next;
            index++;
        }
        return null;
    }


    public String toString() {
        StringBuilder listData = new StringBuilder();
        if (size != 0) {
            for (Node<T> tmp = head.next; tmp != tail.next; tmp = tmp.next) {
                listData.append(tmp.data + ",");
            }
            listData.deleteCharAt(listData.length() - 1);
        } else {
            listData.append("List is empty");
        }
        return listData.toString();
    }


    public class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T data;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }

        @Override
        public String toString() {
            return "{" + data.toString() +
                    "}";
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
