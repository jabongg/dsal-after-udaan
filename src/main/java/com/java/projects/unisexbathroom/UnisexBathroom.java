package com.java.projects.unisexbathroom;

import java.util.concurrent.Semaphore;

public class UnisexBathroom {

    public enum sex {WOMEN, MEN, NONE}

    // semaphore limiting to 3 employees at max at a time.
    Semaphore maxEmployeesAtATime = new Semaphore(3);

    String inUseBy = sex.NONE.name();
    int employeesInBathroom = 0; // at max 3 employees can be under bathroom at a time.

    public void maleUseBathroom(String name) throws InterruptedException {
        synchronized (this) {
            while (inUseBy.equals(sex.WOMEN.name())) {

                // the wait call will give the monitor associated with the object,
                // giving other threads a chance to aquire it.
                this.wait();
            }

            // acquire permit from semaphore
            maxEmployeesAtATime.acquire();
            employeesInBathroom++;
            inUseBy = sex.MEN.name();
        }

        useBathroom(name);
        //Releases a permit, returning it to the semaphore.
        maxEmployeesAtATime.release();

        synchronized (this) {
            employeesInBathroom--;
            if (employeesInBathroom == 0) {
                inUseBy = sex.NONE.name();
            }

            // Since we might have just updateded the value of
            // inUseBy, we should notifyAll waiting threads
            this.notifyAll();
        }

    }

    public void femaleUseBathroom(String name) throws InterruptedException {

        synchronized (this) {
            while (inUseBy.equals(sex.MEN.name())) {
                // the wait call will give the monitor associated with the object,
                // giving other threads a chance to aquire it.
                this.wait();
            }

            maxEmployeesAtATime.acquire();
            employeesInBathroom++;
            inUseBy = sex.WOMEN.name();
        }

        useBathroom(name);
        maxEmployeesAtATime.release();

        synchronized (this) {
            employeesInBathroom--;

            if (employeesInBathroom == 0) {
                inUseBy = sex.NONE.name();
            }

            // Since we might have just updated the value of
            // inUseBy, we should notifyAll waiting threads
            this.notifyAll();
        }
    }

    public void useBathroom(String name) throws InterruptedException {
        System.out.println(name + " using bathroom. Current employees in bathroom = " + employeesInBathroom);
        Thread.sleep(3000); // for 10 seconds
        System.out.println(name + " is done using bathroom");
    }


    public static void runTest() throws InterruptedException {

        final UnisexBathroom unisexBathroom = new UnisexBathroom();
        Thread female1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    unisexBathroom.femaleUseBathroom("Lisa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread male1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("John");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread male2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Bob");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread male3 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Anil");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread male4 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Wentao");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        female1.start();
        male1.start();
        male2.start();
        male3.start();
        male4.start();

        female1.join();
        male1.join();
        male2.join();
        male3.join();
        male4.join();
    }

}
