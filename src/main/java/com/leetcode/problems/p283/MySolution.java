package com.leetcode.problems.p283;

import java.util.Arrays;

/**
 *

 283. 移动零
 简单

 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 请注意 ，必须在不复制数组的情况下原地对数组进行操作。

 示例 1:

 输入: nums = [0,1,0,3,12]
 输出: [1,3,12,0,0]
 示例 2:

 输入: nums = [0]
 输出: [0]


 提示:

 1 <= nums.length <= 104
 -231 <= nums[i] <= 231 - 1


 进阶：你能尽量减少完成的操作次数吗？
 *
 *
 */
public class MySolution {

    /**
     *  不允许使用额外数组空间
     *      - 可以使用双指针：遍历指针i与非零指针j
     *      - 第一次遍历：i先走，若i指向0，则j不做操作；若i不指向0，则赋值给j
     *          -- 这样在最后时，i - j=0的个数；
     *      - 第二次遍历，将j到i中间的元素置为0
     * @param nums
     */
    public void moveZeroes(int[] nums) {

        // 第一次遍历
        if (nums.length == 1) {
            return;
        }
        int i = 0, j = 0;
        for (; i < nums.length; i ++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j ++;
            }
        }

        for (int k = j; k < nums.length; k ++) {
            nums[k] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,1};

        MySolution p = new MySolution();
        p.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
