package com.github.ysc972.alibaba;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Alibaba001 {


    private static Random random = new Random();


    static class Account {

        int  id ;

        int balance = 50;

        Account(int id){
            this.id = id;
        }

        public synchronized void transfer(Account to,int num){
            if(decrease(num)){
                to.increase(num);
            }
        }

        public synchronized boolean increase(int num){
            this.balance += num;
            return true;
        }
        public synchronized boolean decrease(int num){
            if(this.balance < num){
                return false;
            }
            this.balance -= num;
            return true;
        }

    }


    public static void main(String[] args) {

        List<Account> list = new ArrayList<>();
        List<TransferThread> threads = new ArrayList<>();
        IntStream.range(0,20)
                .mapToObj((item)-> new Account(item))
                .forEach(list::add);
        IntStream.range(0,20)
                .mapToObj((i)->new TransferThread(list))
                .forEach(threads::add);
        threads.forEach((item)->{
            item.start();
        });
        threads.forEach((item)->{
            try {
                item.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        list.stream().forEach((account -> {
            System.out.printf(" %s account balance %d \n",account.id,account.balance);
        }));
        int result = list.stream().mapToInt(account -> account.balance).sum();
        System.out.println(result);

    }


    static class TransferThread extends Thread{

        private List<Account> list;

        TransferThread(List<Account> list){
            this.list = list;
        }

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                while(true){
                    int from =  random.nextInt(20);
                    int to = random.nextInt(20);
                    if(from == to)
                        continue;
                    Account fromAccount = list.get(from);
                    Account toAccount = list.get(to);
                    int transferNum = random.nextInt(100);
                    fromAccount.transfer(toAccount,transferNum);
                    break;
                }
            }
        }
    }




}
