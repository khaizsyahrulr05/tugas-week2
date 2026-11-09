package Tugas_Week2_Kelompok2;

public class Car extends Vehicle{

    public Car(String vehicleNumber, String brand, double pricePerDay) {
        super(vehicleNumber, brand, pricePerDay);
    }

    @Override
    public double calculateRentalPrice(int days) {
        return getPricePerDay() * days;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }
}
