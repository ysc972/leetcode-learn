package com.github.ysc972.leetcode;

import java.util.HashMap;

public class leetcode567 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("ab","a"));
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {

            if(s1.length()>s2.length()){
                return false;
            }



            int windowsSize = s1.length();

            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> windows = new HashMap<>();
            int left = 0;
            int valid = 0;
            //   初始化 need 记录字数
            for(int i = 0; i < s1.length(); i++){
                need.put(s1.charAt(i),need.getOrDefault(s1.charAt(i),0)+1);
            }
            // 初始化 windows
            for(int i = 0; i < windowsSize; i++){
                char c = s2.charAt(i);
                windows.put(c,windows.getOrDefault(c,0)+1);
                if(windows.get(c).equals(need.get(c))){
                    valid++;
                }
                if(valid == need.size()){
                    return true;
                }
            }

            // 开始滑动
            for(int i = windowsSize; i < s2.length(); i++){
                // 左指针滑动
                char leftChar = s2.charAt(left);
                if(windows.get(leftChar).equals(need.get(leftChar))){
                    valid--;
                }
                windows.put(leftChar,windows.getOrDefault(leftChar,0)-1);
                left++;
                // 右指针滑动
                char rightChar = s2.charAt(i);
                windows.put(rightChar,windows.getOrDefault(rightChar,0)+1);
                if(windows.get(rightChar).equals(need.get(rightChar))){
                    valid++;
                }
                // 判断
                if(valid == need.size()){
                    return true;
                }
            }




            return false;
        }
    }
}
