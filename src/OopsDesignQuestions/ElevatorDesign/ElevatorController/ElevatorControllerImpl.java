package OopsDesignQuestions.ElevatorDesign.ElevatorController;

import OopsDesignQuestions.ElevatorDesign.Direction;

import OopsDesignQuestions.ElevatorDesign.ElevatorModel.Elevator;

import java.util.List;


public class ElevatorControllerImpl implements ElevatorController {

    List<Elevator> elevators;

    public ElevatorControllerImpl(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    @Override
    public void processElevatorRequest(int floor) {
        for(Elevator elevator : elevators) {
            if(elevator.getDirection().equals(Direction.Stopped)) {
                elevator.requestFloor(floor);
                return;
            }
            else if( elevator.isInPath(floor) ) {
                elevator.requestFloor(floor);
                return;
            }
        }
    }

    public void groundAllElevators() {
        for(Elevator elevator : elevators)
            elevator.groundElevator();
    }

}
