package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1697_숨바꼭질 {
    private static int N;
    private static int K;
    private static StringTokenizer st;
    private static int min;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        min = K-N;
        fx(N, count);

        System.out.println(count);
    }

    public static void fx(int N, int count) {
        if (N == K) {
            min = Math.min(min, count);
            return;
        }
        if (count > min) {
            return;
        }
        if (N-1 >= 0 || N > K) {
            fx(N-1, count+1);
        }
        if (0 <= N && N < K ) {
            fx(N+1, count+1);
            fx(N*2, count+1);
        }
    }
}
// 5 -> 6 7 8 9 10 11
// 5 -> 1 2 3 2 1 1+1