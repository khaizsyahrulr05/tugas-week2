package Tugas_Week2_Kelompok2;

public abstract class Vehicle {

    private String vehicleNumber;
    private String brand;
    private double pricePerDay;
    private boolean available;

    public Vehicle(String vehicleNumber, String brand, double pricePerDay) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getBrand() {
        return brand;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rent() {
        available = false;
    }

    public void returnVehicle() {
        available = true;
    }

    public abstract double calculateRentalPrice(int days);

    public abstract String getVehicleType();

    public void displayInfo() {
        System.out.println(vehicleNumber 
                + " | " + brand 
                + " | " +getVehicleType()
                + " | Rp" + pricePerDay + "/day | "
                + (available ? "Available" : "Rented")
        );
    }
}
