package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1012_유기농배추 {
    private static int T;
    private static int M;
    private static int N;
    private static int K;
    private static StringTokenizer st;
    private static int[][] graph;
    private static ArrayDeque<int[]> queue = new ArrayDeque<>();
    private static boolean[][] visited;
    private static int[] x = {1, 0, -1, 0};
    private static int[] y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                graph[m][n] = 1;
            }

            visited = new boolean[N][M];
            System.out.println(bfs(graph));
        }
    }

    static int bfs(int[][] graph) {
        int count = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] start = queue.pop();
                        for (int k=0; k<4; k++) {
                            int nx = x[k] + start[0];
                            int ny = y[k] + start[1];
                            if (nx >=0 && nx < N && ny >=0 && ny < M && !visited[nx][ny] && graph[nx][ny] == 1) {
                                visited[nx][ny] = true;
                                graph[nx][ny] = 0;
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
