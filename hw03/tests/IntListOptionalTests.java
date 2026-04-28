import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntListOptionalTests {

    // Helper: build IntList from varargs (first element = head)
    private IntList makeList(int... vals) {
        IntList list = null;
        for (int i = vals.length - 1; i >= 0; i--) {
            list = new IntList(vals[i], list);
        }
        return list;
    }

    // Helper: convert IntList to int array for easy assertion
    private int[] toArray(IntList list) {
        int size = list.iterativeSize();
        int[] arr = new int[size];
        IntList p = list;
        for (int i = 0; i < size; i++) {
            arr[i] = p.first;
            p = p.rest;
        }
        return arr;
    }

    // ----------------------------------------------------------------
    // addLast tests
    // ----------------------------------------------------------------

    @Test
    @Order(1)
    @DisplayName("addLast: appends to single-element list")
    public void testAddLastSingleElement() {
        IntList list = makeList(1);
        list.addLast(2);
        assertThat(toArray(list)).isEqualTo(new int[]{1, 2});
    }

    @Test
    @Order(2)
    @DisplayName("addLast: appends to multi-element list")
    public void testAddLastMultiElement() {
        IntList list = makeList(1, 2, 3);
        list.addLast(4);
        assertThat(toArray(list)).isEqualTo(new int[]{1, 2, 3, 4});
    }

    @Test
    @Order(3)
    @DisplayName("addLast: multiple addLast calls preserve order")
    public void testAddLastMultipleCalls() {
        IntList list = makeList(10);
        list.addLast(20);
        list.addLast(30);
        assertThat(toArray(list)).isEqualTo(new int[]{10, 20, 30});
    }

    @Test
    @Order(4)
    @DisplayName("addLast: size increases correctly")
    public void testAddLastSize() {
        IntList list = makeList(5, 6);
        list.addLast(7);
        assertThat(list.iterativeSize()).isEqualTo(3);
    }

    // ----------------------------------------------------------------
    // addFirst tests
    // ----------------------------------------------------------------

    @Test
    @Order(5)
    @DisplayName("addFirst: prepends to single-element list")
    public void testAddFirstSingleElement() {
        IntList list = makeList(2);
        list.addFirst(1);
        assertThat(toArray(list)).isEqualTo(new int[]{1, 2});
    }

    @Test
    @Order(6)
    @DisplayName("addFirst: prepends to multi-element list")
    public void testAddFirstMultiElement() {
        IntList list = makeList(2, 3, 4);
        list.addFirst(1);
        assertThat(toArray(list)).isEqualTo(new int[]{1, 2, 3, 4});
    }

    @Test
    @Order(7)
    @DisplayName("addFirst: same reference is preserved after prepend")
    public void testAddFirstSameReference() {
        IntList list = makeList(5);
        IntList ref = list;        // hold original reference
        list.addFirst(0);
        // list and ref should still point to the same object
        assertThat(list).isSameInstanceAs(ref);
        assertThat(list.first).isEqualTo(0);
        assertThat(list.rest.first).isEqualTo(5);
    }

    @Test
    @Order(8)
    @DisplayName("addFirst: multiple addFirst calls preserve order")
    public void testAddFirstMultipleCalls() {
        IntList list = makeList(3);
        list.addFirst(2);
        list.addFirst(1);
        assertThat(toArray(list)).isEqualTo(new int[]{1, 2, 3});
    }

    @Test
    @Order(9)
    @DisplayName("addFirst: size increases correctly")
    public void testAddFirstSize() {
        IntList list = makeList(10, 20);
        list.addFirst(5);
        assertThat(list.iterativeSize()).isEqualTo(3);
    }
}
