package com.theoman02.ae2tsc.client;

import com.theoman02.ae2tsc.config.ClientConfig;
import de.mari_023.ae2wtlib.api.AE2wtlibAPI;
import de.mari_023.ae2wtlib.api.terminal.IUniversalTerminalCapable;

public final class CycleHandler {
    private static long lastScrollCycleTimeMs;

    private CycleHandler() {
    }

    public static boolean handleScroll(IUniversalTerminalCapable terminal, double deltaY, boolean scrollModifierDown) {

        if (deltaY == 0 || !scrollModifierDown) {
            return false;
        }

        long currentTimeMs = System.currentTimeMillis();
        if (currentTimeMs - lastScrollCycleTimeMs < ClientConfig.SCROLL_CYCLE_DELAY_MS.get()) {
            return true;
        }

        lastScrollCycleTimeMs = currentTimeMs;

        // By default, scrolling up cycles backwards. If invert is enabled,
        // flip that result so the same scroll direction cycles the other way.
        boolean previous = (deltaY > 0) != ClientConfig.INVERT_MOUSE_SCROLL_CYCLING.get();

        cycleTerminal(terminal, previous);
        return true;
    }

    @SuppressWarnings("UnstableApiUsage")
    private static void cycleTerminal(IUniversalTerminalCapable terminal, boolean previous) {
        terminal.storeState();
        AE2wtlibAPI.cycleTerminal(previous);
    }
}
