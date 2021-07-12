package com.github.ysc972.leetcode;

import sun.plugin.liveconnect.OriginNotAllowedException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class leetcode239 {


    public static void main(String[] args) {
        for (int i : new Solution2().maxSlidingWindow(new int[]{1,-1}, 1)) {
            System.out.println(i);
        }
    }

    /**
     *
     * 暴力法  时间复杂度 过高
     *
     */
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            int[] res = new int[nums.length - k + 1];

            int max = Integer.MIN_VALUE;
            int index = -1;
            boolean first = true;
            for(int i = 0; i < nums.length - k + 1;i++){
                if(first){
                    int[] maxInfo = getMax(nums,i,k);
                    max = maxInfo[0];
                    index = maxInfo[1];
                }else if(nums[i + k - 1] >= max){
                    index = i+k-1;
                    max = nums[i + k - 1];
                }else if(index < i ){
                    int[] maxInfo = getMax(nums,i,k);
                    max = maxInfo[0];
                    index = maxInfo[1];
                }
                res[i] = max;
            }

            return res;

        }

        public int[] getMax(int[] nums,int start ,int k){
            int[] res = new int[2];
            res[0] = Integer.MIN_VALUE;
            for (int i = start; i < start + k; i++) {
                if(res[0] < nums[i]){
                    res[0] = nums[i];
                    res[1] = i;
                }
            }
            return res;
        }
    }
    static class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {

            Deque<Integer> deque = new ArrayDeque<>();

            int[] ans = new int[nums.length - k + 1];

            for(int i = 0; i < k; i++){
                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            ans[0] = nums[deque.peekFirst()];
            for(int i = k; i < nums.length; i++){

                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                    deque.pollLast();
                }

                deque.offerLast(i);
                while (deque.peekFirst() < i - k + 1){
                    deque.pollFirst();
                }
                ans[i - k + 1]=nums[deque.peekFirst()];
            }

            return ans;

        }
    }
}
