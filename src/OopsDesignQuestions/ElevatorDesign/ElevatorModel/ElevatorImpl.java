package OopsDesignQuestions.ElevatorDesign.ElevatorModel;

import OopsDesignQuestions.ElevatorDesign.Direction;

import java.util.ArrayDeque;
import java.util.Comparator;

public class ElevatorImpl extends Elevator {

    public ElevatorImpl(int topFloor, int maxCapacity) {
        this.topFloor = topFloor;
        this.maxCapacity = maxCapacity;

        this.destinationQueue = new ArrayDeque<>();
    }

    @Override
    public void moveUp() {

        if (this.currFloor == this.topFloor) {
            System.out.println("cannot move above max currentFloor");
            return;
        }

        destinationQueue.stream().mapToInt(i->i).sorted().forEach(num-> {
            stop(num);
        });
        this.direction = Direction.Stopped;
    }

    @Override
    public void moveDown() {

        if (this.currFloor == 0) {
            System.out.println("cannot move below minimum currentFloor");
            return;
        }
        destinationQueue.stream().sorted(Comparator.reverseOrder()).forEach(num-> {
            stop(num);
        });

        this.direction = Direction.Stopped;
    }

    @Override
    public void stop(int floor) {
        destinationQueue.remove(floor);
        currFloor = floor;
        System.out.println("Stopped at floor : " + this.currFloor);
    }

    @Override
    public void requestFloor(int floor) {
        if(!destinationQueue.contains(floor)) {
            destinationQueue.add(floor);
        }
        run();
    }

    @Override
    public void run() {
        int destination = destinationQueue.peek();
        System.out.println("Current Floor " + currFloor);
        if(this.currFloor < destination) {
            this.direction = Direction.Up;
            moveUp();
        }
        else if(this.currFloor > destination) {
            this.direction = Direction.Down;
            moveDown();
        }

        if (this.currFloor == destination) {
            destinationQueue.poll();
        }
    }

    @Override
    public boolean isInPath(int floor) {
        int destination = destinationQueue.peek();
        if( (direction == Direction.Down && floor >= destination) || (direction.equals(Direction.Up) && floor<= destination) ) {
            return true;
        }
        return false;
    }

    @Override
    public void groundElevator() {
        this.currFloor = 0;
    }
}