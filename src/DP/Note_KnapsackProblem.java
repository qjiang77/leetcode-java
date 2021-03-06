package DP;

/*
【背包问题九讲】
 */
public class Note_KnapsackProblem {
    /*
(1) 0-1背包
题目：
--> 有N件物品和一个容量为W的背包。第i件物品的容量是c[i]，价值是v[i]。求解将哪些物品装入背包可使价值总和最大。

特点：
--> 每种物品仅有一件，可以选择放或不放。

子问题定义状态：
--> dp[i][w]表示前i件物品恰放入一个容量为w的背包可以获得的最大价值

状态转移方程：
--> dp[i][w] = max(dp[i-1][w], dp[i-1][w-c[i]]+v[i])

易错重点！！：
--> 能否保证在推f[i][v]时（也即在第i次主循环中推f[v]时）能够得到f[i-1][v]和f[i-1][v-c[i]]的值呢？
    事实上，这要求在每次主循环中我们以v=V..0的顺序推f[v]，这样才能保证推f[v]时f[v-c[i]]保存的是状态f[i-1][v-c[i]]的值。


     */
}
