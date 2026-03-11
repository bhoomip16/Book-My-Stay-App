import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOnServiceManager {

    private Map<String, List<AddOnService>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    public void addService(String reservationId, AddOnService service) {
        servicesByReservation.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
    }

    public double calculateTotalServiceCost(String reservationId) {
        List<AddOnService> services = servicesByReservation.get(reservationId);
        if (services == null || services.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        for (AddOnService service : services) {
            total += service.getCost();
        }
        return total;
    }

    public List<AddOnService> getServicesForReservation(String reservationId) {
        return servicesByReservation.getOrDefault(reservationId, new ArrayList<>());
    }
}