package OopsDesignQuestions.ElevatorDesign.ElevatorModel;

import OopsDesignQuestions.ElevatorDesign.Direction;

import java.util.Deque;

public abstract class Elevator {

    protected int topFloor = 0;
    protected int currFloor = 0;
    protected Direction direction = Direction.Stopped;
    protected int maxCapacity;
    protected Deque<Integer> destinationQueue;

    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void stop(int floor);
    public abstract void requestFloor(int floor);
    public abstract void run();
    public abstract boolean isInPath(int floor);
    public abstract void groundElevator();

    public int getCurrFloor() {
        return currFloor;
    }

    public void setCurrFloor(int currFloor) {
        this.currFloor = currFloor;
    }

    public Deque<Integer> getDestinationQueue() {
        return destinationQueue;
    }

    public void setDestinationQueue(Deque<Integer> destinationQueue) {
        this.destinationQueue = destinationQueue;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
