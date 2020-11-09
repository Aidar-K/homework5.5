package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloaders extends Thread {
    private int size = 500;
    private int speed = 100;
    private Semaphore semaphore;
    private CountDownLatch downloaders;
    private CountDownLatch uploaders;

    public Downloaders(String name, Semaphore semaphore, CountDownLatch downloaders, CountDownLatch uploaders) {
        super(name);
        this.semaphore = semaphore;
        this.downloaders = downloaders;
        this.uploaders = uploaders;
    }

    @Override
    public void run() {
        try {
            uploaders.await();
            semaphore.acquire();
            System.out.println(getName() + "Начал скачивать");
            sleep(size/speed*100);
            System.out.println(getName()+"Скачал");
            semaphore.release();
            downloaders.countDown();

        } catch (Exception ignore){

        }
    }
}
