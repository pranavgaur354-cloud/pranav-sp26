import java.util.LinkedList;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private T[] contents;
    private int size;
    private int start;
    private int end;
    private T[] sentinel = (T[]) new Object[8];

    public ArrayDeque61B() {
        contents = sentinel;
        start = ((contents.length) / 2) - 1;
        end = (contents.length) / 2;
        size = 0;

    }

    //In a circular array ,For start to be circular upon every increment : start= (start -1 +sentinel.size())%sentinel.size()
//In a circular array ,For start to be circular upon every increment : end= (end +1 )%sentinel.size()
    @Override
    public void addFirst(T x) {
//        when array is full
        if (start == end) {
            resizeUp();
        }

        contents[start] = x;
        start = (start - 1 + contents.length) % contents.length;
        size = size + 1;

    }

    @Override
    public void addLast(T x) {
//        when array is full
        if (start == end) {
            resizeUp();
        }
        contents[end] = x;
        end = (end + 1) % contents.length;
        size = size + 1;
    }

    @Override
    public List<T> toList() {
        int Start_pointer = (start + 1) % contents.length;
        int End_pointer = end;
        List<T> a = new LinkedList<>();
        while (Start_pointer != End_pointer) {
            a.add(contents[Start_pointer]);
            Start_pointer = (Start_pointer + 1) % contents.length;
        }
        return a;
    }

    @Override
    public boolean isEmpty() {
        //start is right before end means no term has been filled
        return end == ((start + 1) % contents.length);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getFirst() {
        return contents[(start + 1) % contents.length];
    }

    @Override
    public T getLast() {
        return contents[((end - 1 + contents.length) % contents.length)];
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (size <= (contents.length) / 4 && contents.length>8) {
            resizeDown();
        }

        start = (start + 1) % contents.length;
        size=size-1;
        return contents[start];
    }

    @Override
    public T removeLast() {
        if (size==0) {
            return null;
        }
        if (size <= (contents.length) / 4 && contents.length>8) {
            resizeDown();
        }

        end = (end - 1 + contents.length) % contents.length;
        size=size-1;
        return contents[end];
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >=size) {

            return null;
        }
        return contents[(start + index + 1) % contents.length];
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >=size) {
            return null;
        }
        return getRecursion(index, 0);
    }

    private T getRecursion(int index, int current) {
        if (index == 0) {
            return (contents[(current + start + 1) % contents.length]);
        }
        return getRecursion(index - 1, current + 1);
    }

    private void resizeUp() {

        sentinel = (T[]) new Object[contents.length * 2];
        int newStart = ((sentinel.length - 1) / 4);
        int newEnd = newStart + size + 1;

        for (int i = 0; i < size; i++) {
            sentinel[i + newStart + 1] = contents[(start + 1 + i) % contents.length];
        }
        start = newStart;
        end = newEnd;
        contents = sentinel;


    }

    private void resizeDown() {

        sentinel = (T[]) new Object[contents.length / 2];
        int newStart = (sentinel.length - 1) / 4;
        int newEnd = newStart + size + 1;

        for (int i = 0; i < size; i++) {
            sentinel[i + newStart + 1] = contents[(start + 1 + i) % contents.length];
        }
        start = newStart;
        end = newEnd;
        contents = sentinel;
    }
}
