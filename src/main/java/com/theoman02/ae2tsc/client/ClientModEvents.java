package com.theoman02.ae2tsc.client;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

public final class ClientModEvents {
    private ClientModEvents() {
    }

    public static void init(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(KeyMappings::registerBindings);
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}