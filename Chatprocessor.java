import java.util.concurrent.*;

public class Chatprocessor {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> buffer = new LinkedBlockingQueue<>(5);
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    buffer.put("Msg" + i);
                    System.out.println("Added Msg" + i);
                } catch (InterruptedException e) {}
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    System.out.println("Read " + buffer.take());
                } catch (InterruptedException e) {}
            }
        });
        producer.start();
        consumer.start();
    }
}