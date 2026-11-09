package Tugas_Week2_Kelompok2;

public class Motorcycle extends Vehicle {

    public Motorcycle(String vehicleNumber, String brand, double pricePerDay) {
        super(vehicleNumber, brand, pricePerDay);
    }

    @Override
    public double calculateRentalPrice(int days) {
        double total = getPricePerDay() * days;

        if (days >= 3) {
            total = total * 0.9;
        }
        
        return total;
    }

    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
}
