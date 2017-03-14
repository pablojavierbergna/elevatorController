package com.company;

/**
 * Created by Pablo on 14/3/2017.
 */
public class ElevatorController {

    static final Integer NUMBER_OF_FLOORS = 5;
    private Elevator elevator;

    ElevatorController(Elevator anElevator) {
        this.elevator = anElevator;
    }

    public void main() {

        while (true) {
            for (int i = 0; i <= NUMBER_OF_FLOORS; i++) {
                if (this.elevator.getFloorRequests()[i] == true) {
                    this.moveElevator();
                }
            }
        }
    }

    public void moveElevator() {
        if (this.elevator.getGoingUp() == true) {
            if (hasRequestsAbove()) {
                serveRequests(this.elevator.getCurrentFloor(), NUMBER_OF_FLOORS);
            }
        } else {

        }
    }

    public void serveRequests(final int from, final int to) {

        //up
        if (from < to) {
            for (int i = this.elevator.getCurrentFloor() + 1; i <= NUMBER_OF_FLOORS; i++) {
                if (this.elevator.getFloorRequests()[i] == true) {
                    this.elevator.moveElevator(i);
                }
            }
        } else {
            //down
            for (int i = this.elevator.getCurrentFloor() - 1; i > 0; i--) {
                if (this.elevator.getFloorRequests()[i] == true) {
                    this.elevator.moveElevator(i);
                }
            }
        }
    }

    public Boolean hasRequestsAbove() {
        for (int i = this.elevator.getCurrentFloor() + 1; i <= NUMBER_OF_FLOORS; i++) {
            if (this.elevator.getFloorRequests()[i] == true) {
                return true;
            }
        }
        return false;
    }

    public Boolean hasRequestsBelow() {
        for (int i = this.elevator.getCurrentFloor() - 1; i <= NUMBER_OF_FLOORS; i--) {
            if (this.elevator.getFloorRequests()[i] == true) {
                return true;
            }
        }
        return false;
    }

}