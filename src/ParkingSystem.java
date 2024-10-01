import java.util.ArrayList;
import java.util.List;

class ParkingSystem {
    private Vehicle[] parkingSlots;

    public ParkingSystem(int totalLots) {
        parkingSlots = new Vehicle[totalLots];
    }

    public void parkVehicle(String registrationNumber, String color, String type) {
        for (int i = 0; i < parkingSlots.length; i++) {
            if (parkingSlots[i] == null) {
                parkingSlots[i] = new Vehicle(registrationNumber, color, type);
                System.out.println("Allocated slot number: " + (i + 1));
                return;
            }
        }
        System.out.println("Sorry, parking lot is full");
    }

    public void leave(int slotNumber) {
        if (slotNumber > 0 && slotNumber <= parkingSlots.length && parkingSlots[slotNumber - 1] != null) {
            parkingSlots[slotNumber - 1] = null;
            System.out.println("Slot number " + slotNumber + " is free");
        } else {
            System.out.println("Slot number " + slotNumber + " is already free or invalid");
        }
    }

    public void status() {
        System.out.println("Slot\tReg No.\tType\tColour");
        for (int i = 0; i < parkingSlots.length; i++) {
            Vehicle vehicle = parkingSlots[i];
            if (vehicle != null) {
                System.out.println((i + 1) + "\t\t" + vehicle.getRegistrationNumber() + "\t\t" + vehicle.getType() + "\t" + vehicle.getColor());
            }
        }
    }

    public void typeOfVehicles(String type) {
        int count = 0;
        for (Vehicle vehicle : parkingSlots) {
            if (vehicle != null && vehicle.getType().equalsIgnoreCase(type)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void registrationNumbersForVehiclesWithOddPlate() {
        List<String> oddPlates = new ArrayList<>();
        for (Vehicle vehicle : parkingSlots) {
            if (vehicle != null) {
                String[] regParts = vehicle.getRegistrationNumber().split("-");
                if (regParts.length > 1 && isOdd(Integer.parseInt(regParts[1]))) {
                    oddPlates.add(vehicle.getRegistrationNumber());
                }
            }
        }
        System.out.println(String.join(", ", oddPlates));
    }

    public void registrationNumbersForVehiclesWithEvenPlate() {
        List<String> evenPlates = new ArrayList<>();
        for (Vehicle vehicle : parkingSlots) {
            if (vehicle != null) {
                String[] regParts = vehicle.getRegistrationNumber().split("-");
                if (regParts.length > 1 && !isOdd(Integer.parseInt(regParts[1]))) {
                    evenPlates.add(vehicle.getRegistrationNumber());
                }
            }
        }
        System.out.println(String.join(", ", evenPlates));
    }

    public void registrationNumbersForVehiclesWithColor(String color) {
        List<String> regNumbers = new ArrayList<>();
        for (Vehicle vehicle : parkingSlots) {
            if (vehicle != null && vehicle.getColor().equalsIgnoreCase(color)) {
                regNumbers.add(vehicle.getRegistrationNumber());
            }
        }
        System.out.println(String.join(", ", regNumbers));
    }

    public void slotNumbersForVehiclesWithColor(String color) {
        List<Integer> slotNumbers = new ArrayList<>();
        for (int i = 0; i < parkingSlots.length; i++) {
            Vehicle vehicle = parkingSlots[i];
            if (vehicle != null && vehicle.getColor().equalsIgnoreCase(color)) {
                slotNumbers.add(i + 1);
            }
        }
        System.out.println(slotNumbers.toString().replaceAll("[\\[\\]]", ""));
    }

    public void slotNumberForRegistrationNumber(String registrationNumber) {
        for (int i = 0; i < parkingSlots.length; i++) {
            Vehicle vehicle = parkingSlots[i];
            if (vehicle != null && vehicle.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println("Not found");
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }
}

