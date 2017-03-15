package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Pablo on 14/3/2017.
 */
public class ElevatorController implements Runnable{

    private Elevator elevator;

    public ElevatorController(final Elevator anElevator) {
        this.elevator = anElevator;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < this.elevator.getNumberOfFloors(); i++) {
                if (this.elevator.getFloorRequests()[i].get() == true) {
                    this.moveElevator();
                }
            }
        }
    }

    public synchronized void requestFloor(final int floor) {
        this.elevator.requestFloor(floor);
    }

    public synchronized void moveElevator() {

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

            for (int i = this.elevator.getCurrentFloor() + 1; i < this.elevator.getNumberOfFloors(); i++) {
                if (this.elevator.getFloorRequests()[i].get() == true) {
                    this.elevator.move(i);
                }
            }
        } else {
            if (this.elevator.getGoingUp() == false &&
                    this.elevator.hasRequestsBelow()) {
                for (int i = this.elevator.getCurrentFloor() - 1; i >= 0; i--) {
                    if (this.elevator.getFloorRequests()[i].get() == true) {
                        this.elevator.move(i);
                    }
                }
            }
        }
    }

    public Integer getCurrentFloor() {
        return this.elevator.getCurrentFloor();
    }

    public Elevator getElevator() {
        return this.elevator;
    }
}