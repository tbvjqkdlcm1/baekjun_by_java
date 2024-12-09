package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _1697_숨바꼭질 {
    private static int N;
    private static int K;
    private static StringTokenizer st;
    private static int[] visited = new int[100001];
    private static ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    private static int bfs(int N) {
        queue.add(N);
        visited[N] = 1;
        int idx;
        while (!queue.isEmpty()) {
            idx = queue.pop();
            if (idx == K) {
                return visited[idx]-1;
            }
            if (idx-1 >= 0 && visited[idx-1] == 0) {
                visited[idx-1] = visited[idx] + 1;
                queue.add(idx-1);
            }
            if (idx+1 <= 100000 && visited[idx+1] == 0) {
                visited[idx+1] = visited[idx] + 1;
                queue.add(idx+1);
            }
            if (idx*2 <= 100000 && visited[idx*2] == 0) {
                visited[idx*2] = visited[idx] + 1;
                queue.add(idx*2);
            }
        }
        return -1;
    }
}
//         1 2 3 4 5 6 7 8 9 10
// visited 5 4 3 2 1 2 3 4 5  6
// visited 5 4 3 2 1 2 3 3 3  2