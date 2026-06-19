import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class ArrayDeque61BTest {

    @Test
    void arrayConstructorTest() {
        ArrayDeque61B<Integer> sc = new ArrayDeque61B<>();
        assertThat(sc.size()).isEqualTo(0);

    }
//    Flags for add tests
//add_first_from_empty: Check that addFirst works on an empty deque.
//add_last_from_empty: Check that addLast works on an empty deque.
//add_first_nonempty: Check that addFirst works on a non-empty deque.
//add_last_nonempty: Check that addLast works on a non-empty deque.
//add_first_trigger_resize: Check that addFirst works when called on a full underlying array
//add_last_trigger_resize: Check that addLast works when called on a full underlying array

    @Test
    void arrayAddFirstTestBasic() {
        ArrayDeque61B<String> sc = new ArrayDeque61B<>();
        assertThat(sc.size()).isEqualTo(0);

//       empty array deque add first check
        sc.addFirst("First");

        assertThat(sc.size()).isEqualTo(1);
        assertThat(sc.toList()).containsExactly("First").inOrder();

//      non-empty array deque add first check
        sc.addFirst("Last");

        assertThat(sc.size()).isEqualTo(2);
        assertThat(sc.toList()).containsExactly("Last", "First").inOrder();

//        array resize test
        for (int i = 0; i < 16; i++) {
            sc.addFirst("First");
        }
        assertThat(sc.size()).isEqualTo(18);
        assertThat(sc.getLast()).isEqualTo("First");

    }


    @Test
    void arrayAddLastTestBasic() {
        ArrayDeque61B<String> sc = new ArrayDeque61B<>();
        assertThat(sc.size()).isEqualTo(0);

//      empty  array deque add Last check
        sc.addLast("First");
        assertThat(sc.size()).isEqualTo(1);
        assertThat(sc.toList()).containsExactly("First").inOrder();

//      non-empty  array deque add Last check
        sc.addLast("Last");

        assertThat(sc.size()).isEqualTo(2);
        assertThat(sc.toList()).containsExactly("First", "Last").inOrder();

//        array resize test
        for (int i = 0; i < 2000; i++) {
            sc.addLast("Last");
        }
        assertThat(sc.size()).isEqualTo(2002);
        assertThat(sc.getLast()).isEqualTo("Last");

    }

    //
//    Flags for size tests
//size: Check that size works.
//size_after_remove_to_empty: Add some elements to a deque and remove them all, then check that size still works.
//size_after_remove_from_empty: Remove from an empty deque, then check that size still works.
    @Test
    void sizeTest() {
        ArrayDeque61B<String> sc = new ArrayDeque61B<>();
        assertThat(sc.size()).isEqualTo(0);

        sc.addLast("First");
        assertThat(sc.size()).isEqualTo(1);
        assertThat(sc.toList()).containsExactly("First").inOrder();

        sc.addLast("Last");
        assertThat(sc.size()).isEqualTo(2);
        assertThat(sc.toList()).containsExactly("First", "Last").inOrder();
        sc.removeFirst();
        assertThat(sc.size()).isEqualTo(1);
        sc.removeFirst();
//        size after remove till empty

//        size after remove from empty
        assertThat(sc.size()).isEqualTo(0);

        sc.addFirst("First");
        sc.addLast("Last");
        sc.removeLast();
//        size after remove till empty
        sc.removeLast();
//        size after remove from empty
        assertThat(sc.size()).isEqualTo(0);

    }


    //Flags for isEmpty Tests
//is_empty_true: Check that size works on an empty deque.
//is_empty_false: Check that size works on a non-empty deque.
    @Test
    void EmptyArrayTest() {
        ArrayDeque61B<String> sc = new ArrayDeque61B<>();
        assertThat(sc.size()).isEqualTo(0);
        assertThat(sc.isEmpty()).isEqualTo(true);

        sc.addFirst("first");
        sc.addLast("last");
        assertThat((sc.isEmpty())).isEqualTo(false);
    }

    @Test
    void getFirst() {
        ArrayDeque61B<Integer> sc = new ArrayDeque61B<>();
        assertThat(sc.size()).isEqualTo(0);

        sc.addFirst(12);
        sc.addFirst(63);
        sc.addFirst(9);
        assertThat(sc.getFirst()).isEqualTo(9);

    }

    @Test
    void getLast() {
        ArrayDeque61B<Integer> sc = new ArrayDeque61B<>();
        assertThat(sc.size()).isEqualTo(0);
        sc.addLast(12);
        sc.addLast(63);
        assertThat(sc.getLast()).isEqualTo(63);
        assertThat(sc.getLast()).isEqualTo(63);

        sc.addLast(9);
        assertThat(sc.getLast()).isEqualTo(9);
    }

    //    Flags for add after remove tests
//add_first_after_remove_to_empty: Add some elements to a deque and remove them all, then check that addFirst still works.
//add_last_after_remove_to_empty: Add some elements to a deque and remove them all, then check that addLast still works.
    @Test
    void addFirstAfterRemoveToEmptyTest() {
        ArrayDeque61B<Integer> sc = new ArrayDeque61B<>();
        sc.addLast(1);
        sc.addLast(2);
        sc.removeFirst();
        sc.removeFirst();
        assertThat(sc.isEmpty()).isTrue();
//        add_first_after_remove_to_empty: addFirst must still work after emptying
        sc.addFirst(99);
        assertThat(sc.size()).isEqualTo(1);
        assertThat(sc.getFirst()).isEqualTo(99);
        assertThat(sc.getLast()).isEqualTo(99);
        assertThat(sc.toList()).containsExactly(99);
    }

    @Test
    void addLastAfterRemoveToEmptyTest() {
        ArrayDeque61B<Integer> sc = new ArrayDeque61B<>();
        sc.addLast(1);
        sc.addLast(2);
        sc.removeLast();
        sc.removeLast();
        assertThat(sc.isEmpty()).isTrue();
//        add_last_after_remove_to_empty: addLast must still work after emptying
        sc.addLast(99);
        assertThat(sc.size()).isEqualTo(1);
        assertThat(sc.getFirst()).isEqualTo(99);
        assertThat(sc.getLast()).isEqualTo(99);
        assertThat(sc.toList()).containsExactly(99);
    }

    @Test
    void getfirstTest() {

        ArrayDeque61B<String> sc = new ArrayDeque61B<>();
        assertThat(sc.size()).isEqualTo(0);

        assertThat(sc.getFirst()).isEqualTo(null);
        assertThat(sc.getLast()).isEqualTo(null);


        sc.addFirst("First");
        sc.addLast("Last");

        assertThat(sc.getFirst()).isEqualTo("First");
        assertThat(sc.getLast()).isEqualTo("Last");
    }


//    Flags for remove Tests
//remove_first: Check that removeFirst works.
//remove_last: Check that removeLast works.
//remove_first_to_empty: Add some elements to a deque and remove almost all of them. Check that removing the last element with removeFirst works.
//remove_last_to_empty: Add some elements to a deque and remove almost all of them. Check that removing the last element with removeLast works.
//remove_first_to_one: Add some elements to a deque and remove almost all of them. Check that removing the second to last element with removeFirst works.
//remove_last_to_one: Add some elements to a deque and remove almost all of them. Check that removing the second to last element with removeLast works.
//remove_first_trigger_resize: Called when usage factor is <= 25% and array size > 8. Checks that the array resizes appropriately.
//remove_last_trigger_resize: Called when usage factor is <= 25% and array size > 8. Checks that the array resizes appropriately.
    @Test
    void removeFirstTest(){
        ArrayDeque61B<String> sc = new ArrayDeque61B<>();
        assertThat(sc.size()).isEqualTo(0);
//        remove on empty array
        assertThat(sc.removeFirst()).isEqualTo(null);
        assertThat(sc.size()).isEqualTo(0);
//        remove on one element
        sc.addFirst("First");
        assertThat(sc.removeFirst()).isEqualTo("First");

        for (int i = 0; i < 16; i++) {
            sc.addFirst("first");
            sc.addLast("last");
        }
        assertThat(sc.size()).isEqualTo(32);
//        contents must be intact after the mixed adds, not just the count.
//        (a size-only assert would pass even on a corrupt deque — that is what
//        hid the old addLast overfill bug.)
        assertThat(sc.getFirst()).isEqualTo("first");
        assertThat(sc.getLast()).isEqualTo("last");
    }


    @Test
    void removeLastTest() {
        ArrayDeque61B<Integer> sc = new ArrayDeque61B<>();
        assertThat(sc.size()).isEqualTo(0);
//        removeLast on an empty deque returns null and leaves size at 0 (not -1)
        assertThat(sc.removeLast()).isNull();
        assertThat(sc.size()).isEqualTo(0);
//        remove_last: basic removal from the back
        sc.addLast(1);
        sc.addLast(2);
        sc.addLast(3);
        assertThat(sc.removeLast()).isEqualTo(3);
        assertThat(sc.size()).isEqualTo(2);
        assertThat(sc.toList()).containsExactly(1, 2).inOrder();
    }

    @Test
    void removeFirstToOneToEmptyTest() {
        ArrayDeque61B<Integer> sc = new ArrayDeque61B<>();
        sc.addLast(1);
        sc.addLast(2);
        sc.addLast(3);
        assertThat(sc.removeFirst()).isEqualTo(1);
//        remove_first_to_one: after this removal exactly one element remains
        assertThat(sc.removeFirst()).isEqualTo(2);
        assertThat(sc.size()).isEqualTo(1);
        assertThat(sc.getFirst()).isEqualTo(3);
//        remove_first_to_empty: the removal that empties the deque
        assertThat(sc.removeFirst()).isEqualTo(3);
        assertThat(sc.size()).isEqualTo(0);
        assertThat(sc.isEmpty()).isTrue();
    }

    @Test
    void removeLastToOneToEmptyTest() {
        ArrayDeque61B<Integer> sc = new ArrayDeque61B<>();
        sc.addLast(1);
        sc.addLast(2);
        sc.addLast(3);
        assertThat(sc.removeLast()).isEqualTo(3);
//        remove_last_to_one: after this removal exactly one element remains
        assertThat(sc.removeLast()).isEqualTo(2);
        assertThat(sc.size()).isEqualTo(1);
        assertThat(sc.getLast()).isEqualTo(1);
//        remove_last_to_empty: the removal that empties the deque
        assertThat(sc.removeLast()).isEqualTo(1);
        assertThat(sc.size()).isEqualTo(0);
        assertThat(sc.isEmpty()).isTrue();
    }

    @Test
    void removeFirstTriggerResizeTest() {
//        grow well past length 8, then remove most of it so usage drops <= 25%.
//        removeFirst must keep returning elements in order across the down-resize.
        ArrayDeque61B<Integer> sc = new ArrayDeque61B<>();
        for (int i = 0; i < 16; i++) {
            sc.addLast(i);
        }
        for (int i = 0; i < 12; i++) {
            assertThat(sc.removeFirst()).isEqualTo(i);
        }
        assertThat(sc.size()).isEqualTo(4);
        assertThat(sc.toList()).containsExactly(12, 13, 14, 15).inOrder();
        assertThat(sc.getFirst()).isEqualTo(12);
        assertThat(sc.getLast()).isEqualTo(15);
    }

    @Test
    void removeLastTriggerResizeTest() {
        ArrayDeque61B<Integer> sc = new ArrayDeque61B<>();
        for (int i = 0; i < 16; i++) {
            sc.addLast(i);
        }
        for (int i = 0; i < 12; i++) {
            assertThat(sc.removeLast()).isEqualTo(15 - i);
        }
        assertThat(sc.size()).isEqualTo(4);
        assertThat(sc.toList()).containsExactly(0, 1, 2, 3).inOrder();
        assertThat(sc.getFirst()).isEqualTo(0);
        assertThat(sc.getLast()).isEqualTo(3);
    }


//    Flags for get Tests
//get_first_empty: Check that getFirst works on an empty ArrayDeque.
//get_first_valid: Check that getFirst works on a nonempty ArrayDeque.
//get_last_empty: Check that getLast works on an empty ArrayDeque.
//get_last_valid: Check that getLast works on a nonempty ArrayDeque.
//get_valid: Check that get works on a valid index.
//get_oob_large: Check that get works on a large, out of bounds index.
//get_oob_neg: Check that get works on a negative index.
    @Test
    void getTest() {
        ArrayDeque61B<Integer> sc = new ArrayDeque61B<>();
        sc.addLast(10);
        sc.addLast(20);
        sc.addLast(30);
//        get_valid: in-bounds indices, 0-indexed from the front
        assertThat(sc.get(0)).isEqualTo(10);
        assertThat(sc.get(1)).isEqualTo(20);
        assertThat(sc.get(2)).isEqualTo(30);
//        getRecursive must agree with get (same indexing, no mutation)
        assertThat(sc.getRecursive(0)).isEqualTo(10);
        assertThat(sc.getRecursive(2)).isEqualTo(30);
//        get_oob_large: index >= size returns null
        assertThat(sc.get(3)).isNull();
        assertThat(sc.get(100)).isNull();
//        get_oob_neg: negative index returns null
        assertThat(sc.get(-1)).isNull();
//        a read must never mutate the deque
        assertThat(sc.size()).isEqualTo(3);
        assertThat(sc.toList()).containsExactly(10, 20, 30).inOrder();
    }


}
