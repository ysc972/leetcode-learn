package com.github.ysc972.leetcode;

public class leetcode059 {

    public static void main(String[] args) {
        new Solution().generateMatrix(6);
    }


    static class Solution {
        public int[][] generateMatrix(int n) {

            int[][] res = new int[n][n];
            int startX = 0;
            int startY = 0;
            int count = 1;
            int offset = 1;
            int loop = n / 2;

            for(int k = 0; k < loop; k++){
                int j = startY;
                int i = startX;
                for(; j < n  -offset; j++){
                    res[startX][j] = count++;
                }

                for(; i < n  -offset; i++){
                    res[i][j] = count++;
                }
                for(;j > startY ; j-- ){
                    res[i][j] = count++;
                }
                for(;i > startX ; i--){
                    res[i][startY] = count++;
                }

                startX++;
                startY++;
                offset++;
            }

            if(n % 2 ==1){
                res[n/2][n/2]=count++;
            }


            return res;

        }
    }
}
