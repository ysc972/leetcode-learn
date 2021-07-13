package com.github.ysc972.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class leetcode102 {





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
        public List<List<Integer>> levelOrder(TreeNode root) {

            Queue<TreeNode> queue = new ArrayDeque<>();
            List<List<Integer>> res =new ArrayList<>();
            if(root != null){
                queue.add(root);
            }

            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    if(node == null)
                        continue;
                    queue.add(node.left);
                    queue.add(node.right);
                    list.add(node.val);
                }
                res.add(list);
            }

            return res;
        }
    }
}
