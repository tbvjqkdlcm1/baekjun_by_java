package algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1929_소수구하기 {
    private static int T;
    private static int N;
    private static int M;
    private static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        boolean[] result = new boolean[N+1];
        Arrays.fill(result, true);
        result[0] = false;
        result[1] = false;

        for (int i=2; i<=Math.sqrt(N); i++) {
            if (result[i]) {
                for (int j=i*i; j<result.length; j+=i) {
                    result[j] = false;
                }
            }
        }

        for (int i=M; i<result.length; i++) {
            if (result[i]) {
                System.out.println(i);
            }
        }

        bw.flush();
        bw.close();
    }
}
