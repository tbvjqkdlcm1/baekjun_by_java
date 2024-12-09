package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10026_적록색약 {
    private static int N;
    private static char[][] graph;
    private static char[][] graph_copy;
    private static boolean[][] visited;
    private static boolean[][] visited_copy;
    private static String letters;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static ArrayDeque<Integer[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        graph_copy = new char[N][N];
        visited = new boolean[N][N];
        visited_copy = new boolean[N][N];

        for (int i=0; i<N; i++) {
            letters = br.readLine();
            for (int j=0; j<N; j++) {
                if (letters.charAt(j) == 'G') {
                    graph_copy[i][j] = 'R';
                    graph[i][j] = letters.charAt(j);
                } else {
                    graph_copy[i][j] = letters.charAt(j);
                    graph[i][j] = letters.charAt(j);
                }
            }
        }

        System.out.print(queing(visited, graph));
        System.out.print(" ");
        System.out.println(queing(visited_copy, graph_copy));
    }

    public static int queing(boolean[][] visited, char[][] graph) {
        int count = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visited[i][j]) {
                    queue.add(new Integer[]{i,j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Integer[] q = queue.poll();
                        for (int k=0; k<4; k++) {
                            int nx = dx[k] + q[0];
                            int ny = dy[k] + q[1];
                            if (0<=nx && nx<N && 0<=ny && ny<N && graph[nx][ny] == graph[i][j] && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                queue.add(new Integer[]{nx,ny});
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

// 처음엔 false 상태
// for문 도는데 처음에 false가 나오는 문자를 queue에 넣음
// 큐에서 빼고 그 아이를 기준으로 사방으로 돌믄서 큐에 삽입
// 다 끝나면 count +1
// 전부 돌리다가 false가 있으면 또 돌림
