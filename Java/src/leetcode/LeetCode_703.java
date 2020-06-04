package leetcode;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class LeetCode_703 {

    class KthLargest {

        private int k;
        private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for(int n: nums){
                priorityQueue.offer(n);
            }
        }

        public int add(int val) {
            priorityQueue.offer(val);
            while(k < priorityQueue.size()){
                priorityQueue.poll();
            }
            return priorityQueue.peek();
        }
    }
}


