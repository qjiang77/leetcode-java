package Math;

/*
204. Count Primes (Easy)

埃拉托斯特尼筛法在每次找到一个素数时，将能被素数整除的数排除掉。
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;

        boolean[] notprime = new boolean[n];
        notprime[0] = true;
        notprime[1] = true;

        for(int i = 2; i * i < n; i++) {
            if(!notprime[i]) {
                for(int j = 2; i * j < n; j++) {
                    notprime[i*j] = true;
                }
            }
        }
        int count = 0;
        for(boolean notP : notprime) {
            if(!notP) count++;
        }
        return count;
    }
}
