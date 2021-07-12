package com.github.ysc972.leetcode;

import java.util.*;

public class leetcode030 {

    public static void main(String[] args) {
        new Solution().findSubstring("barfoothefoobarman", new String[]{"foo","bar"});
    }

    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            ArrayList<Integer> result = new ArrayList<>();

            int length = s.length();
            int wordNum = words.length;

            int wordSize = words[0].length();

            HashMap<String, Integer> wordCount = new HashMap<>();
            for (String word : words) {
                Integer value = wordCount.getOrDefault(word, 0);
                wordCount.put(word,value+1);
            }

            for(int i = 0; i < length - wordSize * wordNum + 1; i++){
                int j = 0;
                HashMap<String, Integer> countS = new HashMap<>();
                while (j < wordNum){

                    String wordIns = s.substring(i + j * wordSize,i + (j+1) *wordSize );
                    if(!wordCount.containsKey(wordIns)){
                        break;
                    }
                    Integer countIns = countS.getOrDefault(wordIns, 0);
                    countIns++;
                    Integer count = wordCount.get(wordIns);
                    if(count < countIns){
                        break;
                    }
                    countS.put(wordIns,countIns);
                    j++;
                }
                if(j == wordNum){
                    result.add(i);
                }




            }



            return result;
        }
    }

}
