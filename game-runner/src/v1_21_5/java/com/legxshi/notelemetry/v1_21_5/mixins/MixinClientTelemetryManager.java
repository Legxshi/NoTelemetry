package com.legxshi.notelemetry.v1_21_5.mixins;

import net.minecraft.client.telemetry.ClientTelemetryManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(ClientTelemetryManager.class)
public class MixinClientTelemetryManager {

    @Redirect(
        method = "createEventSender",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/Minecraft;allowsTelemetry()Z"
        )
    )
    private boolean noTelemetry$stopTelemetry(@Coerce Object minecraftClient) {
        return false;
    }
}
