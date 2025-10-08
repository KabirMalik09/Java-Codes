interface TransportService {
    void displayDetails();
    double calculateWeeklyEarnings();
}

abstract class Vehicle implements TransportService {
    String regNumber;
    String driverName;
    double ratePerTrip;
    int[] tripsPerDay; 

    Vehicle(String regNumber, String driverName, double ratePerTrip, int[] tripsPerDay) {
        this.regNumber = regNumber;
        this.driverName = driverName;
        this.ratePerTrip = ratePerTrip;
        this.tripsPerDay = tripsPerDay;
    }

    @Override
    public double calculateWeeklyEarnings() {
        int totalTrips = 0;
        for (int trips : tripsPerDay)
            totalTrips += trips;
        return totalTrips * ratePerTrip;
    }
}

class Bus extends Vehicle {
    int seatingCapacity;

    Bus(String regNumber, String driverName, double ratePerTrip, int[] tripsPerDay, int seatingCapacity) {
        super(regNumber, driverName, ratePerTrip, tripsPerDay);
        this.seatingCapacity = seatingCapacity;
    }
    @Override
    public void displayDetails() {
        System.out.println("Bus | Reg No: " + regNumber + 
                           " | Driver: " + driverName + 
                           " | Seating: " + seatingCapacity + 
                           " | Rate/Trip: ₹" + ratePerTrip);
    }
}

class MiniVan extends Vehicle {
    String routeName;

    MiniVan(String regNumber, String driverName, double ratePerTrip, int[] tripsPerDay, String routeName) {
        super(regNumber, driverName, ratePerTrip, tripsPerDay);
        this.routeName = routeName;
    }

    public void displayDetails() {
        System.out.println("MiniVan | Reg No: " + regNumber + 
                           " | Driver: " + driverName + 
                           " | Route: " + routeName + 
                           " | Rate/Trip: ₹" + ratePerTrip);
    }
}

public class CollegeTransportSystem {
    public static void main(String[] args) {

        TransportService[] vehicles = new TransportService[3];

        vehicles[0] = new Bus("DL1A1234", "Ramesh Kumar", 500.0, new int[]{2, 3, 2, 3, 2, 2, 1}, 50);
        vehicles[1] = new MiniVan("DL2B5678", "Suresh Yadav", 300.0, new int[]{3, 2, 3, 3, 3, 1, 2}, "North Campus");
        vehicles[2] = new Bus("DL3C7890", "Mahesh Singh", 550.0, new int[]{2, 2, 3, 3, 2, 2, 2}, 45);

        double totalWeeklyRevenue = 0;

        System.out.println("------ Vehicle Details ------");
        for (TransportService v : vehicles) {
            v.displayDetails();
            double earnings = v.calculateWeeklyEarnings();
            System.out.println("  Weekly Earnings: ₹" + earnings);
            System.out.println("----------------------------------");
            totalWeeklyRevenue += earnings;
        }

        System.out.println("Total Weekly Revenue of Transport Department: ₹" + totalWeeklyRevenue);
    }
}
