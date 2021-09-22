package com.github.ysc972.menglong;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Stack;

public class MengLong002 {

    public static String convert(String source){

        source.replaceAll("//","/");
        Stack<String> stack = new Stack<>();
        Deque<String> deque = new ArrayDeque();
        for(int i = 0; i < source.length(); i++){
            if(source.charAt(i) != '.' && source.charAt(i) != '/' ){
                for(int right = i + 1; right < source.length(); right ++){
                    if(source.charAt(right) == '.' || source.charAt(right) == '/' || right == source.length()){
                        deque.addLast(source.substring(i,right));
                        i = right;
                        break;
                    }
                }
            }
            if(source.charAt(i) == '.'){
                if(i < source.length() -1 ){
                    if(source.charAt(i + 1) == '.'){
                        deque.removeLast();
                    }
                }
            }
        }
        StringBuilder builder = new StringBuilder();

        while(!deque.isEmpty()){
            builder.append("/");
            builder.append(deque.removeFirst());
        }
        return builder.toString();
    }


}
