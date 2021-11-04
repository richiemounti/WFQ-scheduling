public class Packet {
    public float length;
    public float time;
    public int myQueue;
    public float delay;
    public int number;

    public Packet(int length, float arrivelTime, int q) {
        this.length = length;
        time = arrivelTime;
        myQueue = q;
    }
}