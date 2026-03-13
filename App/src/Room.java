abstract class Room{

    String roomType;
    int beds;
    double size;
    double price;

    Room(String roomType,int beds,double size,double price){
        this.roomType=roomType;
        this.beds=beds;
        this.size=size;
        this.price=price;
    }

    void displayRoomDetails(){
        System.out.println("Room Type : "+roomType);
        System.out.println("Beds : "+beds);
        System.out.println("Room Size : "+size+" sq.ft");
        System.out.println("Price : ₹"+price);
    }

}