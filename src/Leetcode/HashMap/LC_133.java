package Leetcode.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC_133 {
    public static class Node{

        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public static void main(String[] args) {
        LC_133 test = new LC_133();
        Node a = new Node(1);
        Node b = test.cloneGraph(a);
        System.out.println(b.equals(a));
    }
    private HashMap <Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());

        visited.put(node, cloneNode);

        for (Node neighbour : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbour));
        }
        return cloneNode;
    }


}

