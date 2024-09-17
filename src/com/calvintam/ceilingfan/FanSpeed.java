package com.calvintam.ceilingfan;

import java.util.HashMap;
import java.util.Map;

public enum FanSpeed {
    OFF("Off", 0),
    LOW("SPEED 1", 1),
    MEDIUM("SPEED 2", 2),
    HIGH("SPEED 3", 3);

    public final String label;
    public final int level;
    private static final Map<Integer, FanSpeed> map = new HashMap<Integer, FanSpeed>();

    private FanSpeed(String label, int level){
        this.label = label;
        this.level = level;
    }

    static{
        for (FanSpeed fs : values()){
            map.put(fs.level, fs);
        }
    }

    public static FanSpeed get(int level){
        return map.get(level % 4);
    }
}
