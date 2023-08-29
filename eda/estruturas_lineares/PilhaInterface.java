package estruturas_lineares;
public interface PilhaInterface {
    
    public void push(int n) throws StackOverflowError; 

    public int pop();

    public int peek();

    public boolean isEmpty();

    public boolean isFull();
}
