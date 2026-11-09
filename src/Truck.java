/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas_Week2_Kelompok2;

/**
 *
 * @author finde
 */
public class Truck extends Vehicle {
    public Truck(String vehicleNumber, String brand, double pricePerDay) {
        super(vehicleNumber, brand, pricePerDay);
    }

    @Override
    public double calculateRentalPrice(int days) {
        return (getPricePerDay() * days) + 200000;
    }

    @Override
    public String getVehicleType() {
        return "Truck";
    }
}
