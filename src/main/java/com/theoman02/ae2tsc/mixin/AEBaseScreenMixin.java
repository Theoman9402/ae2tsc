package com.theoman02.ae2tsc.mixin;

import appeng.client.gui.AEBaseScreen;
import com.theoman02.ae2tsc.client.CycleHandler;
import com.theoman02.ae2tsc.client.KeyMappings;
import com.theoman02.ae2tsc.client.KeyMappingsHelper;
import de.mari_023.ae2wtlib.api.terminal.IUniversalTerminalCapable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AEBaseScreen.class)
public abstract class AEBaseScreenMixin {
    @Inject(method = "mouseScrolled", at = @At("HEAD"), cancellable = true)
    private void ae2tsc$checkScrollCycle(
            double mouseX,
            double mouseY,
            double deltaX,
            double deltaY,
            CallbackInfoReturnable<Boolean> cir
    ) {
        //Only want this to work in terminals or screens supported by AE2WTLib.
        if (!((Object) this instanceof IUniversalTerminalCapable terminal)) {
            return;
        }

        if (CycleHandler.handleScroll(
                terminal,
                deltaY,
                ae2tsc$isScrollModifierDown()
        )) {
            cir.setReturnValue(true);
        }
    }

    private static boolean ae2tsc$isScrollModifierDown() {
        return KeyMappingsHelper.isBoundInputDown(KeyMappings.SCROLL_MODIFIER_MAPPING.get());
    }
}
