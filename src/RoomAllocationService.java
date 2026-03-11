import java.util.*;

public class RoomAllocationService {

    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();

        if (inventory.isAvailable(type)) {
            String roomId = generateRoomId(type);

            allocatedRoomIds.add(roomId);

            assignedRoomsByType.putIfAbsent(type, new HashSet<>());
            assignedRoomsByType.get(type).add(roomId);

            inventory.decrementInventory(type);
            reservation.confirm(roomId);
        }
    }

    private String generateRoomId(String roomType) {
        String newId;
        do {
            newId = roomType.toUpperCase().substring(0, 3) + "-" + (int)(Math.random() * 1000);
        } while (allocatedRoomIds.contains(newId));
        return newId;
    }
}
