package demo11_priorityQueue;

public class Entry implements Priority{
    int priority;
    String value;

    public Entry(int priority, String value) {
        this.priority = priority;
        this.value = value;
    }

    @Override
    public int priority() {
        return this.priority;
    }

    @Override
    public String toString() {
        return  "priority=" + priority +
                ", value='" + value ;
    }
}
