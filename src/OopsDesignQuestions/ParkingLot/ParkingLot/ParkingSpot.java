package OopsDesignQuestions.ParkingLot.ParkingLot;

import OopsDesignQuestions.ParkingLot.Vehicles.Vehicle;

public class ParkingSpot {

    String spotType;
    int spotNumber;
    int level;
    int row;
    boolean isOccupied = false;
    Vehicle v;

    public ParkingSpot(String spotType, int spotNumber, int level, int row) {
        this.spotType = spotType;
        this.spotNumber = spotNumber;
        this.level = level;
        this.row = row;
    }

    public boolean isAvailable() {
         return !isOccupied;
    }

    public void park(Vehicle v) {
        this.v = v;
        isOccupied = true;
    }

    public String getSpotType() {
        return spotType;
    }

    public void setSpotType(String spotType) {
        this.spotType = spotType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getV() {
        return v;
    }

    public void setV(Vehicle v) {
        this.v = v;
    }
}
