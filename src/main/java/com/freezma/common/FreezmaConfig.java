package com.freezma.common;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = Freezma.MODID)
public class FreezmaConfig implements ConfigData {

    public int FreezingMs = 3000;
    public int amplifier = 2;
    public boolean worksOnPlayers = false;

}
