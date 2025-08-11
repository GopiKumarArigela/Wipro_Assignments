import java.util.*;

class Job {
    String name;
    int urgency;
    Job(String name, int urgency) {
        this.name = name;
        this.urgency = urgency;
    }
    public String toString() {
        return name + "(" + urgency + ")";
    }
}

public class Smartjobpicker {
    public static void main(String[] args) {
        PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt((Job j) -> j.urgency).thenComparingInt(j -> j.name.length()));
        pq.add(new Job("Fix", 2));
        pq.add(new Job("Clean", 1));
        pq.add(new Job("Paint", 1));
        while (!pq.isEmpty()) System.out.println(pq.poll());
    }
}