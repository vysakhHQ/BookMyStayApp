import java.util.*;
class Reservation
{
    String name;
    String type;
    String id;
    Reservation(String n,String t,String i)
    {
        name=n;
        type=t;
        id=i;
    }
}
class BookingHistory
{
    List<Reservation> list;
    BookingHistory()
    {
        list=new ArrayList<>();
    }
    void addReservation(Reservation r)
    {
        list.add(r);
    }
    List<Reservation> getReservations()
    {
        return list;
    }
}
class BookingReportService
{
    void generateReport(BookingHistory history)
    {
        System.out.println("Booking Report:");
        for(Reservation r:history.getReservations())
        {
            System.out.println(r.name+" "+r.type+" "+r.id);
        }
    }
}
public class UseCase8BookingHistoryReport
{
    public static void main(String[] args)
    {
        BookingHistory history=new BookingHistory();
        history.addReservation(new Reservation("Alice","Single","S101"));
        history.addReservation(new Reservation("Bob","Double","D201"));
        BookingReportService report=new BookingReportService();
        report.generateReport(history);
    }
}