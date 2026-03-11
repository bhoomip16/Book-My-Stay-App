import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CancellationService {

    private Stack<String> releasedRoomIds;
    private Map<String, String> reservationRoomTypeMap;

    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId, RoomInventory inventory) {
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Reservation ID " + reservationId + " not found.");
            return;
        }

        String roomType = reservationRoomTypeMap.remove(reservationId);

        // Restore inventory
        inventory.getAvailableRooms().put(roomType, inventory.getAvailableRooms().get(roomType) + 1);

        // Track released room (using ID as reservationId for simulation)
        releasedRoomIds.push(reservationId);

        System.out.println("Successfully cancelled reservation: " + reservationId);
    }

    public void showRollbackHistory() {
        System.out.println("--- Rollback History (LIFO) ---");
        if (releasedRoomIds.isEmpty()) {
            System.out.println("No recent cancellations.");
            return;
        }

        Stack<String> tempStack = (Stack<String>) releasedRoomIds.clone();
        while (!tempStack.isEmpty()) {
            System.out.println("Released Reservation/Room: " + tempStack.pop());
        }
    }
}
