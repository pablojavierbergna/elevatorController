package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Pablo on 14/3/2017.
 */
public class Elevator {

    //1
    private Integer numberOfFloors;
    private AtomicBoolean[] floorRequests;
    private Integer currentFloor;
    private Boolean goingUp;


    public Elevator(final Integer aNumberOfFloors) {
        this.floorRequests = new AtomicBoolean[aNumberOfFloors];
        for (int i = 0; i < aNumberOfFloors; i++) {
            this.floorRequests[i] = new AtomicBoolean(false);
        }
        //1
        this.numberOfFloors = aNumberOfFloors;
        //2
        this.currentFloor = 0;
        this.goingUp = true;
    }

    public void move(final int floor) {
        if (isValidFloor(floor)) {
            if (this.currentFloor > floor
                    || floor == this.numberOfFloors-1) {
                this.goingUp = false;
            }
            if (this.currentFloor < floor
                || floor == 0){
                this.goingUp = true;
            }
            this.currentFloor = floor;
            this.floorRequests[floor].set(false);
        }
    }

    //3
    //6
    public void requestFloor(final int floor) {
        if (isValidFloor(floor)) {
            this.floorRequests[floor].set(true);
        }
    }

    private Boolean isValidFloor(final int floor) {
        if (floor <= this.numberOfFloors-1 &&
                floor >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean hasRequestsAbove() {
        for (int i = currentFloor + 1; i < numberOfFloors; i++) {
            if (floorRequests[i].get() == true) {
                return true;
            }
        }
        return false;
    }

    public Boolean hasRequestsBelow() {
        for (int i = currentFloor - 1; i >= 0; i--) {
            if (floorRequests[i].get() == true) {
                return true;
            }
        }
        return false;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public AtomicBoolean[] getFloorRequests() {
        return floorRequests;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public Boolean getGoingUp() {
        return goingUp;
    }

    public void setGoingUp(final Boolean value) {
        this.goingUp = value;
    }
}
