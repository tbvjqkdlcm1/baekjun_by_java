package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1931_회의실배정_fail {
    private static int N;
    private static StringTokenizer st;
    private static int start;
    private static int end;
    private static Map<Integer, Integer> hashmap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            if (hashmap.containsKey(start)) {
                if (hashmap.get(start) > end) {
                    hashmap.put(start, end);
                }
            } else {
                hashmap.put(start, end);
            }
        }

        int min = 123456789;
        int max = -1;
        for (int x : hashmap.values()) {
            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }
        }

        int count = 1;
        for (int x : hashmap.keySet()) {
            if (x >= min) {
                min = hashmap.get(x);
                count += 1;
            }
        }

        System.out.println(count);
    }
}
