package BFS;

import java.util.*;

public class BFS {
    // char start: the first node
    // HashMap<Character, Integer> dist: record the distance from every node to start
    private static void bfs(HashMap<Character, LinkedList<Character>> graph,
                            HashMap<Character, Integer> dist, char start) {
        // BFS: use Queue to implement -> LinkedList
        Queue<Character> queue = new LinkedList<>();
        queue.add(start);
        dist.put(start, 0);
        int i = 0;
        while(!queue.isEmpty()) {
            char top = queue.poll(); // get the top node of queue
            i++;
            System.out.println("The "+i+"th element: "+top+" Distance from start is:"+dist.get(top));
            int d = dist.get(top)+1;
            for(Character c : graph.get(top)) {
                // if dist is not contained key c, means it has never been visit
                if(!dist.containsKey(c)) {
                    dist.put(c, d);
                    queue.add(c);
                }
            }
        }
    }
}
