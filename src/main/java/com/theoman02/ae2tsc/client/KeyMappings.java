package com.theoman02.ae2tsc.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

public final class KeyMappings {
    public static final Lazy<KeyMapping> SCROLL_MODIFIER_MAPPING =
            Lazy.of(() -> new KeyMapping(
                    "key.ae2tsc.scroll_modifier",
                    KeyConflictContext.UNIVERSAL,
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_UNKNOWN,
                    "key.categories.ae2tsc"
            ));

    private KeyMappings() {
    }

    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(SCROLL_MODIFIER_MAPPING.get());
    }
}
