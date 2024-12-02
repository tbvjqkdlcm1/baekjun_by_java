package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class _7576_토마토 {
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int M;
    private static int N;
    private static int[][] box;
    private static int count = 0;
    private static ArrayDeque<Integer[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(stn.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new Integer[]{i, j});
                }
            }
        }
        System.out.println(queing());
    }

    private static int queing() {
        while (!queue.isEmpty()) {
            Integer[] q = queue.poll();
            for (int i=0; i<4; i++) {
                int nx = dx[i] + q[0];
                int ny = dy[i] + q[1];
                if (0<=nx && nx<N && 0<=ny && ny<M && box[nx][ny] == 0) {
                    box[nx][ny] = box[q[0]][q[1]] + 1;
                    queue.add(new Integer[]{nx, ny});
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return -1;
                }
                count = Math.max(count, box[i][j]);
            }
        }

        if (count == 1) {
            return 0;
        } else
            return count-1;
    }

}
