import java.util.*;
import java.io.*;
class RoomInventory{
    HashMap<String,Integer> map=new HashMap<>();
    RoomInventory(){
        map.put("Single",5);
        map.put("Double",3);
        map.put("Suite",2);
    }
    void set(String type,int count){
        map.put(type,count);
    }
    int get(String type){
        return map.get(type);
    }
    Set<String> keys(){
        return map.keySet();
    }
}
class FilePersistenceService{
    void saveInventory(RoomInventory inv,String path){
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter(path));
            for(String k:inv.keys()){
                bw.write(k+"="+inv.get(k));
                bw.newLine();
            }
            bw.close();
        }catch(Exception e){
            System.out.println("Save error");
        }
    }
    void loadInventory(RoomInventory inv,String path){
        try{
            BufferedReader br=new BufferedReader(new FileReader(path));
            String line;
            while((line=br.readLine())!=null){
                String[] p=line.split("=");
                inv.set(p[0],Integer.parseInt(p[1]));
            }
            br.close();
        }catch(Exception e){
            System.out.println("Load error or file missing");
        }
    }
}
public class UseCase12DataPersistenceRecovery{
    public static void main(String[] args){
        RoomInventory inv=new RoomInventory();
        FilePersistenceService fps=new FilePersistenceService();
        String file="inventory.txt";
        fps.saveInventory(inv,file);
        inv.set("Single",0);
        System.out.println("After change: "+inv.get("Single"));
        fps.loadInventory(inv,file);
        System.out.println("After recovery: "+inv.get("Single"));
    }
}