package com.github.ysc972.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode429 {





// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            Queue<Node> queue = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if(root != null){
                queue.add(root);
            }
            while (!queue.isEmpty()){
                int size = queue.size();
                List<Integer> list = new ArrayList<>();
                for(int i = 0; i < size; i++){
                    Node node = queue.poll();
                    list.add(node.val);
                    if(node.children !=null){
                        for (Node child : node.children) {
                            queue.add(child);
                        }
                    }

                }
                res.add(list);

            }
            return res;
        }
    }

}
