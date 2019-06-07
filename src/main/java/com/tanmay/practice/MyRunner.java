package com.tanmay.practice;

public class MyRunner implements Runnable {
    @Override public void run() {
        int[] test = new int[]{1};
        System.out.println(test[2]);
        throw new RuntimeException("test");

    }

    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();
        t.run();
        //System.out.println(t.getStackTrace().toString());
        System.out.println("Thread running?");
    }
}
