package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _1931_회의실배정_answer {
    private static int N;
    private static StringTokenizer st;
    private static int start;
    private static int end;
    private static int[][] arr;
    private static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            arr[i] = new int[]{start, end};
        }

        Arrays.sort(arr, ((o1, o2) -> {
            return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
        }));

        int end = arr[0][1];
        for (int i = 1; i < N; i++) {
            if(arr[i][0] >= end){
                count++;
                end = arr[i][1];
            }
        }

        System.out.println(count);
    }
}
