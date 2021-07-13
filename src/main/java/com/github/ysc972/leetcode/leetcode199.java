package com.github.ysc972.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode199 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {

            Queue<TreeNode> queue = new LinkedList<>();


            List<Integer> res = new LinkedList<>();
            if(root != null){
                queue.add(root);
            }

            while (!queue.isEmpty()){

                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode node = queue.poll();

                    if(i == size - 1)
                        res.add(node.val);

                    if(node.left != null)
                        queue.add(node.left);
                    if(node.right != null)
                        queue.add(node.right);
                }


            }

            return res;



        }
    }




}
