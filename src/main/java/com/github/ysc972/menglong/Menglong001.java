package com.github.ysc972.menglong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Menglong001 {


    public List<List<Integer>>  getResult(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length;
            while(left < right){
                if(nums[i]+nums[left]+nums[right] == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                }else if (nums[i]+nums[left]+nums[right] < 0){
                    left ++;
                }else{
                    right --;
                }
            }
        }
        return result;


    }

}
