package com.github.ysc972.offer;

import java.util.ArrayList;
import java.util.List;


/**
 *
 *  二维矩阵 查找
 *
 */
public class offer004 {


    public static void main(String[] args) {

//        System.out.println(new Solution().find(new int[]{1, 3, 5, 7, 9, 12, 34}, 9));

        System.out.println(new Solution1().findNumberIn2DArray(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 13));

    }

    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {


            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                if(matrix[i][0] > target ){
                    break;
                }
                list.add(i);
            }
            for (int i : list) {

                if(find(matrix[i],target)){
                    return true;
                }
            }
            return false;
        }

        private boolean find(int[] matrix,int target) {

            int right = matrix.length -1;
            int left = 0;
            while (left <= right ){
                int mid = left + (right - left) / 2;
                if(matrix[mid] == target)
                    return true;
                if(matrix[mid] > target){
                    right = --mid;
                }else {
                    left = ++mid;
                }
            }

            return false;

        }
    }
    static class Solution1 {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int m = matrix.length ;
            if(m == 0){
                return false;
            }
            m--;
            int n = 0;
            while (m >=0 && n < matrix[0].length){
                if(matrix[m][n] > target){
                    m--;
                }else if(matrix[m][n] < target){
                    n++;
                }else {
                    return true;
                }
            }

            return false;

        }


    }
}
