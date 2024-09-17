package com.calvintam.ceilingfan;

public enum FanDirection {
    CLOCKWISE("Clockwise"), ANTICLOCKWISE("Anticlockwise");

    public final String label;

    private FanDirection(String label){
        this.label = label;
    }
}
