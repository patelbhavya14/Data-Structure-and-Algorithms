package datastructures;

import inter.CustomStackInterface;

public class CustomLinkedStack implements CustomStackInterface {
    class Node {
        String val;
        Node next;

        public Node(String i) {
            val = i;
        }
    }

    Node head = null;
    int size = 0;

    @Override
    public boolean push(String i) {
        Node n = new Node(i);
        n.next = head;
        head = n;
        size++;
        return true;
    }

    @Override
    public String pop() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }

        String temp = head.val;
        head = head.next;
        size--;
        return temp;
    }

    @Override
    public String peek() throws Exception {
        if(isEmpty()) {
            throw new Exception();
        }

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
}
