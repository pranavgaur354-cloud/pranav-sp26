import org.junit.jupiter.api.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

class graphTest {
    @Test
    void addEdgeTest() {
        graph<Integer> graph = new graph<>();

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        assertThat(graph.size()).isEqualTo(3);
        assertThat(graph.neighbors(1)).containsExactly(2, 3);
        assertThat(graph.neighbors(2)).containsExactly(1);
    }

    @Test
    void bfsTest() {
        graph<Integer> graph = new graph<>();

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        List<Integer> order = graph.bfs(1);
        assertThat(order).containsExactly(1, 2, 3, 4);
    }

    @Test
    void dfsTest() {
        graph<Integer> graph = new graph<>();

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);

        List<Integer> order = graph.dfs(1);
        assertThat(order).containsExactly(1, 2, 3, 4);
    }

    @Test
    void directedGraphTest() {
        graph<Integer> graph = new graph<>(true);

        graph.addEdge(1, 2);

        assertThat(graph.neighbors(1)).containsExactly(2);
        assertThat(graph.neighbors(2)).isEmpty();
    }
}
