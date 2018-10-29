package OopsDesignQuestions.ParkingLot.Vehicles;

import OopsDesignQuestions.ParkingLot.ParkingLot.ParkingSpot;

public class Bus extends Vehicle {

    public Bus() {
        size = "Large";
        numOfSpots = 5;
    }

    public boolean checkIfParkingSpotSameType(ParkingSpot s) {
        if(s.getSpotType().equals(size))
            return true;
        else
            return false;
    }
}
