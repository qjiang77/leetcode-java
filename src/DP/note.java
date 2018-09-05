package DP;

import java.util.*;
/*
【斐波那契数列】
1. 组合数学————错排问题
    问题一：写信将n封信装到n个信封中，有多少全部错误的装法
    问题二：四个人写贺年卡互相赠送，贺年卡不能送给自己
    etc.

    这些问题都可以称为错排问题
    考虑一个有n个元素的排列，若一个排列中所有的元素都不在自己原来的位置上，那么这样的排列就称为原排列的一个错排

    信件错排：伯努利-欧拉的装错信封问题
    N信件和N信封，被打乱
    求错误装信方式的数量
solution:
    dp[i]，前i个信件信封错误方式的数量
    下面用递推的方法推导错排公式:
    当n个编号元素放在n个编号位置,元素编号与位置编号各不对应的方法数用M(n)表示,那么M(n-1)就表示n-1个编号元素放在n-1个编号位置,各不对应的方法数,其它类推.
    第一步,把第n个元素放在一个位置,比如位置k,一共有n-1种方法;
    第二步,放编号为k的元素,这时有两种情况.1,把它放到位置n,那么,对于剩下的n-2个元素,就有M(n-2)种方法;2,不把它放到位置n,这时,对于这n-1个元素,有M(n-1)种方法;

    dp[i] = (n-1)*(dp[i-2]+dp[i-1])

2. 母牛生产：
    题目描述：假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死；
    第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛；
    每只小母牛 3 年之后成熟又可以生小母牛；
    给定整数 N，求 N 年后牛的数量；
solution：
    dp[i]记为i年后牛的数量
    dp[i] = dp[i-1]+dp[i-3]

【矩阵路径】
 */
class note{
    // elements could be +1/-1
    // return the minStep that make the array ascending
    // 求是数组变为递增数组的最小cost
    public int minStep(int[] a) {
        if(a == null || a.length == 0) return 0;
        // only int, char, float, double: value
        // array and etc.:address
        int l = a.length;
        int[] b = new int[l];
        for(int i = 0; i < l; i++) {
            b[i] = a[i];
        }
        Arrays.sort(b);
        int[] dp = new int[l+1];
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                dp[j] = dp[j] + Math.abs(a[i]-b[j]);
                if(j>1) {
                    dp[j] = Math.min(dp[j-1], dp[j]);
                }
            }
        }
        return dp[l];
    }
}