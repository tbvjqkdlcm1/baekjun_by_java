package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _1260_DFS와BFS {
    private static int N;
    private static int M;
    private static int V;
    private static StringTokenizer st;
    private static int[][] graph;
    private static boolean[] visited;
    private static ArrayDeque<Integer> queue = new ArrayDeque<>();
    private static String result = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N+1][N+1];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);

        result += "\n";
        visited = new boolean[N+1];
        bfs(V);

        System.out.println(result);
    }

    static void dfs(int startNode) {
        visited[startNode] = true;
        result += startNode + " ";

        for (int i=0; i<=N; i++) {
            if (graph[startNode][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int startNode) {
        queue.add(startNode);
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int start = queue.pop();
            result += start + " ";
            for (int i=1; i<=N; i++) {
                if (graph[start][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
