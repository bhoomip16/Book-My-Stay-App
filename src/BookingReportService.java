import java.util.List;

public class BookingReportService {

    public void generateReport(BookingHistory history) {
        List<Reservation> records = history.getConfirmedReservations();

        System.out.println("=== BOOKING SUMMARY REPORT ===");
        if (records.isEmpty()) {
            System.out.println("No confirmed bookings found.");
            return;
        }

        for (Reservation res : records) {
            System.out.println("Reservation ID: " + res.getReservationId() +
                    " | Guest: " + res.getGuestName() +
                    " | Status: Confirmed");
        }
        System.out.println("Total Bookings Processed: " + records.size());
        System.out.println("==============================");
    }
}