public class UseCase10BookingCancellation {

    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        // 1. Register some confirmed bookings
        cancellationService.registerBooking("RES-7001", "Double");
        cancellationService.registerBooking("RES-7002", "Suite");
        cancellationService.registerBooking("RES-7003", "Single");

        System.out.println("Initial Inventory (Suite): " + inventory.getAvailableRooms().get("Suite"));

        // 2. Perform cancellations
        cancellationService.cancelBooking("RES-7002", inventory); // Suite
        cancellationService.cancelBooking("RES-7003", inventory); // Single

        // 3. Verify Inventory Rollback
        System.out.println("Updated Inventory (Suite): " + inventory.getAvailableRooms().get("Suite"));

        // 4. Visualize Rollback Order (LIFO)
        cancellationService.showRollbackHistory();

        // 5. Attempt invalid cancellation
        cancellationService.cancelBooking("RES-9999", inventory);
    }
}