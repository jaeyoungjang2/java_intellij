package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class prepareTestQStack2_1 {

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;

        while(!que.isEmpty()){
            // 값을 하나씩 큐에서 빼내고
            Integer i = que.poll();
            System.out.println(l);
            System.out.println(i);
            System.out.println();
            // 빼낸 값이 가장 큰 값과 동일하다면
            // 가장 큰 값을 다음 큰 값으로 변경하고
            if(i == priorities[size - answer]){
                System.out.println("HI");
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        System.out.println(answer);
    }
}
