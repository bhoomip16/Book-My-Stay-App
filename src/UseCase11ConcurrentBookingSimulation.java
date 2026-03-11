public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        bookingQueue.enqueueRequest(new BookingRequest("User A", "Suite"));
        bookingQueue.enqueueRequest(new BookingRequest("User B", "Suite"));
        bookingQueue.enqueueRequest(new BookingRequest("User C", "Single"));
        bookingQueue.enqueueRequest(new BookingRequest("User D", "Double"));

        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println("Concurrent processing complete.");
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }
    }
}