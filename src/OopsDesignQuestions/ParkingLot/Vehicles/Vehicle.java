package OopsDesignQuestions.ParkingLot.Vehicles;


import OopsDesignQuestions.ParkingLot.ParkingLot.ParkingSpot;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Vehicle {
    public ArrayList<ParkingSpot> listOfSpotsAssigned = new ArrayList<>();
    String size;
    String licensePlate;
    int numOfSpots;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNumOfSpots() {
        return numOfSpots;
    }

    public void setNumOfSpots(int numOfSpots) {
        this.numOfSpots = numOfSpots;
    }
    public abstract boolean checkIfParkingSpotSameType(ParkingSpot s);

    public void addParkingSpots(ParkingSpot spot) {
        listOfSpotsAssigned.add(spot);
    }

    public void clearParkingSpots(ParkingSpot spot) {
        listOfSpotsAssigned.remove(spot);
    }
}
/*
Parking lot - levels, rows, parking , parking spots (bike, compact, large spot)
1 compact -1 car
1 large - 1 car
5 large - 1 bus


Vehicle - Bus, Car-Large or Compact, Bike
every vehicle as sizeType - Bike, compact, Large
Compact car - fir in

 */