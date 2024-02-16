package com.leetcode.problems.p1;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 *
 *
 *
 */

public class MySolution {

    /**
     *  个人分析
     *      暴力解法： n^2复杂度解——嵌套循环
     *
     *      优化解法：
     *          - 循环两次，第一次计算所有值的补数
     *          - 第二次根据补数寻找对应的脚标。
     * @param
     * @return
     */
    // key为补全值，value为下标
    Map<Integer, Integer> retToIndex = new HashMap<>();
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i ++) {
            retToIndex.put(target - nums[i], i);
        }

        // 再次循环，看是否可以匹配
        for (int j = 0; j < nums.length; j ++) {
            if (null != retToIndex.get(nums[j]) && retToIndex.get(nums[j]) != j) {
                return new int[]{retToIndex.get(nums[j]), j};
            }
        }

        return null;
    }



    public static void main(String[] args) {
        MySolution s = new MySolution();
        StopWatch start = StopWatch.createStarted();

        start.stop();
        System.out.println(start.getTime());
    }
}
