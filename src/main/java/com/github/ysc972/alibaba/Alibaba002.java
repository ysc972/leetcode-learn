package com.github.ysc972.alibaba;

public class Alibaba002 {

    class Node {

        int val;

        Node left;

        Node right;

    }

    public boolean exist(Node root , int target){
       if(root == null)
           return target == 0;

       return exist(root.left,target - root.val) || exist(root.right,target - root.val);
    }


}
