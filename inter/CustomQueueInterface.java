package inter;

public interface CustomQueueInterface {
    public boolean enqueue(int i);
    public int dequeue() throws Exception;
    public int peek();
    public int size();
    public boolean isEmpty();
    public void printQueue();
}
