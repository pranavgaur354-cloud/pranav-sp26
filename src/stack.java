import java.util.ArrayList;

public class stack<T> {
    private ArrayList<T> dataStructure;
    private int size = 0;


    public stack() {
        dataStructure = new ArrayList<>();
    }

    public T top() {
        if (size == 0) {
            return null;
        }
        return dataStructure.getLast();
    }
    public int size(){
        return size;
    }

    public void addItem(T i) {
        dataStructure.add(i);
        size++;
    }


    public T get() {
        if (size == 0) {
            return null;
        }
        T a = dataStructure.getLast();
        dataStructure.removeLast();
        size--;
        return a;
    }
}
