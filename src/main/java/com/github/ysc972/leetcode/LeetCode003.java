package com.github.ysc972.leetcode;

import java.util.*;


/**
 *
 *  leetcode 003
 *  滑动窗口  主要判断 在什么情况下进行滑动，以及滑动之后的位置
 *
 */
public class LeetCode003 {

    public static void main(String[] args) {

        int tmmzuxt = new Solution().lengthOfLongestSubstring("abcabcbb");
        System.out.println(tmmzuxt);

    }


   static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int length = s.length();
            if(length == 0){
                return 0;
            }


            Map<Character,Integer> map = new HashMap();

            int left = 0;
            int max = 0;
            for(int i = 0; i < length; i++){
                if(map.containsKey(s.charAt(i))){
                    int  temp = map.get(s.charAt(i));
                    // 判断滑动的条件
                    if(left <= temp){
                        left = temp + 1;
                    }
                }
                map.put(s.charAt(i),i);
                max = Math.max(max,i-left+1);
            }

            return max;
        }
    }
}
