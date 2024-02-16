package com.leetcode.problems.p70;

import org.apache.commons.lang3.time.StopWatch;

public class BSolution {

    /**
     *  使用动态规划解决问题
     *      f(n) = f(n - 1) + f(n - 2)
     * @return
     */
    public int climbStairsDynamicProgramming(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 3;

        int preP = 2;
        int pre = 3;
        int ret = 0;
        for (int i = 4; i <= n; i++) {

            ret = pre + preP;
            preP = pre;
            pre = ret;
        }

        return ret;
    }

    public static void main(String[] args) {
        BSolution s = new BSolution();
        StopWatch start = StopWatch.createStarted();
//        System.out.println(s.climbStairs(35));
        System.out.println(s.climbStairsDynamicProgramming(35));
        start.stop();
        System.out.println(start.getTime());
    }
}
