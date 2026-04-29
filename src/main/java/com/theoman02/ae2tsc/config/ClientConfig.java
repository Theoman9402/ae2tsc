package com.theoman02.ae2tsc.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class ClientConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue INVERT_MOUSE_SCROLL_CYCLING = BUILDER
            .comment("Invert the scroll direction used for terminal cycling.")
            .define("invertMouseScrollCycling", false);

    public static final ModConfigSpec.IntValue SCROLL_CYCLE_DELAY_MS = BUILDER
            .comment("Delay in milliseconds between scroll-based terminal cycles.")
            .defineInRange("scrollCycleDelayMs", 150, 100, 2000);

    public static final ModConfigSpec SPEC = BUILDER.build();

    private ClientConfig() {
    }
}
