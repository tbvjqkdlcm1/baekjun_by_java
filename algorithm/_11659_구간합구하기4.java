package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11659_구간합구하기4 {
    private static int N;
    private static int M;
    private static StringTokenizer st;
    private static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = new int[N+1];
        sum[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
             sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = sum[end] - sum[start-1];
            System.out.println(result);
        }
    }
}
