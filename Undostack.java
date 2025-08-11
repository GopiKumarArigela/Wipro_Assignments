import java.util.*;

public class Undostack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Cmd1");
        stack.push("Cmd2");
        stack.push("Cmd3");
        String undo = stack.pop();
        stack.push(undo);
        System.out.println(stack);
    }
}