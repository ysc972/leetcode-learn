package com.github.ysc972.leetcode;

public class leetcode27 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }


    static class Solution {
        public int removeElement(int[] nums, int val) {

            int fastIndex = 0;
            int slowIndex = 0;
            int length = nums.length;

            while (fastIndex < length){

                if(nums[fastIndex] != val){
                    nums[slowIndex++] = nums[fastIndex];
                }
                fastIndex++;
            }
            return slowIndex;

        }
    }

}
