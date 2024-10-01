public class ParkingLot {
    private Vehicle vehicle;
    private int slotNumber;

    public ParkingLot(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void removeVehicle() {
        this.vehicle = null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    @Override
    public String toString() {
        if (vehicle == null) {
            return "Slot " + slotNumber + " is free";
        } else {
            return slotNumber + "\t" + vehicle.toString();
        }
    }
}

