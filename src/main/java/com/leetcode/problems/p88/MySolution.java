package com.leetcode.problems.p88;

import java.util.Arrays;

/**
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 *
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 *
 *
 * 提示：
 *
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 *
 *
 * 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 *
 *
 *
 */
public class MySolution {

    /**
     *  双链表遍历
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int num1P = 0, num2P = 0;

        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i ++) {
                nums1[i] = nums2[i];
            }
        }

        int tempP = 0;
        int[] temp = new int[m + n];
        while (num1P < m && num2P < n) {

            // 判断若对应位置的nums1大于nums2，则放入前面；nums2向后走一位
            if (nums1[num1P] >= nums2[num2P]) {
                temp[tempP] = nums2[num2P];
                num2P ++;
            } else {
                temp[tempP] = nums1[num1P];
                num1P ++;
            }
            tempP ++;
        }

        // 计算余量，若nums1用完，则后续使用nums2补全
        if (num1P == m) {
            for (int i = num2P; i < n; i ++) {
                temp[m + i] = nums2[i];
            }
        }
        if (num2P == n) {
            for (int i = num1P; i < m; i ++) {
                temp[n + i] = nums1[i];
            }
        }

        for (int i=0; i < m + n; i ++) {
            nums1[i] = temp[i];
        }
    }


    /**
     *  反向指针计算
     *      - 由于nums1后n位都为0，则可以与nums2进行尾部比对计算；不会影响到前m的取值问题
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeReverse(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) return;
        if (m == 0) {
            for (int i = 0; i < n; i ++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        for (int i = m + n, p1 = m - 1, p2 = n - 1; i > 0; i --) {

            // 判断：nums2较大，则在对应位置放入nums1，指针后移
            // 若nums1已经加入完成，则置入nums2
//            if (nums2[p2] >= nums1[p1]) {
//                nums1[i - 1] = nums2[p2];
//                p2 --;
//            } else if (nums2[p2] < nums1[p1]) {
//                nums1[i - 1] = nums1[p1];
//                p1 --;
//            } else if (p1 < 0) {
//                nums1[i - 1] = nums2[p2];
//                p2 --;
//            } else if (p2 < 0) {
//                nums1[i - 1] = nums1[p1];
//                p1 --;
//            }
            if (p1 < 0) {
                nums1[i - 1] = nums2[p2];
                p2 --;
            } else if (p2 < 0) {
                nums1[i - 1] = nums1[p1];
                p1 --;
            } else if (nums2[p2] > nums1[p1]) {
                nums1[i - 1] = nums2[p2];
                p2 --;
            } else {
                nums1[i - 1] = nums1[p1];
                p1 --;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        MySolution m = new MySolution();
//        m.merge(nums1, 3, nums2, 3);
        m.mergeReverse(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

}
