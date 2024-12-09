package algorithm;

import java.io.*;
import java.util.*;

public class _2805_나무자르기 {
    private static int N;
    private static int M;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long max = 0;
        long min = 0;
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) {
                max = trees[i];
            }
        }


        while (min < max) {
            long mid = (max+min)/2;
            long result = 0;
            for (int x : trees) {
                if (x > mid) {
                    result += x - mid;
                }
            }
            if (result >= M) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min-1);

        bw.flush();
        bw.close();
    }
}
