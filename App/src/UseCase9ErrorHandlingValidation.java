import java.util.*;
class InvalidBookingException extends Exception
{
    InvalidBookingException(String msg)
    {
        super(msg);
    }
}
class ReservationValidator
{
    void validate(String guestName,String roomType,int inventory) throws InvalidBookingException
    {
        if(guestName==null||guestName.isEmpty())
        {
            throw new InvalidBookingException("Guest name invalid");
        }
        if(!(roomType.equals("Single")||roomType.equals("Double")||roomType.equals("Suite")))
        {
            throw new InvalidBookingException("Invalid room type");
        }
        if(inventory<=0)
        {
            throw new InvalidBookingException("No rooms available");
        }
    }
}
public class UseCase9ErrorHandlingValidation
{
    public static void main(String[] args)
    {
        System.out.println("Booking Validation");
        Scanner sc=new Scanner(System.in);
        ReservationValidator v=new ReservationValidator();
        try
        {
            System.out.print("Enter Name: ");
            String name=sc.nextLine();
            System.out.print("Enter Room Type: ");
            String type=sc.nextLine();
            int inventory=1; // simple mock
            v.validate(name,type,inventory);
            System.out.println("Booking Valid");
        }
        catch(InvalidBookingException e)
        {
            System.out.println("Booking failed: "+e.getMessage());
        }
        finally
        {
            sc.close();
        }
    }
}