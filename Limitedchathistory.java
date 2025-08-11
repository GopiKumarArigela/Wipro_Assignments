import java.util.*;

public class Limitedchathistory {
    public static void main(String[] args) {
        ArrayDeque<String> chat = new ArrayDeque<>();
        List<String> msgs = Arrays.asList("Hi", "How", "Are", "You", "Today");
        for (String m : msgs) {
            if (chat.size() == 4) chat.removeFirst();
            chat.addLast(m);
        }
        System.out.println(chat);
    }
}