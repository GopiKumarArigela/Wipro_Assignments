import java.util.concurrent.*;

public class Assignment9 {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.offer("Job1");
        queue.offer("Job2");
        queue.offer("Job3");
        queue.offer("Job4");
        while (!queue.isEmpty()) System.out.println(queue.poll());
    }
}