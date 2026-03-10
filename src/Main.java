// Abstract Class
abstract class Room {
    private int beds;
    private int size;
    private double price;

    // Constructor
    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    // Getters
    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    // Method to display room details
    public void displayRoomDetails() {
        System.out.println("Beds: " + beds);
        System.out.println("Room Size: " + size + " sq ft");
        System.out.println("Price: ₹" + price);
    }
}

// Single Room Class
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 200, 2500);
    }

    public void roomType() {
        System.out.println("Room Type: Single Room");
    }
}

// Double Room Class
class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 350, 4000);
    }

    public void roomType() {
        System.out.println("Room Type: Double Room");
    }
}

// Suite Room Class
class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 600, 8000);
    }

    public void roomType() {
        System.out.println("Room Type: Suite Room");
    }
}

// Main Class
public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Creating objects using polymorphism
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        System.out.println("------ Available Rooms ------\n");

        System.out.println("Single Room");
        r1.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);

        System.out.println("\nDouble Room");
        r2.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);

        System.out.println("\nSuite Room");
        r3.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}