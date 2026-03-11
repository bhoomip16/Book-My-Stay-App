import java.util.Scanner;

public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {
        System.out.println("Booking Validation");
        Scanner scanner = new Scanner(System.in);

        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        try {
            System.out.print("Enter Guest Name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter Room Type (e.g., Single, Double, Suite): ");
            String roomType = scanner.nextLine();

            validator.validate(guestName, roomType, inventory);

            BookingRequest request = new BookingRequest(guestName, roomType);
            bookingQueue.enqueueRequest(request);
            System.out.println("Booking request successfully validated and queued.");

        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}