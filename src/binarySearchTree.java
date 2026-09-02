import java.util.ArrayList;
import java.util.List;

public class binarySearchTree<Item extends Comparable<Item>> {

    private static class node<T> {
        node<T> small_child;
        node<T> large_child;
        T value;

        public node(T x) {
            value = x;
            small_child = null;
            large_child = null;
        }
    }


    node<Item> tree;
    int size;

    public binarySearchTree() {
        tree = null;
    }

    public void add(Item x) {
        if (tree == null) {
            tree = new node<>(x);

        }
        else {

            node<Item> Iter = tree;
            tree = recursive_add(x, Iter);

        }
        // BUG (still open from before): this increments size even when recursive_add's
        // cmp==0 branch silently dropped a duplicate instead of inserting. size will drift
        // higher than the actual number of distinct nodes whenever a duplicate is added.



    }

    public static <Item extends Comparable<Item>> node<Item> recursive_add(Item x, node<Item> n) {
        if (n == null) {
            return new node<>(x);
        }
        int cmp = n.value.compareTo(x);
        if (cmp > 0) { //value>x
            //go to smaller child
            n.small_child = recursive_add(x, n.small_child);
        } else if (cmp == 0) {
            //drop it
            return n;
        } else if (cmp < 0) {
            //go larger
            n.large_child = recursive_add(x, n.large_child);
        }
        return n;
    }

    // BUG: this instance method redeclares its own type parameter <Item>, shadowing the
    // class's Item (declared at `class binarySearchTree<Item extends Comparable<Item>>`).
    // This new Item has no Comparable bound and is completely unrelated to the class's Item
    // — even though it has the same name. That's exactly why print_helper "can't be used"
    // below: print_helper requires <Item extends Comparable<Item>>, but this method's local
    // Item has no such bound, so the compiler can't satisfy print_helper's type constraint.
    // Fix: since this is an instance method (not static), it already has access to the
    // class's Item type parameter — just drop the `<Item>` here entirely and use Item as-is.
    public List<Item> print_bst(){
        List<Item> list = new ArrayList<>();
        if(tree==null){
            return list;
        }
        else {
            list = print_helper(this.tree,list);
            return list;
        }

    }

    // OK: this is correct in-order traversal now (left, self, right) — for a BST built the
    // way recursive_add builds it (smaller -> small_child, larger -> large_child), this
    // produces values in sorted order.
    public static <Item extends Comparable<Item>> List<Item> print_helper(node<Item> n, List<Item> a) {
        if (n == null) {
            return a;
        }
        // Minor/non-bug: ArrayList.add mutates `a` in place, and you always return the same
        // list back, so these reassignments (a = ...) are redundant — `print_helper(n.small_child, a);`
        // alone (discarding the return) would do the same thing. Harmless, just noise.
        print_helper(n.small_child,a);
        a.add(n.value);
        print_helper(n.large_child,a);

        return a;
    }
}




