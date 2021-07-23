package src.programmers;

import java.util.Collections;
import java.util.PriorityQueue;

// 문제 출처: 프로그래머스
// URL: https://programmers.co.kr/learn/courses/30/lessons/42587

public class p42587 {

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : priorities) {
            q.offer(i);
        }
        
        while(!q.isEmpty()) {       
            for(int j=0; j<priorities.length; j++) {
                if(q.peek() == priorities[j]) {
                    q.poll();
                    answer++;
                    if(j==location) {
                        q.clear();
                        break;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,9,1,1,1};
        
        System.out.println(solution(arr, 0));
    }
}