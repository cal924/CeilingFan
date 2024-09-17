package com.calvintam.ceilingfan;

public class CeilingFan {
    private FanSpeed fanSpeed;
    private FanDirection fanDirection ;

    public CeilingFan(){
        fanSpeed = FanSpeed.OFF;
        fanDirection = FanDirection.CLOCKWISE;
    }

    public void pullSpeedCord(){
        fanSpeed = FanSpeed.get(fanSpeed.level + 1);
    }

    public void pullDirectionCord(){
        if (fanDirection == FanDirection.CLOCKWISE){
            fanDirection = FanDirection.ANTICLOCKWISE;
        }else{
            fanDirection = FanDirection.CLOCKWISE;
        }
    }

    public String getStatus(){
        return "Fan is running at " + getFanSpeed().label
                + " with " + getFanDirection().label + ".";
    }

    public FanSpeed getFanSpeed() {
        return fanSpeed;
    }

    public FanDirection getFanDirection() {
        return fanDirection;
    }
}
