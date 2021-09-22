package com.github.ysc972.alibaba;


import java.text.SimpleDateFormat;
import java.util.Date;


public class Alibaba003 {


    static class Product {

        int num;

        double price;

        Date date;


        Product(){}

        Product(int num, double price,Date date){
            this.num = num;
            this.price = price;
            this.date = date;
        }

    }

    static class Node{

        Product product;

        Node next;


        Node(){}

        Node(Product product){
            this.product = product;
        }
    }

    static class Worker{

        Node parent = null;


        int last = 0;


        public void put(Product product){
            last += product.num;

            Node newNode = new Node(product);
            if(parent == null){
                parent = newNode;
                return;
            }

            Node cur = parent;
            Node temp = new Node();
            temp.next = cur;
            Node pre = temp;
            while(cur != null && cur.product.date.compareTo(product.date) != 1  ){
                cur = cur.next;
                pre = pre.next;
            }


            pre.next = newNode;
            newNode.next = cur;

        }

        public void pop(Product product){
            if(last < product.num){
                throw new RuntimeException();
            }else{
                last -= product.num;
            }

            Node cur = parent;
            Node temp = new Node();
            temp.next = cur;
            Node pre = temp;
            int num = product.num;
            while ( cur != null && cur.product.date.compareTo(product.date) != 1 ){
                if(cur.product.num <= num){
                    num -= cur.product.num;
                    pre.next = cur.next;
                    if(cur == parent){
                        parent = cur.next;
                    }
                }else{
                    cur.product.num -= num;
                    num = 0;
                    return;
                }

                cur = cur.next;
                pre = pre.next;
            }

            if(cur == null)
                return;


        }


        public String[] calculate(){

            Node cur = parent;
            double result = 0;
            while (cur != null){

                result += (cur.product.num * cur.product.price);
                cur = cur.next;

            }

            return new String[]{last+"",result+""};


        }



    }

    public static void main (String[] args) throws Exception {
        Worker worker = new Worker();

        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd" );
        worker.put(new Product(1000, 1.5, sdf.parse("2021-01-01")));
        worker.put(new Product(1000, 2.1, sdf.parse("2021-01-05")));
        worker.put(new Product(1000, 1.7, sdf.parse("2021-01-07")));
        worker.put(new Product(1000, 1.1, sdf.parse("2021-01-09")));


        worker.pop(new Product(2500,2.2,sdf.parse("2021-01-08")));

        for (String s : worker.calculate()) {
            System.out.println(s);
        }

    }

}
