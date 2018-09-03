package DFS;

import java.util.HashMap;
import java.util.LinkedList;

public class DFS {
    private static void dfs(HashMap<Character, LinkedList<Character>> graph,
                            HashMap<Character, Boolean> visited) {
        visit(graph, visited, 'u');
    }

    private static void visit(HashMap<Character, LinkedList<Character>> graph,
                              HashMap<Character, Boolean> visited, char start) {
        if(!visited.containsKey(start)) {
            visited.put(start, true);
            for(char c : graph.get(start)) {
                if(!visited.containsKey(c)) {
                    visit(graph, visited, c);
                }
            }
        }
    }
}
