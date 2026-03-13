import java.util.HashMap;

class Inventory
{
    HashMap<String,Integer> rooms;

    Inventory()
    {
        rooms=new HashMap<>();

        rooms.put("Single",10);
        rooms.put("Double",5);
        rooms.put("Suite",2);
    }

    void showAvailability()
    {
        for(String type:rooms.keySet())
        {
            System.out.println(type+" Rooms Available : "+rooms.get(type));
        }
    }

    void updateRoom(String type,int count)
    {
        rooms.put(type,count);
    }
}

public class UC3InventorySetup
{
    public static void main(String[] args)
    {
        Inventory inventory=new Inventory();

        System.out.println("Current Room Availability");
        inventory.showAvailability();

        inventory.updateRoom("Single",8);

        System.out.println("Updated Room Availability");
        inventory.showAvailability();
    }
}