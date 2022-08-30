package com.java.interview.airtelafrica;

public class AirtelAftica {
    //t1 1-3-5
    // /t2 2-4-6


    int counter = 1;
    static int N = 10;


    private void printEven() throws InterruptedException {
        synchronized (this) {
            while (counter < N) {

                while (counter % 2 == 0)
                    wait();

                System.out.println(counter);
                counter++;
                notify();
            }
        }
    }

    private void printOdd() throws InterruptedException {

        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 1)
                    wait();

                System.out.println(counter);
                counter++;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        AirtelAftica af = new AirtelAftica();

        // t1 for odd
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    af.printOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        // t2 for even
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    af.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        t1.start();
        t2.start();
    }

}
