package com.github.ysc972.offer;

import java.util.Stack;

public class offer29 {

    public static void main(String[] args) {
        new Solution().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }

    static class Solution {
        public int[] spiralOrder(int[][] matrix) {

            int m = matrix.length;
            if(m == 0){
                return new int[0];
            }
            int n = matrix[0].length;
            if(n == 0){
                return new int[0];
            }
            Stack<Integer> stack = new Stack<>();


            int[] res = new int[m * n];
            int startX = 0;
            int startY = 0;
            int index =0;
            int offset = 1;

            int loop = Math.min(m / 2,n / 2);

            for(int k = 0; k < loop; k++){

                int i = startX;
                int j = startY;
                for(;j < n - offset; j++){
                    res[index++] = matrix[startX][j];
                }
                for(;i < m - offset; i++){
                    res[index++] = matrix[i][j];
                }
                for(;j >= offset; j--){
                    res[index++] = matrix[i][j];
                }
                for(;i >= offset; i--){
                    res[index++] = matrix[i][startY];
                }
                startX++;
                startY++;
                offset++;
            }

            if(Math.min(m,n) % 2 == 1){
                int i = startX;
                int j = startY;
                if(m == n){
                    res[index++] = matrix[i][j];
                }
                if(m > n){
                    for(;i <= m - offset; i++){
                        res[index++] = matrix[i][startY];
                    }
                }
                if(m < n){
                    for(;j <= n - offset; j++){
                        res[index++] = matrix[startX][j];
                    }
                }

            }


            return res;

        }
    }

}
