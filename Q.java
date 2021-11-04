import java.util.LinkedList;
import java.util.Queue;

public class Q {
    public int Weight;   // Weight of the Queue
    public int Size;     // Size of the Queue
    private Queue<Packet> Queue;    // The Packets Queue
    public int number;
    
    public Q(int w, int s) {
        Weight = w;
        Size = s;
        Queue = new LinkedList<Packet>();
        number = 0;
    }

    public Queue<Packet> getQueue() {
        return Queue;
    }

    public void setQueue(Queue<Packet> queue) {
        Queue = queue;
    }

    public String display() {
        return "Weight: " +this.Weight+" Size: "+this.Size+" number of packets: "+this.number;
    }
}
