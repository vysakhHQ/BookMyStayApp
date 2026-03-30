import java.util.*;
class RoomInventory{
    HashMap<String,Integer> map;
    RoomInventory(){
        map=new HashMap<>();
        map.put("Single",5);
        map.put("Double",3);
        map.put("Suite",2);
    }
    void increment(String type){
        map.put(type,map.get(type)+1);
    }
    int getCount(String type){
        return map.get(type);
    }
}
class CancellationService{
    Stack<String> releasedRooms;
    HashMap<String,String> reservationMap;
    CancellationService(){
        releasedRooms=new Stack<>();
        reservationMap=new HashMap<>();
    }
    void registerBooking(String id,String type){
        reservationMap.put(id,type);
    }
    void cancelBooking(String id,RoomInventory inventory){
        if(!reservationMap.containsKey(id)){
            System.out.println("Invalid reservation");
            return;
        }
        String type=reservationMap.get(id);
        releasedRooms.push(id);
        inventory.increment(type);
        reservationMap.remove(id);
        System.out.println("Booking cancelled successfully. Inventory restored for room type: "+type);
    }
    void showHistory(){
        System.out.println("\nRollback History (Most Recent First):");
        for(int i=releasedRooms.size()-1;i>=0;i--){
            System.out.println("Released Reservation ID: "+releasedRooms.get(i));
        }
    }
}
public class UseCase10BookingCancellation{
    public static void main(String[] args){
        RoomInventory inventory=new RoomInventory();
        CancellationService service=new CancellationService();
        String id="Single-1";
        service.registerBooking(id,"Single");
        service.cancelBooking(id,inventory);
        service.showHistory();
        System.out.println("\nUpdated Single Room Availability: "+inventory.getCount("Single"));
    }
}