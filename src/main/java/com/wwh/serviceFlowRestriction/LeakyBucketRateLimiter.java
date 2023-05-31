package com.wwh.serviceFlowRestriction;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 漏桶 算法
 */
@Slf4j
public class LeakyBucketRateLimiter {

    // 桶的容量
    private int capacity;

    // 桶中现存水量
    private AtomicInteger water = new AtomicInteger(0);

    // 开始漏水时间
    private long leakTimeStamp;

    // 水流出的速率，即每秒允许通过的请求数
    private int leakRate;

    public LeakyBucketRateLimiter(int capacity, int leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
    }

    public synchronized boolean tryAcquire(){
        // 桶中没有水，重新开始计算
        if (water.get() == 0){
            colorPrintln("start leaking",32);
            leakTimeStamp = System.currentTimeMillis();
            water.incrementAndGet();
            return water.get() < capacity;
        }

        // 先漏水，计算剩余水量
        long currentTime = System.currentTimeMillis();
        int leakedWater = (int) ((currentTime - leakTimeStamp) / 1000 * leakRate);
        log.info("lastTime:{},currentTime:{},LeakedWater:{}",leakedWater,currentTime,leakedWater);

        // 可能时间不足，则先不漏水
        if (leakedWater != 0){
            int leftWater = water.get() - leakedWater;
            // 可能水已漏光，设为0
            water.set(Math.max(0,leftWater));
            leakTimeStamp = System.currentTimeMillis();
        }
        log.info("剩余容量：{}",capacity-water.get());

        if (water.get() < capacity){
            colorPrintln("tryAcquire success",34);
            water.incrementAndGet();
            return true;
        }else {
            colorPrintln("tryAcquire fail",33);
            return false;
        }
    }

    public static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }

}
