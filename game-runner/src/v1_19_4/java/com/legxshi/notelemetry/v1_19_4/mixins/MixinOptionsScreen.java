package com.legxshi.notelemetry.v1_19_4.mixins;

import net.minecraft.client.gui.screens.OptionsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Group;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(OptionsScreen.class)
public class MixinOptionsScreen {

    @Redirect(
        method = "init",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/gui/layouts/GridLayout$RowHelper;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;)Lnet/minecraft/client/gui/layouts/LayoutElement;",
            ordinal = 0
        ),
        slice = @Slice(
            from = @At(
                value = "FIELD",
                target = "Lnet/minecraft/client/gui/screens/OptionsScreen;TELEMETRY:Lnet/minecraft/network/chat/Component;"
            )
        )
    )
    @SuppressWarnings("InvalidInjectorMethodSignature")
    private @Coerce Object noTelemetry$stopTelemetry(@Coerce Object adder, @Coerce Object widget) {
        return widget;
    }
}
