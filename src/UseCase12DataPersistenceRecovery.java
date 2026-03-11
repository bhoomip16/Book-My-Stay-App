public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();
        String filePath = "inventory_state.txt";

        System.out.println("--- System Startup ---");
        persistenceService.loadInventory(inventory, filePath);

        System.out.println("Current Inventory: " + inventory.getAvailableRooms());

        System.out.println("\n--- Simulating Booking Activity ---");
        if (inventory.getAvailableRooms().containsKey("Suite")) {
            int currentSuites = inventory.getAvailableRooms().get("Suite");
            if (currentSuites > 0) {
                inventory.getAvailableRooms().put("Suite", currentSuites - 1);
                System.out.println("One Suite booked. New count: " + (currentSuites - 1));
            }
        }

        System.out.println("\n--- System Shutdown ---");
        persistenceService.saveInventory(inventory, filePath);
    }
}