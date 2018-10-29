package OopsDesignQuestions.ElevatorDesign;

import OopsDesignQuestions.ElevatorDesign.ElevatorController.ElevatorController;
import OopsDesignQuestions.ElevatorDesign.ElevatorController.ElevatorControllerImpl;
import OopsDesignQuestions.ElevatorDesign.ElevatorModel.Elevator;
import OopsDesignQuestions.ElevatorDesign.ElevatorModel.ElevatorImpl;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String... args) {

        ElevatorImpl elevator = new ElevatorImpl(10, 20);

        List<Elevator> elevatorList = new ArrayList<>();
        elevatorList.add(elevator);
        ElevatorController controller = new ElevatorControllerImpl(elevatorList);

        controller.processElevatorRequest(4);
        controller.processElevatorRequest(5);
        controller.processElevatorRequest(6);
        controller.processElevatorRequest(11);
        controller.processElevatorRequest(3);
        controller.processElevatorRequest(2);
        controller.processElevatorRequest(1);

        controller.groundAllElevators();

    }
}
