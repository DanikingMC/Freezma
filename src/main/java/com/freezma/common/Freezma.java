package com.freezma.common;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class Freezma implements ModInitializer {

    public static final String MODID = "freezma";
    public static FreezmaConfig config;

    @Override
    public void onInitialize() {
        AutoConfig.register(FreezmaConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(FreezmaConfig.class).getConfig();
    }
}
