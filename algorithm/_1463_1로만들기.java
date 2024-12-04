package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463_1로만들기 {
    private static int x;
    private static int[] result;
    private static int tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());
        result = new int[x+3];
        result[1] = result[2] = 1;
        result[3] = 2;

        for (int i=3; i<x; i++) {
            if ((i+1) % 6 == 0) {
                result[i] = Math.min(Math.min(result[i/3], result[i/2]), result[i-1]) + 1;
            } else if ((i+1) % 3 == 0) {
                result[i] = Math.min(result[i-1], result[i/3]) + 1;
            } else if ((i+1) % 2 == 0) {
                result[i] = Math.min(result[i-1], result[i/2]) + 1;
            } else result[i] = result[i-1] + 1;
        }
        System.out.println(result[x-1]);
    }
}

// 1 2 3 4 5 6 7  8  9 10 11 12
// 0 1 1 2 3 2 3  3  2  3  4  3