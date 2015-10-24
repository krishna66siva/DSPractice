package com.sk.linkedLists;

/**
 * Created by suppalamethi on 10/8/2015.
 */
public class MyLinkedList {

    // head                                                             tail
    //
    // Establish structure of node - creating node class
    // Node(data) -> Node(data) -> Node(data) -> Node(data)
    // Add node
    // Delete Node
    // Find node

    // The linked list needs a head, so the head variable is created inside the linked list class not inside the node class
    Node head;
    Node tail;
    int size = 0;

    public void add(int data) {
        // Scenarios
        //1. Empty linked list
        // 2. non-empty linked list[ node(15) -> node(16) - tail]
        // which means the old tail points to new node, update tail to new node
        // Add node(10) to the list, new list : [node(15) -> node(16) -> node(10)]
        Node node = new Node(data);
        if (tail == null) { // head is also null
            head = node;
            tail = node;
        } else {
            tail.nextNode = node;
            tail = node;
        }
        size++;
    }

    public Node delete(int data) {
        // Scenarios
        //1. Empty linked list
        // 2. non-empty linked list
        // 3. delete element at tail
        // 4. delete element at head
        //5. delete element in middle of list
        // to delete node(10) in this list - [node(15) -> node(16) -> node(10)],
        // we have to find node 10

        Node nodeToReturn = null;

        if (size == 0) {
            return null;
        }
        if (size == 1) {
            nodeToReturn = head;
            head = null;
            tail = null;
            return nodeToReturn;
        }
        Node nodeBeforeNodeToDelete = findNodeBefore(data);
        // Case of deleting head
        if (nodeBeforeNodeToDelete.data == 0) {
            head = head.nextNode;
            size--;
        } else if (nodeBeforeNodeToDelete != null) {

            if (tail.data == data) {
                nodeBeforeNodeToDelete.nextNode = null;
                tail = nodeBeforeNodeToDelete;
            } else {
                // nodeBeforeNodeToDelete.nextNode = find(data).nextNode; or
                nodeBeforeNodeToDelete.nextNode = nodeBeforeNodeToDelete.nextNode.nextNode;
            }
            size--;
        }

        return null;
    }

    /**
     * If this method returns an empty node, it means that the element we want to delete is at the head of the linked list
     * returns null if there is no match
     * returns a populated node if it found a match
     *
     * @param data
     * @return
     */
    public Node findNodeBefore(int data) {

        // Check for the first element for a match
        if (head.data == data)
            return new Node();

        // Assign node as the iterator
        Node node = head;

        // Iterate through the linked list
        while (node.nextNode != null) {
            if (node.nextNode.data == data) {
                return node;
            }
            node = node.nextNode;
        }
        return null;
    }

    public Node find(int data) {
        // Scenarios
        //1. Empty linked list
        // 2. non-empty linked list[ node(15) -> node(16) - tail]

        if (head == null)
            return null;

        // Check for the first element for a match
        if (head.data == data)
            return head;

        // Assign node as the iterator
        Node node = head;
        while (node.nextNode != null) {
            if (node.data == data) {
                return node;
            }
            node = node.nextNode;
        }
        return null;
    }

    public void traverse() {
        if (head != null) {
            Node node = head;
            System.out.println(node);
            while (node.nextNode != null) {
                node = node.nextNode;
                System.out.println(node);
            }
        }
    }


}
