import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long x = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        long xor = 0;
        long curr = 0;
        int i = 0;
        long[] list = new long[n];
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                list[j] = x;
            } else {
                list[j] = (a * list[j - 1] + b) % c;
            }
            curr ^= list[j];
            if (j - i + 1 == k) {
                xor ^= curr;
                curr ^= list[i];
                i++;
            }
        }

        System.out.println(xor);
        sc.close();
    }
}