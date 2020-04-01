package main.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Problem1 {

    public static void main(String[] args) {

        String[] input1 = new String[]{"leo", "leo", "kiki", "eden"};
        String[] input2 = new String[]{"leo", "leo", "eden"};

        Solution solution = new Solution();

        System.out.println(Problem1.class.getSimpleName() + " - solution1");
        System.out.println("answer: " + solution.solution1(input1, input2));

        System.out.println(Problem1.class.getSimpleName() + " - solution2");
        System.out.println("answer: " + solution.solution2(input1, input2));

        return;
    }

}

class Solution {

    public Solution() {
    }

    public String solution1(String[] participant, String[] completion) {

        List<String> sortedParticipant = Arrays.asList(participant);
        sortedParticipant.sort(String::compareTo);

        List<String> sortedCompletion = Arrays.asList(completion);
        sortedCompletion.sort(String::compareTo);

        for (int i = 0; i < sortedCompletion.size(); i++) {
            if (sortedParticipant.get(i).equals(sortedCompletion.get(i))) {
                continue;
            } else {
                return sortedParticipant.get(i);
            }
        }

        return sortedParticipant.get(sortedParticipant.size() - 1);

    }

    // use HashMap
    public String solution2(String[] participant, String[] completion) {

        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : participant) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            hashMap.put(s, hashMap.get(s) - 1);
        }

        for (String s : hashMap.keySet()) {
            if (hashMap.get(s) != 0) {
                answer = s;
                break;
            }
        }

        return answer;

    }

}
