import java.util.*;

public class Grocerylineshuffle {
    public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        List<String> customers = Arrays.asList("John", "jhonny", "hony", "bob");
        for (String name : customers) {
            if (name.length() % 2 == 0) queue.addFirst(name);
            else queue.addLast(name);
        }
        System.out.println(queue);
    }
}