package com.java.basics.threads;

public class AlphaNumericPrint {
    boolean flag;

    AlphaNumericPrint(boolean flag) {
        this.flag = flag;
    }

    synchronized void alpha() throws InterruptedException {
        for (char i = 'A'; i <= 'Z'; i++) {
            while (flag == true) {
                wait();
            }
            System.out.println(i);
            notifyAll();
            flag = true;
        }
    }

    synchronized void numeric() throws InterruptedException {
        for (int i = 1; i <= 26; i++) {
            while (flag == false) {
                wait();
            }
            System.out.println(i);
            notifyAll();
            flag = false;
        }
    }

    public static void main(String[] args) {
        AlphaNumericPrint an = new AlphaNumericPrint(false);
        Thread alpha = new Thread(() -> {
            try {
                an.alpha();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread numeric = new Thread(() -> {
            try {
                an.numeric();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        alpha.start();
        numeric.start();
    }
}