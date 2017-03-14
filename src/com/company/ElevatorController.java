package com.company;

/**
 * Created by Pablo on 14/3/2017.
 */
public class ElevatorController {

    private Elevator elevator;

    public ElevatorController(final Elevator anElevator) {
        this.elevator = anElevator;
    }

    public void main() {

        while (true) {
            for (int i = 0; i <= this.elevator.getNumberOfFloors(); i++) {
                if (this.elevator.getFloorRequests()[i] == true) {
                    this.moveElevator();
                }
            }
        }
    }

    public void requestFloor(final int floor) {
        this.elevator.requestFloor(floor);
    }

    public void moveElevator() {

        if (this.elevator.getGoingUp() == true &&
                !this.elevator.hasRequestsAbove()) {
            this.elevator.setGoingUp(false);
        }
        if (this.elevator.getGoingUp() == false &&
                !this.elevator.hasRequestsBelow()) {
            this.elevator.setGoingUp(true);
        }

        if (this.elevator.getGoingUp() == true &&
                this.elevator.hasRequestsAbove()) {

            for (int i = this.elevator.getCurrentFloor() + 1; i <= this.elevator.getNumberOfFloors(); i++) {
                if (this.elevator.getFloorRequests()[i] == true) {
                    this.elevator.move(i);
                }
            }
        } else {
            if (this.elevator.getGoingUp() == false &&
                    this.elevator.hasRequestsBelow()) {
                for (int i = this.elevator.getCurrentFloor() - 1; i >= 0; i--) {
                    if (this.elevator.getFloorRequests()[i] == true) {
                        this.elevator.move(i);
                    }
                }
            }
        }
    }
}