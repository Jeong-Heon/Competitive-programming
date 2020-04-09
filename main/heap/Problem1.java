package main.heap;

import java.util.*;


public class Problem1 {

    public static void main(String[] args) {

        int[] scoville = new int[]{1, 10, 3, 9, 2, 12};
        int K = 7;

        Solution solution = new Solution();

        System.out.println(Problem1.class.getSimpleName() + " - solution1");
        System.out.println("answer: " + solution.solution(scoville, K));

        return;
    }

    static class Solution {

        public Solution() {
        }

        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int sc : scoville) {
                pq.add(sc);
            }
            int initSize = pq.size();
            while(pq.size() > 1) {
                pq.add(pq.poll() + (pq.poll() * 2));
                if (pq.peek() >= K) return initSize - pq.size();
            }
            return -1;
        }

    }

}