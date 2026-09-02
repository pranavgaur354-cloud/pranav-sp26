import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.google.common.truth.Truth.assertThat ;

class binarySearchTreeTest {

//    testing for constructor ,insertion , deletion , order , null values,search.
//    within insertion , testing for insertion







    @Test
    public  void insertionTest(){
        //initialise a null tree
        binarySearchTree<Integer> tree = new binarySearchTree<>();

        //upon adding value 1
        tree.add(5);
        assertThat(tree.print_bst()).contains(5);
        tree.add(4);
        tree.add(6);
        assertThat(tree.print_bst()).containsExactly(4,5,6).inOrder();
        //
        tree.add(3);
        tree.add(2);
        tree.add(8);
        tree.add(7);
        assertThat(tree.print_bst()).containsExactly(2,3,4,5,6,7,8).inOrder();



    }


}