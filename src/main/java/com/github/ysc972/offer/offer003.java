package com.github.ysc972.offer;

import java.util.HashSet;
import java.util.Set;

public class offer003 {

    public static void main(String[] args) {


        Set<Integer> set = new HashSet<>();

        set.add(4444);
        System.out.println(set.contains(4444));


    }
    class Solution {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for(int i = 0; i < nums.length; i++){

                if(set.contains(nums[i])){
                    return nums[i];
                }

                set.add(nums[i]);

            }

            throw new RuntimeException();

        }
    }
}
