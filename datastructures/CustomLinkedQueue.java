package datastructures;

import inter.CustomQueueInterface;

public class CustomLinkedQueue implements CustomQueueInterface {
    class Node {

        int val;
        Node next;

        Node(int i) {
            val = i;
        }
    }

    Node head = null;
    Node tail = null;
    int size;

    @Override
    public boolean enqueue(int i) {
        Node n = new Node(i);
        n.next = null;
        if(size() == 0) {
            head = n;
            tail = n;
            printQueue();
            size++;
            return true;
        }
//        TreeNode temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = n;
        tail.next = n;
        tail = n;
        size++;
        return true;
    }

    @Override
    public int dequeue() throws Exception {
        if (isEmpty()) {
            tail = null;
            throw new Exception("Queue is empty");
        }
        int item = head.val;
        head = head.next;
        size--;
        return item;
    }

    @Override
    public int peek() {
        return head.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void printQueue() {

    }
}
