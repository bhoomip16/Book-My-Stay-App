import java.util.List;

public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {
        AddOnServiceManager manager = new AddOnServiceManager();

        AddOnService breakfast = new AddOnService("Breakfast", 15.0);
        AddOnService spa = new AddOnService("Spa", 50.0);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 30.0);

        String reservationId = "RES-1001";

        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);
        manager.addService(reservationId, airportPickup);

        System.out.println("Reservation ID: " + reservationId);
        List<AddOnService> selected = manager.getServicesForReservation(reservationId);

        for (AddOnService s : selected) {
            System.out.println("- Service: " + s.getServiceName() + " | Cost: $" + s.getCost());
        }

        double totalCost = manager.calculateTotalServiceCost(reservationId);
        System.out.println("Total Add-On Cost: $" + totalCost);
    }
}