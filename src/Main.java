import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingSystem parkingSystem = null;

        while (true) {
            System.out.println("Input your command:");
            String input = scanner.nextLine();
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "create_parking_lot":
                    int totalLots = Integer.parseInt(commands[1]);
                    parkingSystem = new ParkingSystem(totalLots);
                    System.out.println("Created a parking lot with " + totalLots + " slots");
                    break;

                case "park":
                    if (parkingSystem != null) {
                        String regNumber = commands[1];
                        String color = commands[2];
                        String type = commands[3];
                        parkingSystem.parkVehicle(regNumber, color, type);
                    } else {
                        System.out.println("Parking lot has not been created.");
                    }
                    break;

                case "leave":
                    if (parkingSystem != null) {
                        int slotNumber = Integer.parseInt(commands[1]);
                        parkingSystem.leave(slotNumber);
                    }
                    break;

                case "status":
                    if (parkingSystem != null) {
                        parkingSystem.status();
                    }
                    break;

                case "type_of_vehicles":
                    if (parkingSystem != null) {
                        String type = commands[1];
                        parkingSystem.typeOfVehicles(type);
                    }
                    break;

                case "registration_numbers_for_vehicles_with_odd_plate":
                    if (parkingSystem != null) {
                        parkingSystem.registrationNumbersForVehiclesWithOddPlate();
                    }
                    break;

                case "registration_numbers_for_vehicles_with_even_plate":
                    if (parkingSystem != null) {
                        parkingSystem.registrationNumbersForVehiclesWithEvenPlate();
                    }
                    break;

                case "registration_numbers_for_vehicles_with_colour":
                    if (parkingSystem != null) {
                        String color = commands[1];
                        parkingSystem.registrationNumbersForVehiclesWithColor(color);
                    }
                    break;

                case "slot_numbers_for_vehicles_with_colour":
                    if (parkingSystem != null) {
                        String color = commands[1];
                        parkingSystem.slotNumbersForVehiclesWithColor(color);
                    }
                    break;

                case "slot_number_for_registration_number":
                    if (parkingSystem != null) {
                        String regNumber = commands[1];
                        parkingSystem.slotNumberForRegistrationNumber(regNumber);
                    }
                    break;

                case "exit":
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}