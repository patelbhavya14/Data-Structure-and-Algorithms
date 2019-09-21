package inter;

public interface CustomStackInterface {
    public boolean push(String i);
    public String pop() throws Exception;
    public String peek() throws Exception;
    public int size();
    public boolean isEmpty();
}
