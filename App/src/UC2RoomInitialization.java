public class UC2RoomInitialization{

    public static void main(String[] args){

        Room singleRoom=new SingleRoom();
        Room doubleRoom=new DoubleRoom();
        Room suiteRoom=new SuiteRoom();

        int singleAvailability=5;
        int doubleAvailability=3;
        int suiteAvailability=2;

        System.out.println("WELCOME TO BOOK MY STAY");
        System.out.println("---------------------------");

        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms : "+singleAvailability);
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms : "+doubleAvailability);
        System.out.println();

        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms : "+suiteAvailability);

    }

}