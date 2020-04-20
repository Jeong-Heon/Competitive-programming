package main.heap;

import java.util.Arrays;
import java.util.PriorityQueue;


public class Problem2 {

    public static void main(String[] args) {

        int stock = 4;
        int[] dates = new int[]{4, 10, 5};
        int[] supplies = new int[]{20, 5, 10};
        int k = 30;

        Solution solution = new Solution();

        System.out.println(Problem2.class.getSimpleName() + " - solution");
        System.out.println("answer: " + solution.solution(stock, dates, supplies, k));

        return;
    }

    static class Solution {

        public Solution() {
        }

        public int solution(int stock, int[] dates, int[] supplies, int k) {

            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            int total = stock;
            int cnt = 0;
            int i = 0;

            if (total == dates[0]) {
                total += supplies[0];
                cnt++;
                i++;
            }

            while (total < k) {
                while (i < dates.length) {
                    if (total > dates[i]) {
                        pq.add(supplies[i]);
                        i++;
                        continue;
                    }
                    break;
                }
                // 보급
                total += pq.poll();
                cnt++;
            }

            return cnt;

        }

    }

}