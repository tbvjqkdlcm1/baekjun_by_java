package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1764_듣보잡 {
    private static int N;
    private static int M;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String[] ns = new String[N];
        for (int i=0; i<N; i++) {
            ns[i] = br.readLine();
        }

        Arrays.sort(ns);

        HashSet<String> hashSet = new HashSet<>();
        for (int i=0; i<M; i++) {
            int idx = Arrays.binarySearch(ns, br.readLine());
            if (idx >= 0) {
                hashSet.add(ns[idx]);
            }
        }

        List<String> arr_set = new ArrayList<>(hashSet);
        arr_set.sort(((o1, o2) -> o1.compareTo(o2)));

        System.out.println(arr_set.size());
        for (Object x : arr_set) {
            System.out.println(x);
        }
    }
}
