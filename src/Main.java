/**
 * Main bukan tempat seluruh logic
 * @author AERO
 */
/**
 * 1. Abdu Musyaffa 2502537
 * 2. Arief Rahman Prasetyo 2506048
 * 3. Dikhi Wardani 2502488
 * 4. Khaiz Syahrul Ramadhan 2502187
 * 5. Najmi Nuralifah Hidayat 2502410
 * 6. Gregorius Putra Chrisaty Antonio 2521421
 * 7. Naufal Muttaqin Prawiranegara 2501375
 */
package Tugas_Week2_Kelompok2;

public class Main {
    public static void main(String[] args) {
        RentalSystem system = new RentalSystem();

        system.addVehicle(new Car("B 1234 ABC", "Hyundai", 500000));
        system.addVehicle(new Motorcycle("D 5678 XYZ", "RX-King", 100000));
        system.addVehicle(new Truck("T 9012 DEF", "Fuso", 800000));
        system.addVehicle(new ElectricCar("E 3456 GHI", "BYD", 600000));

        System.out.println("=== VEHICLES ===");
        system.showAvailableVehicles();

        System.out.println("\n=== TESTING EXCEPTIONS ===");
        
        // Test E1
        try {
            system.rentVehicle("B 9999 XYZ", 2);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Test E2
        try {
            double total = system.rentVehicle("B 1234 ABC", 3);
            System.out.println("Rented successfully. Total Price: Rp" + total);
            
            system.rentVehicle("B 1234 ABC", 2);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        // Test return vehicle
        try {
            system.returnVehicle("B 1234 ABC");
            System.out.println("Return kendaraan B 1234 ABC: SUCCESS");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        // Test E3 (0)
        try {
            system.rentVehicle("B 1234 ABC", 0);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        // Test E3 (-5)
        try {
            system.rentVehicle("B 1234 ABC", -5);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        // Test Unrented Vehicle
        try {
            system.returnVehicle("D 5678 XYZ");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        
        System.out.println("\n=== TEST RENTAL LIMIT > 3 ===");
        try {
            system.returnVehicle("B 1234 ABC"); 
            
            System.out.println("Merental kendaraan ke-1...");
            system.rentVehicle("B 1234 ABC", 1);
            System.out.println("Rented successfully");
            
            System.out.println("Merental kendaraan ke-2...");
            system.rentVehicle("D 5678 XYZ", 1);
            System.out.println("Rented successfully");
            
            System.out.println("Merental kendaraan ke-3...");
            system.rentVehicle("T 9012 DEF", 1);
            System.out.println("Rented successfully");
            
            System.out.println("Merental kendaraan ke-4...");
            system.rentVehicle("E 3456 GHI", 1); 
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage()); 
        }
    }
}
