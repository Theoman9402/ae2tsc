package com.theoman02.ae2tsc;

import com.theoman02.ae2tsc.client.ClientModEvents;
import com.theoman02.ae2tsc.config.ClientConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(AE2TSC.MODID)
public class AE2TSC {
    public static final String MODID = "ae2tsc";

    public AE2TSC(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.CLIENT, ClientConfig.SPEC);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            ClientModEvents.init(modEventBus, modContainer);
        }
    }
}