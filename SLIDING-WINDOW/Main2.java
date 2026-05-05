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
      Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        long[] list = new long[n];
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                list[j] = x;
            } else {
                list[j] = (a * list[j - 1] + b) % c;
            }
            while(!dq.isEmpty() && list[dq.peekLast()]>=list[j]){
                dq.pollLast();
            }
            dq.offerLast(j);
            if (j - i + 1 == k) {
               int v = dq.peekFirst();
                xor ^= list[v];
                if(dq.peekFirst()==i){
                    dq.pollFirst();
                }
                i++;
            }
        }

        System.out.println(xor);
        sc.close();
    }
}