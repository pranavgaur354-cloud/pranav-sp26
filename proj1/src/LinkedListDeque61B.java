
import java.util.List;
import java.util.ArrayList;


public class LinkedListDeque61B<T> implements Deque61B<T> {



    public  class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node( T i, Node p, Node n){
            prev =p;
            next = n;
            item = i;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque61B(){
        sentinel = new Node( null,null ,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;

    }
    @Override
    public void addFirst(T x) {

            Node a = new Node(x,sentinel,sentinel.next);
        sentinel.next.prev=a;
        sentinel.next=a;
            size = size+1 ;

    }

    @Override
    public void addLast(T x) {
        Node a = new Node(x,sentinel.prev,sentinel);
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
        Node p;
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
        if(sentinel.next == sentinel){
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
        Node p = sentinel.next;
        return p.item ;
    }

    @Override
    public T getLast() {
        Node p = sentinel.prev;
        return p.item;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()){
            return null;
        }
        Node a = sentinel.next;
        sentinel.next=a.next;
        a.next.prev=sentinel;

        size--;
        return a.item;
    }

    @Override
    public T removeLast() {
        if(isEmpty()){
            return null;
        }
        Node a = sentinel.prev;
        sentinel.prev=a.prev;
        a.prev.next =sentinel;

        size--;
        return a.item;

    }

    @Override
    public T get(int index) {
        Node p= sentinel.next;
        if(size <= index || index < 0){
            return  null;
        }
        while(index >0 ){
            p = p.next;
            index--;
        }
        return p.item;
    }

    @Override
    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(Node obj , int index){

        if(index==0){
            return obj.item;
        }

        return getRecursiveHelper(obj.next,index -1);
    }
}
