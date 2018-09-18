package Math;

public class note {
    /*
    【素数】
    素数分解

    每一个数都可以分解成素数的乘积，例如 84 = 22 * 31 * 50 * 71 * 110 * 130 * 170 * …
    // 可以选择加或不加

    整除

    令 x = 2m0 * 3m1 * 5m2 * 7m3 * 11m4 * …

    令 y = 2n0 * 3n1 * 5n2 * 7n3 * 11n4 * …

    如果 x 整除 y（y mod x == 0），则对于所有 i，mi <= ni。

    最大公约数最小公倍数

    x 和 y 的最大公约数为：gcd(x,y) = 2min(m0,n0) * 3min(m1,n1) * 5min(m2,n2) * ...

    x 和 y 的最小公倍数为：lcm(x,y) = 2max(m0,n0) * 3max(m1,n1) * 5max(m2,n2) * ...


    【最大公约数】
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    【最小公倍数】为两数的乘积除以最大公约数。
    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

     */
}
