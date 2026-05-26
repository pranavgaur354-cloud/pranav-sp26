import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private T[] contents;
    private int size;
    private int start;
    private int end;
    private T[] sentinel = (T[]) new Object[999];
    private int Array_length;

    public ArrayDeque61B() {
        contents = sentinel;
        start = ((contents.length) / 2) - 1;
        end = (contents.length) / 2;
        size = 0;
        Array_length = contents.length;
    }

    //In a circular array ,For start to be circular upon every increment : start= (start -1 +sentinel.size())%sentinel.size()
//In a circular array ,For start to be circular upon every increment : end= (end +1 )%sentinel.size()
    @Override
    public void addFirst(T x) {
//        when array is full
        if (start != end) {
            resize();
        }

        contents[start] = x;
        start = (start - 1 + Array_length) % Array_length;
        size = size + 1;

    }

    @Override
    public void addLast(T x) {
//        when array is full
        if (start != end) {
            resize();
        }
        contents[end] = x;
        end = (end + 1) % Array_length;
        size = size + 1;
    }

    @Override
    public List<T> toList() {
        int Start_pointer = (start + 1) % Array_length;
        int End_pointer = end;
        List<T> a = new ArrayList<>();
        while (Start_pointer != End_pointer) {
            a.add(contents[Start_pointer]);
            Start_pointer = (Start_pointer + 1) % Array_length;
        }
        return a;
    }

    @Override
    public boolean isEmpty() {
        if (((start + 1) % Array_length) == end) {//start is right before end means no term has been filled
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getFirst() {
        return contents[(start + 1) % Array_length];
    }

    @Override
    public T getLast() {
        return contents[((end - 1 + Array_length) % Array_length)];
    }

    @Override
    public T removeFirst() {
        start = (start + 1) % Array_length;
        return contents[start];
    }

    @Override
    public T removeLast() {
        end = (end - 1 + Array_length) % Array_length;
        size--;
        return contents[end];
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            size--;
            return null;
        }
        return contents[(start + index + 1) % Array_length];
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return getRecursion(index, 0);
    }

    private T getRecursion(int index, int current) {
        if (index == 0) {
            return (contents[(current + start + 1) % Array_length]);
        }
        return getRecursion(index - 1, current + 1);
    }

    private void resize() {

        sentinel = (T[]) new Object[Array_length * 2];
        int newStart = (sentinel.length - 1) / 2;
        int newEnd = newStart + Array_length + 2;

        for (int i = 0; i < size; i++) {
            sentinel[i + newStart + 1] = contents[(start + 1 + i) % Array_length];
        }
        start = newStart;
        end = newEnd;
        contents = sentinel;
    }
}
