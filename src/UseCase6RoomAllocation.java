import java.util.*;

public class UseCase6RoomAllocation {

    public static void main(String[] args) {
        Queue<Reservation> bookingQueue = new LinkedList<>();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        bookingQueue.add(new Reservation("Deluxe"));
        bookingQueue.add(new Reservation("Standard"));
        bookingQueue.add(new Reservation("Deluxe"));

        while (!bookingQueue.isEmpty()) {
            Reservation currentRequest = bookingQueue.poll();
            allocationService.allocateRoom(currentRequest, inventory);
        }
    }
}