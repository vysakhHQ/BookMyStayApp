import java.util.*;
class Reservation
{
    String guestName;
    String roomType;
    Reservation(String guestName,String roomType)
    {
        this.guestName=guestName;
        this.roomType=roomType;
    }
}
class Inventory
{
    HashMap<String,Integer> rooms;
    Inventory()
    {
        rooms=new HashMap<>();
        rooms.put("Single",2);
        rooms.put("Double",1);
        rooms.put("Suite",1);
    }
    int getAvailability(String type)
    {
        return rooms.getOrDefault(type,0);
    }
    void decrementRoom(String type)
    {
        rooms.put(type,rooms.get(type)-1);
    }
}
class BookingRequestQueue
{
    Queue<Reservation> queue;
    BookingRequestQueue()
    {
        queue=new LinkedList<>();
    }
    void addRequest(Reservation r)
    {
        queue.add(r);
    }
    Reservation getNextRequest()
    {
        return queue.poll();
    }
}
class BookingService
{
    Inventory inventory;
    HashMap<String,Set<String>> allocatedRooms;
    BookingService(Inventory inventory)
    {
        this.inventory=inventory;
        allocatedRooms=new HashMap<>();
        allocatedRooms.put("Single",new HashSet<>());
        allocatedRooms.put("Double",new HashSet<>());
        allocatedRooms.put("Suite",new HashSet<>());
    }
    void processReservation(Reservation r)
    {
        int available=inventory.getAvailability(r.roomType);
        if(available>0)
        {
            String roomId=r.roomType.substring(0,1)+System.nanoTime();
            allocatedRooms.get(r.roomType).add(roomId);
            inventory.decrementRoom(r.roomType);
            System.out.println("Reservation Confirmed");
            System.out.println("Guest: "+r.guestName);
            System.out.println("Room Type: "+r.roomType);
            System.out.println("Room ID: "+roomId);
        }
        else
        {
            System.out.println("No rooms available for "+r.roomType);
        }
    }
}
public class UC6RoomAllocationService
{
    public static void main(String[] args)
    {
        Inventory inventory=new Inventory();
        BookingRequestQueue queue=new BookingRequestQueue();
        queue.addRequest(new Reservation("Alice","Single"));
        queue.addRequest(new Reservation("Bob","Double"));
        queue.addRequest(new Reservation("Charlie","Suite"));
        BookingService service=new BookingService(inventory);
        Reservation r;
        while((r=queue.getNextRequest())!=null)
        {
            service.processReservation(r);
        }
    }
}