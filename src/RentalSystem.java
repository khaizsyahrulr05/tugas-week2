package Tugas_Week2_Kelompok2;

import java.util.ArrayList;
import java.util.List;

public class RentalSystem {

    private List<Vehicle> vehicles;
    private int activeRentals;
    
    public RentalSystem() {
        vehicles = new ArrayList<>();
        activeRentals = 0;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public Vehicle findVehicle(String vehicleNumber) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleNumber().equals(vehicleNumber)) {
                return vehicle;
            }
        }
        
        return null;
    }

    public void searchVehicle(String vehicleNumber) {

        Vehicle vehicle = findVehicle(vehicleNumber);
        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }
        vehicle.displayInfo();
    }

    public void showAvailableVehicles() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                vehicle.displayInfo();
            }
        }
    }

    public double rentVehicle(String vehicleNumber, int days) throws VehicleNotFoundException, VehicleNotAvailableException, InvalidRentalDurationException, RentalLimitExceededException
    {
        
        if (days <= 0) {
            throw new InvalidRentalDurationException("Rental duration must be greater than 0.");
        }
        
        if (activeRentals >= 3) {
            throw new RentalLimitExceededException("Rental limit exceeded.");
        }
        
        Vehicle vehicle = findVehicle(vehicleNumber);
        if (vehicle == null) {
            throw new VehicleNotFoundException("Vehicle " + vehicleNumber + " was not found.");
        }
        if (!vehicle.isAvailable()) {
            throw new VehicleNotAvailableException("Vehicle " + vehicleNumber + " is not available.");
        }

        vehicle.rent();
        activeRentals++;
        
        return vehicle.calculateRentalPrice(days);
    }

    public void returnVehicle(String vehicleNumber) throws Exception {

        Vehicle vehicle = findVehicle(vehicleNumber);
        if (vehicle == null) {
             throw new VehicleNotFoundException("Vehicle not found.");
        }
        if (vehicle.isAvailable()) {
             throw new Exception("Vehicle is not currently rented."); 
        }
        
        vehicle.returnVehicle();
        activeRentals--;
    }
}
