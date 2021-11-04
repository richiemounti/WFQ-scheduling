import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class mainNetwork {
    static Packet p1;
     static Packet p2;
     static Packet p3;
     static float currentTime;
     static Q heighestWeight;
     static Q secHeighestWeight;
     static Q leastWeight;
	public static void main(String[] args) throws IOException {
        boolean First=true;
		String x="";
		System.out.println("enter the three queues weight followed by the size using ',' and the Service Rate");
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in)); 
        String[] Int =b.readLine().split(","); 
        WTQ Network= new WTQ(Integer.parseInt(Int[0]),Integer.parseInt(Int[1]),
                Integer.parseInt(Int[2]),Integer.parseInt(Int[3]),Integer.parseInt(Int[4]),
        		Integer.parseInt(Int[5]),Float.valueOf(Int[6]));
        heighestWeight = Network.getHeighestQueue(); 
        secHeighestWeight = Network.getMiddleQueue();
        leastWeight = Network.getLeastQueue();
        System.out.println("Enter the packet size and arrival time and the which queue using ','in between");
        while(true) {   
        	b = new BufferedReader(new InputStreamReader(System.in));  		
        	if(b.ready()) {
        		
        		x=b.readLine();
        		if(x.toLowerCase().equals("finish")) {		//If there is no more packets
        			break;
        		}else if(x.contains(",")){
        			System.out.println("Enter the packet size and arrival"
        					+ " time and which queue to be added to ','in between");
        			Network.enterPacket(x);
      	         }}}
        currentTime=0;
        while(Network.queuesAreEmpty == false){		//If the queues aren't empty
        	if(Network.getQueue(1).isEmpty() & Network.getQueue(2).isEmpty() & Network.getQueue(3).isEmpty()) 
        		Network.queuesAreEmpty = true;
        	else {
        		if(!heighestWeight.getQueue().isEmpty())
        	p1 = heighestWeight.getQueue().peek();
        		else
        			p1 = new Packet(1, 1000000000, 1);
        		if(!secHeighestWeight.getQueue().isEmpty())
        	p2 = secHeighestWeight.getQueue().peek();
        		else
        			p2 = new Packet(2, 1000000000, 2);
        		if(!leastWeight.getQueue().isEmpty())
        	p3 = leastWeight.getQueue().peek();
            		else
            			p3 = new Packet(3, 1000000000,3);
        	
          if(p1.time <= p2.time && p1.time <= p3.time){	
        	  if(currentTime<p1.time) {
      	    	currentTime=p1.time;
                  First=false;
                  }	   
        	    p1.delay=currentTime-p1.time;
        		System.out.println("delay of " + "(" + p1.myQueue + "," + p1.number+ ") is: " + p1.delay);
        		currentTime = currentTime +(p1.length / Network.sr);
        		heighestWeight.getQueue().remove();
        	    Network.SortedDepartureTime.add("("+p1.myQueue+","+p1.number+")"+"received at "+currentTime); 
        	  
           }
        	else if(p2.time < p1.time && p2.time <= p3.time){
        		  if(First==true) {
          	    	currentTime=p2.time;
                      First=false;
                      }
        		p2.delay=currentTime-p2.time;
        		System.out.println("delay of " + "(" + p2.myQueue + "," + p2.number + ") is: " + p2.delay);
        		currentTime = currentTime +(p2.length / Network.sr);
        		secHeighestWeight.getQueue().remove();
        		Network.SortedDepartureTime.add("(" + p2.myQueue + "," + p2.number + ")" + "received at " + currentTime); 
        	}
        	else if(p3.time < p1.time && p3.time < p2.time){
        		  if(First==true) {
          	    	currentTime=p3.time;
                      First=false;
                      }
        		p3.delay=currentTime-p3.time;
        		System.out.println("delay of " + "(" + p3.myQueue + "," + p3.number + ") is: " + p3.delay);
        		currentTime = currentTime +(p3.length / Network.sr);
        		leastWeight.getQueue().remove();
        		Network.SortedDepartureTime.add("(" + p3.myQueue + "," + p3.number+")" + "received at " + currentTime); 
        	}
          if(Network.getQueue(1).isEmpty() && Network.getQueue(2).isEmpty() && Network.getQueue(3).isEmpty()) 
      		Network.queuesAreEmpty = true;
        	}
        }
        for(int i=0;i<Network.SortedDepartureTime.size();i++)
        	System.out.println(Network.SortedDepartureTime.get(i));
        }    
}
