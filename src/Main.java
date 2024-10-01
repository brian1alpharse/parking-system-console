import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingSystem parkingSystem = null;

        while (true) {
            // Tampilkan menu utama setelah parkir berhasil atau ketika aplikasi pertama kali berjalan
            displayMainMenu();

            String choice = scanner.nextLine();

            switch (choice) {
                case "1": // create parking lot
                    System.out.println("=========== parking system ===========");
                    System.out.println("WARNING : This process will restart last data.");
                    System.out.print("Create a parking lot\nenter slot available: ");
                    int totalLots = Integer.parseInt(scanner.nextLine());
                    parkingSystem = new ParkingSystem(totalLots);
                    System.out.println("===================================");
                    System.out.println("Created a parking lot with " + totalLots + " slots");
                    System.out.println("===================================");
                    System.out.println("processing ...");
                    break;

                case "2": // park vehicle
                    if (parkingSystem != null) {
                        System.out.println("=========== parking system ===========");
                        System.out.print("Enter vehicle number: ");
                        String regNumber = scanner.nextLine();
                        System.out.print("Enter vehicle color: ");
                        String color = scanner.nextLine();
                        System.out.print("Enter vehicle type: ");
                        String type = scanner.nextLine();
                        System.out.println("===================================");
                        System.out.println("processing ...");
                        parkingSystem.parkVehicle(regNumber, color, type);
                    } else {
                        System.out.println("Parking lot has not been created.");
                    }
                    break;

                case "3": // leave
                    if (parkingSystem != null) {
                        System.out.println("=========== parking system ===========");
                        System.out.print("Enter slot number to leave: ");
                        int slotNumber = Integer.parseInt(scanner.nextLine());
                        System.out.println("===================================");
                        System.out.println("processing ...");
                        parkingSystem.leave(slotNumber);
                    }
                    break;

                case "4": // status
                    if (parkingSystem != null) {
                        System.out.println("=========== parking system ===========");
                        System.out.println("Parking lot status");
                        System.out.println("===================================");
                        parkingSystem.status();
                    }
                    break;

                case "5": // type_of_vehicles
                    if (parkingSystem != null) {
                        System.out.println("=========== parking system ===========");
                        System.out.print("Enter vehicle type (Mobil/Motor): ");
                        String type = scanner.nextLine();
                        System.out.println("===================================");
                        parkingSystem.typeOfVehicles(type);
                    }
                    break;

                case "6": // registration_numbers_for_vehicles_with_ood_plate
                    if (parkingSystem != null) {
                        System.out.println("=========== parking system ===========");
                        parkingSystem.registrationNumbersForVehiclesWithOddPlate();
                    }
                    break;

                case "7": // registration_numbers_for_vehicles_with_event_plate
                    if (parkingSystem != null) {
                        System.out.println("=========== parking system ===========");
                        parkingSystem.registrationNumbersForVehiclesWithEvenPlate();
                    }
                    break;

                case "8": // registration_numbers_for_vehicles_with_colour
                    if (parkingSystem != null) {
                        System.out.println("=========== parking system ===========");
                        System.out.print("Enter vehicle color: ");
                        String color = scanner.nextLine();
                        System.out.println("===================================");
                        parkingSystem.registrationNumbersForVehiclesWithColor(color);
                    }
                    break;

                case "9": // slot_numbers_for_vehicles_with_colour
                    if (parkingSystem != null) {
                        System.out.println("=========== parking system ===========");
                        System.out.print("Enter vehicle color: ");
                        String slotColor = scanner.nextLine();
                        System.out.println("===================================");
                        parkingSystem.slotNumbersForVehiclesWithColor(slotColor);
                    }
                    break;

                case "10": // slot_number_for_registration_number
                    if (parkingSystem != null) {
                        System.out.println("=========== parking system ===========");
                        System.out.print("Enter registration number: ");
                        String registration = scanner.nextLine();
                        System.out.println("===================================");
                        parkingSystem.slotNumberForRegistrationNumber(registration);
                    }
                    break;

                case "11": // exit
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Method to display the main menu
    public static void displayMainMenu() {
        System.out.println("=========== parking system ===========");
        System.out.println("Menu app:");
        System.out.println("1. Create parking lot");
        System.out.println("2. Park");
        System.out.println("3. Leave");
        System.out.println("4. Status");
        System.out.println("5. Type of vehicles");
        System.out.println("6. Registration numbers for vehicles with odd plate");
        System.out.println("7. Registration numbers for vehicles with even plate");
        System.out.println("8. Registration numbers for vehicles with colour");
        System.out.println("9. Slot numbers for vehicles with colour");
        System.out.println("10. Slot number for registration number");
        System.out.println("11. Exit");
        System.out.print("Your choice: ");
    }
}
