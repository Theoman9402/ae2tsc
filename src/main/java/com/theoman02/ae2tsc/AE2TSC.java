package com.theoman02.ae2tsc;

import com.theoman02.ae2tsc.client.ClientModEvents;
import com.theoman02.ae2tsc.config.ClientConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(value = AE2TSC.MODID, dist = Dist.CLIENT)
public class AE2TSC {
    public static final String MODID = "ae2tsc";

    public AE2TSC(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);
        ClientModEvents.init(modEventBus, modContainer);
    }
}