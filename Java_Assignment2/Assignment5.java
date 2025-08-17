import java.util.*;

public class Assignment5 {
    public static void main(String[] args) {
        LinkedList<String> apps = new LinkedList<>();
        List<String> opened = Arrays.asList("WhatsApp", "Chrome", "YouTube", "Chrome", "Gmail");
        for (String app : opened) {
            apps.remove(app);
            apps.addFirst(app);
        }
        System.out.println(apps);
    }
}