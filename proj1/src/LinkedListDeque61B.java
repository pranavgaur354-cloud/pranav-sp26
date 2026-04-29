
import java.util.List;
import java.util.ArrayList;


public class LinkedListDeque61B<T> implements Deque61B<T> {
    private Node<T> sentinel;
    private int size;


    public static class Node<T> {
        public Node prev;
        public T item;
        public Node next;

        public Node( T i, Node p, Node n){
            prev =p;
            next = n;
            item = i;
        }
    }


    public LinkedListDeque61B(){
        sentinel = new Node<> ( null,null ,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;

    }
    @Override
    public void addFirst(T x) {

            Node a = new Node<>(x,sentinel,sentinel.next);
        sentinel.next.prev=a;
        sentinel.next=a;
            size++;



    }

    @Override
    public void addLast(T x) {
        Node<T> a = new Node<>(x,sentinel.prev,sentinel);
        sentinel.prev.next=a;
        sentinel.prev=a;
        size++;


    }

    @Override
    public List<T> toList() {
//        if(sentinel.next==sentinel){
//            return new ArrayList<>() ;
//
//        }
        Node<T> p;
        p=sentinel.next;
        List<T> a = new ArrayList<>();
        while(p!=sentinel){
            a.add(p.item);
            p = p.next;
        }
        return a;
    }

    @Override
    public boolean isEmpty() {
        
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
