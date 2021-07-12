package com.github.ysc972.leetcode;

public class leetcode209 {

    public static void main(String[] args) {

        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1,2,4,3}));

    }


    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {

            int left = 0;
            int sums = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sums += nums[i];
                while (sums >= target){
                    min = Math.min(min,i - left + 1);
                    sums -= nums[left];
                    left ++;
                }
            }

            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }


}
