package com.github.ysc972.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hw002 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for (String item : s.split(" ")) {
            list.add(Integer.valueOf(item));
        }
        int min = Integer.MAX_VALUE;
        int[] mnno = new int[list.size()];
        int first = list.get(0);
        first = Math.min(list.size()/2,first);
        for(int i = 1; i < first; i++){
           int step =  getStep(i,list,mnno);
           if(step == -2){
               continue;
           }
           min = Math.min(min,step);
        }
        if(min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(min + 1);
        }

    }
    public static int getStep(int start, List<Integer> nums,int[] mnno){
        if(start == nums.size() - 1){
            return 0;
        }
        if(start >= nums.size()){
            return -2;
        }
        if(mnno[start] != 0){
            return mnno[start];
        }
        int step = getStep(start + nums.get(start),nums,mnno);
        if(step == -2){
            mnno[start] = -2;
            return -2;
        }
        mnno[start] = step + 1;
        return step + 1;
    }
}
