// import java.io.*;
// import java.util.*;
// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int n = Integer.parseInt(st.nextToken());
//         int k = Integer.parseInt(st.nextToken());
//         st = new StringTokenizer(br.readLine());
//         long x = Long.parseLong(st.nextToken());
//         long a = Long.parseLong(st.nextToken());
//         long b = Long.parseLong(st.nextToken());
//         long c = Long.parseLong(st.nextToken());
//         long xor = 0;
//         int i = 0;
//         int[] bit = new int[64];
//         long[] list = new long[n];

//         for (int j = 0; j < n; j++) {
//             if (j == 0) list[j] = x;
//             else list[j] = (a * list[j - 1] + b) % c;

//             long temp = list[j];
//             for (int idx = 0; temp > 0; idx++) {
//                 if ((temp & 1) == 1) bit[idx]++;
//                 temp >>= 1;
//             }

//             if (j - i + 1 == k) {
               
//                 long res = 0;
//                 for (int idx = 0; idx < 62; idx++) {
//                     if (bit[idx] > 0) res |= (1L << idx);
//                 }
//                 xor ^= res;
//                 temp = list[i];
//                 for (int idx = 0; temp > 0; idx++) {
//                     if ((temp & 1) == 1) bit[idx]--;
//                     temp >>= 1;
//                 }
//                 i++;
//             }
//         }

//         System.out.println(xor);
//     }
// }

// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         int n = Integer.parseInt(st.nextToken());
//         int k = Integer.parseInt(st.nextToken());
//         st = new StringTokenizer(br.readLine());
//         long x = Long.parseLong(st.nextToken());
//         long a = Long.parseLong(st.nextToken());
//         long b = Long.parseLong(st.nextToken());
//         long c = Long.parseLong(st.nextToken());
//         long xor = 0;
//         int[] bit = new int[64];
//         long[] list = new long[n];
//         long curr = 0;

//         for (int j = 0; j < n; j++) {
//             list[j] = (j == 0) ? x : (a * list[j - 1] + b) % c;

//             long temp = list[j];
//             for (int idx = 0; temp > 0; idx++, temp >>= 1) {
//                 if ((temp & 1) == 1) {
//                     if (++bit[idx] == 1) curr |= (1L << idx);
//                 }
//             }

//             if (j >= k - 1) {
//                 xor ^= curr;
                
//                 long out = list[j - k + 1];
//                 for (int idx = 0; out > 0; idx++, out >>= 1) {
//                     if ((out & 1) == 1) {
//                         if (--bit[idx] == 0) curr &= ~(1L << idx);
//                     }
//                 }
//             }
//         }
//         System.out.println(xor);
//     }
// }


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long xor = 0;
        int i = 0;
        int[] bit = new int[64];
        long[] list = new long[n];

        for (int j = 0; j < n; j++) {

            if (j == 0) {
                list[j] = x;
            } else {
                list[j] = (a * list[j - 1] + b) % c;
            }

            inc(bit, list[j]);

            if (j - i + 1 == k) {
                xor ^= val(bit);
                dec(bit, list[i]);
                i++;
            }
        }

        System.out.println(xor);
    }

    public static void inc(int[] bit, long x) {
        int i = 0;
        while (x > 0) {
            if ((x & 1) == 1) bit[i]++;
            x >>= 1;
            i++;
        }
    }

    public static void dec(int[] bit, long x) {
        int i = 0;
        while (x > 0) {
            if ((x & 1) == 1) bit[i]--;
            x >>= 1;
            i++;
        }
    }

    public static long val(int[] bit) {
        long res = 0;
        for (int i = 0; i < 64; i++) {
            if (bit[i] > 0) {
                res |= (1L << i);
            }
        }
        return res;
    }
}