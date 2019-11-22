package com.owner.backproject.restful.userManager;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class TestThread {

    private static final ExecutorService pools = Executors.newFixedThreadPool(10);

    public static void main(String[] args){

        pools.execute(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("===" + i);
                }
            }
        });

    }
}
