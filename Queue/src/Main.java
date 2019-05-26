import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue();
        System.out.println("ArrayQueue, Time:" + testQueue(arrayQueue, opCount) + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println("LoopQueue, Time:" + testQueue(loopQueue, opCount) + "s");

    }

    /**
     * 测试使用q运行opCount个入队和出队的操作所需要的时间，单位:秒
     * @param queue 操作的队列
     * @param opCount 操作个数
     * @return 时间值
     */
    private static double testQueue(Queue<Integer> queue, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();

        for(int i = 0; i<opCount; i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for(int i = 0; i<opCount; i++){
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
