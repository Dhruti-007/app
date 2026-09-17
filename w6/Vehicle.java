abstract class Vehicle {
    protected String VehicleNo;
    protected String brand;
    protected int speed;

    public Vehicle(String VehicleNo, String brand, int speed) {
        this.VehicleNo = VehicleNo;
        this.brand = brand;
        this.speed = speed;
    }


    public void displayDetails() {
        System.out.println("Vehicle Number : " + VehicleNo);
        System.out.println("Brand          : " + brand);
        System.out.println("Speed          : " + speed + " km/h");
    }
}

// Bike from Vehicle
public class Bike extends Vehicle {
    private boolean hasGear;

    public Bike(String vehicleNumber, String brand, double speed, boolean hasGear) {
        super(vehicleNumber, brand, speed);
        this.hasGear = hasGear;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike Details");
        super.displayDetails();
        System.out.println("Has Gear       : " + (hasGear ? "Yes" : "No"));
        System.out.println();
    }
}

// Car derived from Vehicle
public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String vehicleNumber, String brand, double speed, int numberOfDoors) {
        super(vehicleNumber, brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car Details");
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println();
    }
}


public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Car("AP10AB1010", "Toyota", 180.0, 4);
        Vehicle v2 = new Bike("TN20CD2020", "Yamaha", 120.0, true);

        Vehicle[] vehicles = { v1, v2 };

        // Same reference type (Vehicle), different runtime behaviour
        for (Vehicle v : vehicles) {
            v.displayDetails();   // resolved at runtime based on actual object
        }
    }
}




