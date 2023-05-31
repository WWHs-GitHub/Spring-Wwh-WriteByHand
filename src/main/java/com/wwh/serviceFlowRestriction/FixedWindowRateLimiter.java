package com.wwh.serviceFlowRestriction;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 服务限流 - 固定窗口算法
 */
@Slf4j
public class FixedWindowRateLimiter {

    // 时间窗口大小，单位毫秒
    private long windowSize;

    // 允许通过请求数
    private int maxRequestCount;

    // 当前窗口通过的请求计数
    private AtomicInteger count = new AtomicInteger(0);

    // 窗口右边界
    private long windowBorder;

    public FixedWindowRateLimiter(long windowSize, int maxRequestCount) {
        this.windowSize = windowSize;
        this.maxRequestCount = maxRequestCount;
        windowBorder = System.currentTimeMillis() + windowSize;
    }

    public synchronized boolean tryAcquire(){
        long currentTime = System.currentTimeMillis();
        if (windowBorder < currentTime){
//            log.info("window reset");
            colorPrintln("window reset",34);
            do {
                windowBorder += windowSize;
            }while (windowBorder < currentTime);

            count = new AtomicInteger(0);
        }

        if (count.intValue() < maxRequestCount){
            count.incrementAndGet();
//            log.info("tryAcquire success");
            colorPrintln("tryAcquire success",32);
            return true;
        }else {
//            log.warn("tryAcquire fail");
            colorPrintln("tryAcquire fail",33);
            return false;
        }
    }

    public static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }
}
