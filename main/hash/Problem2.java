package main.hash;

import java.util.HashMap;

public class Problem2 {

    public static void main(String[] args) {

        String[] input1 = new String[]{"119", "97674223", "1195524421"};

        Solution solution = new Solution();

        System.out.println(Problem2.class.getSimpleName() + " - solution1");
        System.out.println("answer: " + solution.solution1(input1));

        return;
    }

    static class Solution {

        public Solution() {
        }

        public boolean solution1(String[] phone_book) {

            int iteration = phone_book.length;

            for (int i = 0; i < iteration; i++) {
                String number = phone_book[i];
                int len = phone_book[i].length();

                for (int j = 0; j < iteration; j++) {
                    if (i == j) continue;
                    if (number.length() > phone_book[j].length()) continue;

                    if (number.equals(phone_book[j].substring(0, len))) {
                        return false;
                    }
                }
            }
            return true;

        }

        public boolean solution2(String[] phone_book) {

            HashMap<String, Integer> map = new HashMap();
            for (String s : phone_book) {
                if (map.containsKey(s)) return false;
                map.put(s, s.length());
            }

            for (int i = 0 ; i < phone_book.length ; i++) {
                String number = phone_book[i];
                for (int j = 1 ; j <= number.length() ; j++) {
                    map.remove(number);
                    if (map.containsKey(number.substring(0, j))) {
                        return false;
                    }
                    map.put(number, number.length());
                }
            }

            return true;
        }

    }

}