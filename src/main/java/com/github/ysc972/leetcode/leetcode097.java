package com.github.ysc972.leetcode;

public class leetcode097 {
    public static void main(String[] args) {



        new Solution().sortedSquares(new int[]{-4,-1,0,3,10});

    }

    static class Solution {


        public int[] sortedSquares(int[] nums) {

            int[] res = new int[nums.length];

            int i = 0;
            int j = nums.length - 1;

            for(int k = nums.length - 1; k >= 0; k--){

                int left = nums[i] * nums[i];
                int right = nums[j] * nums[j];
                if(left > right){
                    i++;
                    res[k] = left;
                }else {
                    j--;
                    res[k] = right;
                }

            }


            return res;
        }
    }

}
