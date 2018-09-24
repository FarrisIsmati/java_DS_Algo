package com.heap;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        Heap pq = new Heap(10);

        //PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.insert(25);
        pq.insert(-22);
        pq.insert(1343);
        pq.insert(54);
        pq.insert(0);
        pq.insert(-3492);
        pq.insert(429);

        pq.sort();
        pq.printHeap();

//        heap.insert(80);
//        heap.insert(75);
//        heap.insert(68);
//        heap.insert(55);
//        heap.insert(40);
//        heap.insert(52);
//        heap.insert(67);
//        heap.printHeap();
//        heap.delete(0);
//        System.out.println(heap.peek());
    }

}
