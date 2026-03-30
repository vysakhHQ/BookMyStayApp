import java.util.*;
class Service
{
    String name;
    double cost;
    Service(String n,double c)
    {
        name=n;
        cost=c;
    }
    double getCost()
    {
        return cost;
    }
}
class AddOnServiceManager
{
    HashMap<String,List<Service>> map;
    AddOnServiceManager()
    {
        map=new HashMap<>();
    }
    void addService(String id,Service s)
    {
        if(!map.containsKey(id))
        {
            map.put(id,new ArrayList<>());
        }
        map.get(id).add(s);
    }
    double getTotalCost(String id)
    {
        double total=0;
        if(map.containsKey(id))
        {
            for(Service s:map.get(id))
            {
                total+=s.getCost();
            }
        }
        return total;
    }
}
public class UseCase7AddOnServiceSelection
{
    public static void main(String[] args)
    {
        AddOnServiceManager m=new AddOnServiceManager();
        String id="Single-1";
        m.addService(id,new Service("Breakfast",500));
        m.addService(id,new Service("Airport Pickup",1000));
        System.out.println("Add-On Service Selection");
        System.out.println("Reservation ID: "+id);
        System.out.println("Total Add-On Cost: "+m.getTotalCost(id));
    }
}