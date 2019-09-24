package CollectionsInDepth.Queues;

import java.util.PriorityQueue;
import java.util.Random;

public class RandomQueueWithOrdering {
    public static void main(String[] args) {
        PriorityQueue<RandomIntHolder> queue = new PriorityQueue<>();
        for (int i = 0; i < 100; i++) {
            boolean insertionResult = queue.offer(new RandomIntHolder());

        }
        System.out.println(queue);
        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }
        queue.hashCode();
    }



}


class RandomIntHolder implements Comparable<RandomIntHolder> {
    public Integer value;
    Random random = new Random();
    public RandomIntHolder() {
        this.value = random.nextInt(100);
    }

    @Override
    public int compareTo(RandomIntHolder o) {
        if (value < o.value) {
            return 1;
        } else if (value > o.value) {
            return -1;
        } else if (value == o.value){
          return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
