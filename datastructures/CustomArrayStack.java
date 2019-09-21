package datastructures;

import inter.CustomStackInterface;

public class CustomArrayStack implements CustomStackInterface {
    String arr[];
    int head = -1;

    public CustomArrayStack() {
        arr = new String[10];
    }

    public CustomArrayStack(int size) {
        arr = new String[size];
    }

    @Override
    public boolean push(String i) {
        head++;

        if (head == arr.length) {
            head--;
            return false;
        }

        arr[head] = i;
        return true;
    }

    @Override
    public String pop() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }

        return arr[head--]; // first return element at index head and then decrement head
    }

    @Override
    public String peek() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return arr[head];
    }

    @Override
    public int size() {
        return head+1;
    }

    @Override
    public boolean isEmpty() {
        return head == -1;
    }

}
