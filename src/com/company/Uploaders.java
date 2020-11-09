package com.company;

import java.util.concurrent.CountDownLatch;

public class Uploaders extends Thread {
    private CountDownLatch ad;
    private int size = 500;

    public Uploaders(CountDownLatch ad) {
        this.ad = ad;
    }

    @Override
    public void run() {
        try {
            System.out.println("Началась загрузка файла из сервера ");
            sleep(2000);
            System.out.println("Загрузка завершена ");
            ad.countDown();
        } catch (Exception ignore){
        }
    }
}
