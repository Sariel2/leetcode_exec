package com.leetcode.problems.p70;

import javafx.scene.paint.Stop;
import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 *
 * 提示：
 *
 * 1 <= n <= 45
 *
 *
 *
 *
 */

public class MySolution {

    /**
     *  个人分析
     *      - 由于每走一步之后的方法计算方式都相同，则可以使用递归
     *          -- f(1)=1   f(2)=2   f(3)=3，最终都会收敛到三个值
     *
     *  此方法属于暴力解法，结果没问题，会导致超时
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 3) {
            return n;
        }

        /* 此时计算 3阶以上的情况 */
        // 则为走一步的情况 + 走两步的情况
        return climbStairs(n - 1) + climbStairs(n - 2);

    }


    /**
     * 借助内存
     *  - 将计算好的阶梯数放入内存Map中，节省计算时间。
     * @param n
     * @return
     */
    Map<Integer, Integer> memStairsCounts = new HashMap<>();
    public int climbStairsMem(int n) {

        memStairsCounts.put(0, 0);
        memStairsCounts.put(1, 1);
        memStairsCounts.put(2, 2);
        memStairsCounts.put(3, 3);

        if (null == memStairsCounts.get(n)) {
            // 则为走一步的情况 + 走两步的情况
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            memStairsCounts.put(n, result);
            return result;
        } else {
            return memStairsCounts.get(n);
        }
    }


    public static void main(String[] args) {
        MySolution s = new MySolution();
        StopWatch start = StopWatch.createStarted();
//        System.out.println(s.climbStairs(35));
        System.out.println(s.climbStairsMem(35));
        start.stop();
        System.out.println(start.getTime());
    }
}
