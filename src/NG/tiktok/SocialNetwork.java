package NG.tiktok;

import java.util.*;

/**
 * 2 * @Author: Eugene Feng
 * 3 * @Date: 10/18/22 7:26 PM
 * 4
 */
public class SocialNetwork {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //T test cases, each case has m pairs
        // T
        // m
        // 1 2
        // 2 4
        // ...
        int caseNum = Integer.valueOf(s.nextLine());
        for (int i = 0; i < caseNum; i++) {
            int cur = Integer.valueOf(s.nextLine());
            int[][] edges = new int[cur][2];
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < cur; j++) {
                //String[] str = s.nextLine().split(" ");
                int e1 = s.nextInt();
                int e2 = s.nextInt();
                edges[j][0] = e1;
                edges[j][1] = e2;
                set.add(e1);
                set.add(e2);
            }
            System.out.println("testCase" + i + ": " + solution(set.size(), edges));
        }
    }

    public static int solution(int n, int[][] edges) {
        int res = 0;
        int[] visited = new int[n];


        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            adj[from].add(to);
            adj[to].add(from);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                res = Math.max(res, dfs(adj, visited, i));
            }
        }
        return res;
    }
    public static int dfs(List<Integer>[] adj, int[] visited, int node) {
        if (visited[node] == 1) {
            return 0;
        }
        visited[node] = 1;
        int res = 1;
        for (int i = 0; i < adj[node].size(); i++) {
            if (visited[adj[node].get(i)] == 0) {
               res += dfs(adj, visited, adj[node].get(i));
            }
        }
        return res;
    }
}
