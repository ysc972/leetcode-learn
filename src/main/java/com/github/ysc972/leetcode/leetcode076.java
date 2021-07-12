package com.github.ysc972.leetcode;

import java.util.HashMap;

public class leetcode076 {
    public static void main(String[] args) {

        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));

    }

    static class Solution {
        public String minWindow(String s, String t) {

            if(t.length()==0||s.length()==0|t.length()>s.length()){
                return "";
            }
            HashMap<Character, Integer> need = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c,need.getOrDefault(c,0)+1);
            }

            HashMap<Character,Integer> window = new HashMap<>();

            int left = 0;
            int len = Integer.MAX_VALUE;
            int valid = 0;
            int start = 0;
            for (int right = 0; right < s.length(); right++) {

                char c = s.charAt(right);
                if(need.containsKey(c)){
                    window.put(c,window.getOrDefault(c,0)+1);
                    if(window.get(c).equals(need.get(c))){
                        valid++;
                    }
                }
                while (valid == need.size()){

                    if(right - left < len){
                        len = right - left;
                        start = left;
                    }
                    char d = s.charAt(left);
                    left++;
                    if(need.containsKey(d)){
                        if(window.get(d).equals(need.get(d))){
                            valid--;
                        }
                        window.put(d,window.getOrDefault(d,0)-1);
                    }


                }




            }



            return len==Integer.MAX_VALUE?"": s.substring(start,start+len+1);
        }
    }
}
