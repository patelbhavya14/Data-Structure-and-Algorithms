package datastructures;

import inter.CustomQueueInterface;

public class CustomArrayQueue implements CustomQueueInterface {
    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    public CustomArrayQueue() {
        capacity = 10;
        front = size = 0;
        rear = capacity - 1;
        arr = new int[10];
    }

    public CustomArrayQueue(int s) {
        capacity = s;
        front = size = 0;
        rear = capacity - 1;
        arr = new int[s];
    }

    @Override
    public boolean enqueue(int i) {
        if(size == capacity){
            return false;
        }
        rear = (rear+1)%capacity;
        arr[rear] = i;
        size++;
        return true;
    }

    @Override
    public int dequeue() {
        int item = arr[front];
        front = (front+1)%capacity;
        size--;
        return item;
    }

    @Override
    public int peek() {
        return arr[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void printQueue() {

    }
}
