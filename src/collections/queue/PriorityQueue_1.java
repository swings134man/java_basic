package collections.queue;

import java.util.Collections;
import java.util.PriorityQueue;

/************
 * @info : 우선순위 queue
 * @name : PriorityQueue_1
 * @date : 11/5/23 11:31PM
 * @author : SeokJun Kang(swings134@gmail.com)
 * @version : 1.0.0
 * @Description : 우선순위 큐는 우선순위가 높은 데이터가 먼저 나오는 큐이다.
 * - 데이터가 들어가는 순서와 상관없이,
 *   우선 순위가 높은 데이터가 먼저 나가는 자료구조. -> Heap 자료구조를 통해서 구현 가능 하고, 다른자료구조를 통해서 구현 가능함.
 *
 ************/
public class PriorityQueue_1 {



    public static void main(String[] args) {

        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;

        // 기본형 - 우선순위가 낮은 숫자 부터 나온다.
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        pq1.offer(a);
        pq1.offer(b);
        pq1.offer(c);
        pq1.offer(d);

        while (!pq1.isEmpty()) {
            System.out.println("result = " + pq1.poll());
        }

        System.out.println("============== pq2 ==============");

        // 우선순위가 높은 숫자 부터 나온다.
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.offer(a);
        pq2.offer(b);
        pq2.offer(c);
        pq2.offer(d);

        while (!pq2.isEmpty()) {
            System.out.println("result = " + pq2.poll());
        }

    }//main
}
