package com.company;

/**
 * Created by Pablo on 14/3/2017.
 */
public class Elevator {

    //1
    private Integer numberOfFloors = 1;
    private Boolean[] floorRequests;
    private Integer currentFloor;
    private Boolean goingUp;


    public Elevator(final Integer aNumberOfFloors) {
        floorRequests = new Boolean[aNumberOfFloors];
        //1
        this.numberOfFloors = aNumberOfFloors;
        //2
        this.currentFloor = 0;
        this.goingUp = true;
    }

    public void move(final int floor) {
        if (isValidFloor(floor)) {
            if (this.currentFloor > floor
                    || floor == this.numberOfFloors) {
                this.goingUp = false;
            }
            if (this.currentFloor < floor
                || floor == 0){
                this.goingUp = true;
            }
            this.currentFloor = floor;
            this.floorRequests[floor] = false;
        }
    }

    //3
    //6
    public void requestFloor(final int floor) {
        if (isValidFloor(floor)) {
            this.floorRequests[floor] = true;
        }
    }

    private Boolean isValidFloor(final int floor) {
        if (floor <= this.numberOfFloors &&
                floor >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean hasRequestsAbove() {
        for (int i = currentFloor + 1; i <= numberOfFloors; i++) {
            if (floorRequests[i] == true) {
                return true;
            }
        }
        return false;
    }

    public Boolean hasRequestsBelow() {
        for (int i = currentFloor - 1; i >= 0; i--) {
            if (floorRequests[i] == true) {
                return true;
            }
        }
        return false;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public Boolean[] getFloorRequests() {
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
