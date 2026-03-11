public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        Reservation res1 = new Reservation("RES-5001", "Alice Smith");
        Reservation res2 = new Reservation("RES-5002", "Bob Johnson");
        Reservation res3 = new Reservation("RES-5003", "Charlie Brown");

        history.addReservation(res1);
        history.addReservation(res2);
        history.addReservation(res3);

        reportService.generateReport(history);
    }
}