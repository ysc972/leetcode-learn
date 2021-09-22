package com.github.ysc972.hw;



import java.util.*;
public class Hw004 {


    static class Node {

        int val;

        Node left;

        Node right;

    }


    public static Node buildTree(){

        Node root = new Node();

        root.val = 1;

        Node left = new Node();

        left.val = 2;
        root.left = left;

        Node right = new Node();

        right.val = 3;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {

        Node root = buildTree();


        List res = new Hw004().left(root);


        System.out.println(res);

    }




    public List<Integer> left(Node root){

        List<Integer> res = new ArrayList<>();


        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node temp = queue.poll();
                if(temp != null){
                    if(i == 0){
                        res.add(temp.val);
                    }
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
            }
        }

        return res;

    }


}
