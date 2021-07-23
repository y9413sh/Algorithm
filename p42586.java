package src.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 문제 출처: 프로그래머스
// URL: https://programmers.co.kr/learn/courses/30/lessons/42586

public class p42586 {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<progresses.length; i++) {
            q.add((int)Math.ceil((100-progresses[i])/(double)speeds[i]));
        }

        List<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()) {
            int day = q.poll();
            int cnt = 1;
            while(!q.isEmpty() && (int)day >= (int)q.peek()) {
                cnt++;
                q.poll();
            }
            answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}