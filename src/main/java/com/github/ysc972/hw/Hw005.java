package com.github.ysc972.hw;

import java.util.*;

public class Hw005 {


    public static void main(String[] args) {
        System.out.println(new Hw005().trianglesNumber(2));
    }

    public int trianglesNumber(int n){
        HashSet<String> cache = new HashSet<>();
        int count = 0;
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <=n; j++){
                for(int k = 1; k <= n; k++){
                    int[] temp = new int[3];
                    temp[0] = i;
                    temp[1] = j;
                    temp[2] = k;
                    Arrays.sort(temp);
                    if(temp[0] + temp[1] > temp[2]&&!cache.contains(""+temp[0]+temp[1]+temp[2])){
                        cache.add(""+temp[0]+temp[1]+temp[2]);
                        count++;
                    }
                }
            }
        }

        return count;

    }


}
