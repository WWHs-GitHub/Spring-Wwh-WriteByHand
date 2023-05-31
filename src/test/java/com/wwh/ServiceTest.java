package com.wwh;

import com.google.common.util.concurrent.RateLimiter;
import com.wwh.serviceFlowRestriction.FixedWindowRateLimiter;
import com.wwh.serviceFlowRestriction.LeakyBucketRateLimiter;
import com.wwh.serviceFlowRestriction.SlidingWindowRateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * 服务限流 - 算法测试类
 */
@Slf4j
public class ServiceTest {

    @Test
    void test() throws InterruptedException {
        FixedWindowRateLimiter fixedWindowRateLimiter = new FixedWindowRateLimiter(1000, 5);

        for (int i = 0; i < 10; i++) {
            if (fixedWindowRateLimiter.tryAcquire()){
                System.out.println("执行任务");
            }else {
                System.out.println("被限流");
                TimeUnit.MILLISECONDS.sleep(300);
            }
        }
    }

    @Test
    void test2() throws InterruptedException {
        SlidingWindowRateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(1000, 10, 10);
        TimeUnit.MILLISECONDS.sleep(800);

        for (int i = 0; i < 15; i++) {
            boolean acquire = slidingWindowRateLimiter.tryAcquire();
            if (acquire){
                System.out.println("执行任务");
            }else {
                System.out.println  ("被限流");
            }
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }

    @Test
    void test3() throws InterruptedException {
        LeakyBucketRateLimiter leakyBucketRateLimiter = new LeakyBucketRateLimiter(3, 1);
        for (int i = 0; i < 15; i++) {
            if (leakyBucketRateLimiter.tryAcquire()) {
                System.out.println("执行任务");
            }else {
                System.out.println  ("被限流");
            }
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }

    /**
     * 令牌桶算法
     */
    @Test
    void acquireTest(){
        RateLimiter rateLimiter = RateLimiter.create(5);
        for (int i = 0; i < 10; i++) {
            double time = rateLimiter.acquire();
            log.info("等待时间：{}s",time);
        }
    }

    /**
     * 令牌桶算法 - 预消费
     */
    @Test
    void acquireMultiTest(){
        RateLimiter rateLimiter = RateLimiter.create(1);

        for (int i = 0; i < 3; i++) {
            int num = 2 * i + 1;
            log.info("获取{}个令牌",num);
            double cost = rateLimiter.acquire(num);
            log.info("获取{}个令牌结束，耗时{}ms",num,cost);
        }
    }

    /**
     * 令牌桶算法 - 平滑预热
     */
    @Test
    void acquireSmoothly(){
        RateLimiter rateLimiter = RateLimiter.create(5, 3, TimeUnit.SECONDS);
        long startTimeStamp = System.currentTimeMillis();
        for (int i = 0; i < 15; i++) {
            double time = rateLimiter.acquire();
            log.info("等待时间:{}s,总时间:{}ms",time,System.currentTimeMillis() - startTimeStamp);
        }
    }
}
