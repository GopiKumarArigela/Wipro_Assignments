import java.util.*;

public class Assignment6 {
    public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        List<String> customers = Arrays.asList("John", "Amy", "Alex", "David");
        for (String name : customers) {
            if (name.length() % 2 == 0) queue.addFirst(name);
            else queue.addLast(name);
        }
        System.out.println(queue);
    }
}