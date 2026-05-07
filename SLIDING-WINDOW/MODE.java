import java.io.*;
import java.util.*;

public class MODE {
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
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, TreeSet<Long>> tm = new TreeMap<>();
        Map<Long, Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < n; j++) {
            long x = arr[j];
            if (map.containsKey(x)) {
                int freq = map.get(x);
                tm.get(freq).remove(x);
                if (tm.get(freq).isEmpty()) {
                    tm.remove(freq);
                }
            }
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            int freq = map.get(arr[j]);
            tm.putIfAbsent(freq, new TreeSet<>());
            tm.get(freq).add(x);
            if (j - i + 1 == k) {
                sb.append(tm.lastEntry().getValue().first()).append(" ");
                long y = arr[i];
                int f = map.get(y);
                tm.get(f).remove(y);
                if (tm.get(f).isEmpty()) {
                    tm.remove(f);
                }
                map.put(y, f - 1);
                if (map.get(y) == 0) {
                    map.remove(y);
                } else {
                    tm.putIfAbsent(f - 1, new TreeSet<>());
                    tm.get(f - 1).add(y);
                }
                i++;
            }
        }

        System.out.println(sb.toString().trim());
    }
}