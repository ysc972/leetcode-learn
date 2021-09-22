package com.github.ysc972.hw;

import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Hw003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetNum = scanner.nextInt();
        String s = scanner.next();
        s = s.toLowerCase(Locale.ROOT);
        int left = 0;
        int right = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('o');
        set.add('e');
        set.add('i');
        set.add('u');
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                int temp = targetNum;
                for(int j = i + 1; j < s.length();j++){
                    if(temp == -1){
                        break;
                    }
                    if(set.contains(s.charAt(j)) && temp ==0){
                        result = Math.max(result,j - i + 1);
                    }
                    if(!set.contains(s.charAt(j))){
                        temp--;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
