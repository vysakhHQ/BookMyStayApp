import java.util.*;
class Reservation{
    String name,type;
    Reservation(String n,String t){
        name=n;
        type=t;
    }
}
class BookingRequestQueue{
    Queue<Reservation> q=new LinkedList<>();
    void add(Reservation r){
        q.add(r);
    }
    Reservation get(){
        return q.poll();
    }
}
class RoomInventory{
    HashMap<String,Integer> map=new HashMap<>();
    RoomInventory(){
        map.put("Single",1);
        map.put("Double",1);
    }
    void allocate(String type){
        if(map.get(type)>0){
            map.put(type,map.get(type)-1);
            System.out.println("Allocated "+type);
        }else{
            System.out.println("No "+type+" rooms");
        }
    }
}
class RoomAllocationService{
    void allocateRoom(Reservation r,RoomInventory inv){
        inv.allocate(r.type);
    }
}
class ConcurrentBookingProcessor implements Runnable{
    BookingRequestQueue queue;
    RoomInventory inventory;
    RoomAllocationService service;
    ConcurrentBookingProcessor(BookingRequestQueue q,RoomInventory i,RoomAllocationService s){
        queue=q;
        inventory=i;
        service=s;
    }
    public void run(){
        while(true){
            Reservation r;
            synchronized(queue){
                r=queue.get();
            }
            if(r==null)break;
            synchronized(inventory){
                service.allocateRoom(r,inventory);
            }
        }
    }
}
public class UseCase11ConcurrentBookingSimulation{
    public static void main(String[] args){
        BookingRequestQueue q=new BookingRequestQueue();
        RoomInventory inv=new RoomInventory();
        RoomAllocationService s=new RoomAllocationService();
        q.add(new Reservation("A","Single"));
        q.add(new Reservation("B","Single"));
        q.add(new Reservation("C","Double"));
        q.add(new Reservation("D","Double"));
        Thread t1=new Thread(new ConcurrentBookingProcessor(q,inv,s));
        Thread t2=new Thread(new ConcurrentBookingProcessor(q,inv,s));
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            System.out.println("Thread interrupted");
        }
    }
}
