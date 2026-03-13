import java.util.HashMap;
class Room
{
    String type;
    int price;
    Room(String type,int price)
    {
        this.type=type;
        this.price=price;
    }
}
class Inventory
{
    HashMap<String,Integer> rooms;
    Inventory()
    {
        rooms=new HashMap<>();
        rooms.put("Single",5);
        rooms.put("Double",3);
        rooms.put("Suite",0);
    }
    int getAvailability(String type)
    {
        return rooms.getOrDefault(type,0);
    }
}
class SearchService
{
    Inventory inventory;
    HashMap<String,Room> roomDetails;
    SearchService(Inventory inventory)
    {
        this.inventory=inventory;
        roomDetails=new HashMap<>();
        roomDetails.put("Single",new Room("Single",2000));
        roomDetails.put("Double",new Room("Double",3500));
        roomDetails.put("Suite",new Room("Suite",5000));
    }
    void searchRooms()
    {
        System.out.println("Available Rooms");
        for(String type:roomDetails.keySet())
        {
            int available=inventory.getAvailability(type);
            if(available>0)
            {
                Room r=roomDetails.get(type);
                System.out.println("Type: "+r.type+" Price: "+r.price+" Available: "+available);
            }
        }
    }
}
public class UseCase4RoomSearch
{
    public static void main(String[] args)
    {
        Inventory inventory=new Inventory();
        SearchService search=new SearchService(inventory);
        search.searchRooms();
    }
}