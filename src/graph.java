import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class graph<T> {
    private final HashMap<T, List<T>> adjacencyList;
    private final boolean directed;

    public graph() {
        this(false);
    }

    public graph(boolean directed) {
        adjacencyList = new HashMap<>();
        this.directed = directed;
    }

    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(T from, T to) {
        addVertex(from);
        addVertex(to);
        adjacencyList.get(from).add(to);
        if (!directed) {
            adjacencyList.get(to).add(from);
        }
    }

    public List<T> neighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

    public int size() {
        return adjacencyList.size();
    }

    public List<T> bfs(T start) {
        List<T> visitOrder = new ArrayList<>();
        if (!adjacencyList.containsKey(start)) {
            return visitOrder;
        }

        HashMap<T, Boolean> visited = new HashMap<>();
        Queue<T> queue = new LinkedList<>();
        queue.add(start);
        visited.put(start, true);

        while (!queue.isEmpty()) {
            T current = queue.poll();
            visitOrder.add(current);
            for (T neighbor : adjacencyList.get(current)) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                }
            }
        }
        return visitOrder;
    }

    public List<T> dfs(T start) {
        List<T> visitOrder = new ArrayList<>();
        HashMap<T, Boolean> visited = new HashMap<>();
        dfsHelper(start, visited, visitOrder);
        return visitOrder;
    }

    private void dfsHelper(T current, HashMap<T, Boolean> visited, List<T> visitOrder) {
        if (!adjacencyList.containsKey(current) || visited.containsKey(current)) {
            return;
        }
        visited.put(current, true);
        visitOrder.add(current);
        for (T neighbor : adjacencyList.get(current)) {
            dfsHelper(neighbor, visited, visitOrder);
        }
    }
}
