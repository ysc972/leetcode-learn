package com.github.ysc972.zhaoshang;

import java.util.*;

public class ZS002 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] source = new int[n];

        for(int i = 0; i < n; i++){
            source[i] = scanner.nextInt();
        }

        System.out.println(getAllList(source));


    }

    public static int getAllList(int[] source){
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < source.length; i++){

            if(!result.isEmpty()){
                ArrayList<List<Integer>> temp = new ArrayList<>(result);
                for (List<Integer> list : temp) {
                    ArrayList<Integer> temp1 = new ArrayList<>(list);
                    temp1.add(source[i]);
                    int sum = temp1.stream().mapToInt(integer -> integer).sum();
                    if(sum == 24){
                        String s = "";
                        for (Integer integer : temp1) {
                            s += integer;
                        }
                        if(set.contains(s))
                            continue;
                        count ++;
                        set.add(s);
                    }
                    result.add(temp1);
                }
            }

            result.add(Arrays.asList(source[i]));



        }
        return count;

    }

}
