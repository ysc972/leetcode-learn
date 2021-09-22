package com.github.ysc972.zhaoshang;

import java.util.Scanner;

public class ZS001 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String source = scanner.next();
        System.out.println(new ZS001().getResult(source));

    }


    public String getResult(String source){

        int num = 0;
        for (char c : source.toCharArray()) {
            if(c == '*'){
                num++;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < num; i++){
            result.append("*");
        }
        for (char c : source.toCharArray()) {
            if(c != '*'){
                result.append(c);
            }
        }

        return result.toString();
    }

}
