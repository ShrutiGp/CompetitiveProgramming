package OopsDesignQuestions.ParkingLot;

import OopsDesignQuestions.ParkingLot.ParkingLot.ParkingSpot;
import OopsDesignQuestions.ParkingLot.Vehicles.Bus;
import OopsDesignQuestions.ParkingLot.Vehicles.Vehicle;

public class ParkingVehicles {

    public static void main(String... s) {

        //Assume parking lot has 4 levels -0,1,2,3 and each level has 5 rows
        Vehicle v = new Bus();
        ParkingSpot spot = new ParkingSpot("Large", 1, 0, 1);

        boolean spotAndVehicleSameType = v.checkIfParkingSpotSameType(spot);
        if(spot.isAvailable() && spotAndVehicleSameType) {
            spot.park(v);
            v.addParkingSpots(spot);
        }

        for(ParkingSpot sp :  v.listOfSpotsAssigned) {
         System.out.print(sp.getLevel() + " " + sp.getRow());
        }
    }
}
