import org.junit.jupiter.api.Test;


import static com.google.common.truth.Truth.assertThat;

class stackTest {
    @Test
    void inputTest() {
        stack stack = new stack();

        stack.addItem(1);
        stack.addItem(2);
        assertThat(stack.top()).isEqualTo(2);
        assertThat(stack.get()).isEqualTo(2);
        assertThat(stack.size()).isEqualTo(1);


    }

    @Test
    void resizeTest() {
        stack stack = new stack();

        for (int i = 0; i < 20; i++) {
            stack.addItem(i);
        }
        assertThat(stack.size()).isEqualTo(20);
    }


}