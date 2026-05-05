import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        HashMap<Long, Integer> map = new HashMap<>(n * 2);
        StringBuilder sb = new StringBuilder();

        int i = 0;

        for (int j = 0; j < n; j++) {

            long val = arr[j];
            map.put(val, map.getOrDefault(val, 0) + 1);

            if (j - i + 1 == k) {

                sb.append(map.size()).append(" ");

                long out = arr[i];

                int cnt = map.get(out) - 1;
                if (cnt == 0) {
                    map.remove(out);
                } else {
                    map.put(out, cnt);
                }

                i++;
            }
        }

        System.out.println(sb.toString().trim());
    }
}