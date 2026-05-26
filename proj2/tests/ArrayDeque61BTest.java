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
        assertThat(sc.toList()).containsExactly( "First").inOrder();

//      non-empty array deque add first check
        sc.addFirst("Last");

        assertThat(sc.size()).isEqualTo(2);
        assertThat(sc.toList()).containsExactly("Last", "First").inOrder();

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



    }
//
//    Flags for size tests
//size: Check that size works.
//size_after_remove_to_empty: Add some elements to a deque and remove them all, then check that size still works.
//size_after_remove_from_empty: Remove from an empty deque, then check that size still works.
    @Test
    void  sizeTest(){
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
        sc.removeFirst();
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
    void removeFirst() {
        ArrayDeque61B<Integer> sc = new ArrayDeque61B<>();
        assertThat(sc.size()).isEqualTo(0);

    }

    @Test
    void removeLast() {
        ArrayDeque61B<String> sc = new ArrayDeque61B<>();
        assertThat(sc.size()).isEqualTo(0);

    }

    @Test
    void getfirst() {

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



//    Flags for get Tests
//get_first_empty: Check that getFirst works on an empty ArrayDeque.
//get_first_valid: Check that getFirst works on a nonempty ArrayDeque.
//get_last_empty: Check that getLast works on an empty ArrayDeque.
//get_last_valid: Check that getLast works on a nonempty ArrayDeque.
//get_valid: Check that get works on a valid index.
//get_oob_large: Check that get works on a large, out of bounds index.
//get_oob_neg: Check that get works on a negative index.


}
