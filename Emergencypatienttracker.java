import java.util.*;

class Patient {
    String name;
    int severity;
    long time;
    Patient(String name, int severity, long time) {
        this.name = name;
        this.severity = severity;
        this.time = time;
    }
    public String toString() {
        return name + "(" + severity + ")";
    }
}

public class Emergencypatienttracker {
    public static void main(String[] args) {
        PriorityQueue<Patient> pq = new PriorityQueue<>(Comparator.comparingInt((Patient p) -> p.severity).thenComparingLong(p -> p.time));
        pq.add(new Patient("A", 2, System.nanoTime()));
        pq.add(new Patient("B", 1, System.nanoTime()));
        pq.add(new Patient("C", 1, System.nanoTime()));
        while (!pq.isEmpty()) System.out.println(pq.poll());
    }
}