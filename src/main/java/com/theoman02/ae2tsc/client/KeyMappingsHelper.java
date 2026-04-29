package com.theoman02.ae2tsc.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public final class KeyMappingsHelper {
    private KeyMappingsHelper() {
    }

    public static boolean isBoundInputDown(KeyMapping keyMapping) {
        if (keyMapping.isUnbound()) {
            return false;
        }

        InputConstants.Key key = keyMapping.getKey();
        long window = Minecraft.getInstance().getWindow().getWindow();

        return switch (key.getType()) {
            case KEYSYM, SCANCODE -> InputConstants.isKeyDown(window, key.getValue());
            case MOUSE -> GLFW.glfwGetMouseButton(window, key.getValue()) == GLFW.GLFW_PRESS;
            default -> false;
        };
    }
}