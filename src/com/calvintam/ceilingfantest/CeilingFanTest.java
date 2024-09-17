package com.calvintam.ceilingfantest;

import com.calvintam.ceilingfan.CeilingFan;
import com.calvintam.ceilingfan.FanDirection;
import com.calvintam.ceilingfan.FanSpeed;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CeilingFanTest {

    private CeilingFan fan;

    @Before
    public void setUp() {
        fan = new CeilingFan(); // Initialize before each test
    }

    // Test that initial state is OFF and not reversed
    @Test
    public void testInitialState() {
        assertEquals(FanSpeed.OFF, fan.getFanSpeed());
        assertEquals(FanDirection.CLOCKWISE, fan.getFanDirection());
    }

    // Test speed transitions from 0 to 3 and back to 0
    @Test
    public void testSpeedCordPull() {
        fan.pullSpeedCord();
        assertEquals(FanSpeed.LOW, fan.getFanSpeed()); // After first pull, speed = 1

        fan.pullSpeedCord();
        assertEquals(FanSpeed.MEDIUM, fan.getFanSpeed()); // After second pull, speed = 2

        fan.pullSpeedCord();
        assertEquals(FanSpeed.HIGH, fan.getFanSpeed()); // After third pull, speed = 3

        fan.pullSpeedCord();
        assertEquals(FanSpeed.OFF, fan.getFanSpeed()); // After fourth pull, speed cycles back to 0
    }

    // Test direction changes
    @Test
    public void testDirectionCordPull() {
        fan.pullDirectionCord();
        assertEquals(FanDirection.ANTICLOCKWISE, fan.getFanDirection());

        fan.pullDirectionCord();
        assertEquals(FanDirection.CLOCKWISE, fan.getFanDirection());
    }

    // Test that speed and direction interact correctly
    @Test
    public void testSpeedAndDirectionTogether() {
        fan.pullSpeedCord(); // Set speed to 1
        fan.pullDirectionCord(); // Reverse direction
        assertEquals(FanSpeed.LOW, fan.getFanSpeed());
        assertEquals(FanDirection.ANTICLOCKWISE, fan.getFanDirection());

        fan.pullSpeedCord(); // Set speed to 2
        assertEquals(FanSpeed.MEDIUM, fan.getFanSpeed());
        assertEquals(FanDirection.ANTICLOCKWISE, fan.getFanDirection());    //Direction remains anticlockwise

        fan.pullDirectionCord(); // Reverse again
        assertEquals(FanSpeed.MEDIUM, fan.getFanSpeed());   //Speed remains at Speed 2
        assertEquals(FanDirection.CLOCKWISE, fan.getFanDirection()); // Direction should be clockwise now
    }
}