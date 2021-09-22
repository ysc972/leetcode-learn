package com.github.ysc972.hw;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Hw001 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < m; i++) {
            set.add(scanner.nextInt());
        }
        m = set.size();
        Integer[] data = set.toArray(new Integer[m]);
        int n = scanner.nextInt();
        Arrays.sort(data);
        if(n > m){
            return;
        }
        int min = 0;
        int max = 0;

        for(int i = 0; i < n; i++){
            min += data[i];
            max += data[m - i - 1];
        }
        int result = max + min;
        if(n * 2 > m){
            result = -1;
        }

        System.out.println(result);


    }


}
