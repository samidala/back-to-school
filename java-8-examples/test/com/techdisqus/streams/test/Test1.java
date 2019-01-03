package com.techdisqus.streams,test;

import java.util.concurrent.ForkJoinPool;

public class Test1 {


    static Runnable task =  new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() +  " before waiting");
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() +  " after waiting");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " start");
        new Thread(task,"created").start();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(task);//Here you can see the thread submitted to ForkJoinPool does not print  "after waiting"
        System.out.println(Thread.currentThread().getName() + " end");


    }

}

/**
***Here you can see the thread submitted to ForkJoinPool does not print  "after waiting"***
Output of above code is shown below:
main start
created before waiting
ForkJoinPool-1-worker-3 before waiting
main end
created after waiting

Process finished with exit code 0


*/
