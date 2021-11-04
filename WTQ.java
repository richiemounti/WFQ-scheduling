import java.util.ArrayList;
import java.util.Queue;


public class WTQ {
    public Q q1,q2,q3;
    public float sr;
    @SuppressWarnings("unused")
    private boolean busy;
    public boolean queuesAreEmpty;
    public ArrayList<String>SortedDepartureTime;

    public WTQ(int w1,int s1,int w2, int s2, int w3, int s3, float sr) {
        this.sr = sr;
        queuesAreEmpty = true;
        this.q1 = new Q(w1, s1);
        this.q2 = new Q(w2, s2);
        this.q3 = new Q(w3, s3);
        SortedDepartureTime = new ArrayList<String>();
    }

    public void enterPacket(String x) {
        String userInput[] = x.split(",");
        int packetLength = Integer.parseInt(userInput[0]);
        float arrivalTime = Float.valueOf(userInput[1]);
        int arrivalQueue = Integer.parseInt(userInput[2]);
        Packet p = new Packet(packetLength, arrivalTime, arrivalQueue);
        if(arrivalQueue == 1){
            p.number = q1.getQueue().size()+1;
            q1.getQueue().add(p);
        }
        else if(arrivalQueue == 2){
            p.number = q2.getQueue().size()+1;
            q2.getQueue().add(p);
        }
        else {
            p.number = q3.getQueue().size()+1;
            q3.getQueue().add(p);
        }
        queuesAreEmpty = false;
    }

    public Queue<Packet> getQueue(int N) {
        if(N == 1)
            return q1.getQueue();
        else if(N == 2)
            return q2.getQueue();
        else
            return q3.getQueue();
    }
    public Q getHeighestQueue(){
		if(q1.Weight > q2.Weight && q1.Weight > q3.Weight)
			return q1;
		else if(q2.Weight > q1.Weight && q2.Weight > q3.Weight)
			return q2;
		else 
			return q3;
	}
    public Q getMiddleQueue(){
		if(q1.Weight < this.getHeighestQueue().Weight && q1.Weight > this.getLeastQueue().Weight)
			return q1;
		else if(q2.Weight < this.getHeighestQueue().Weight && q2.Weight > this.getLeastQueue().Weight)
			return q2;
		else 
			return q3;
	}
	public Q getLeastQueue(){
		if(q1.Weight < q2.Weight && q1.Weight < q3.Weight)
			return q1;
		else if(q2.Weight < q1.Weight && q2.Weight < q3.Weight)
			return q2;
		else 
			return q3;
	}
	public float finishtag() {
		return 0;
	}
}
