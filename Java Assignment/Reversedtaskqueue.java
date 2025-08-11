import java.util.*;

public class Reversedtaskqueue {
    public static void main(String[] args) {
        LinkedList<String> tasks = new LinkedList<>();
        List<String> input = Arrays.asList("ReadI", "Write", "PlayI", "Cook");
        for (String task : input) {
            if (task.endsWith("I")) tasks.addFirst(task);
            else tasks.addLast(task);
        }
        Collections.reverse(tasks);
        System.out.println(tasks);
    }
}