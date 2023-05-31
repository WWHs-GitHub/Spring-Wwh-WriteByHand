package com.wwh.likou;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.TimeUnit;

/**
 * 滑动窗口算法
 */
public class SlidingWindow {

    /**
     * 最小覆盖子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[] hash = new int[256]; // ASCII 字符集共包含256个字符，因此使用长度为256的数组来记录窗口中每个字符出现的次数。
        for (char c : t.toCharArray()) {
            hash[c]++;
        }

        int left = 0, right = 0, count = t.length(), start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            if (hash[s.charAt(right)] > 0) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            while (count == 0) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                if (hash[s.charAt(left)] == 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    /**
     * 长度最小的子数组
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, len = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                len = Math.min(len, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) {
        System.out.println(new SlidingWindow().minWindow("aaaaadgbc", "dbc"));
        System.out.println(new SlidingWindow().minSubArrayLen(5, new int[]{1, 3, 4, 2}));
//        ResponseEntity.ok().cacheControl(CacheControl.maxAge(3, TimeUnit.SECONDS)).body("hello world");
    }
}
