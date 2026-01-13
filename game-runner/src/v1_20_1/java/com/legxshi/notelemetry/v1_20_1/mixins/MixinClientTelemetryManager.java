package com.legxshi.notelemetry.v1_20_1.mixins;

import net.minecraft.client.telemetry.ClientTelemetryManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(ClientTelemetryManager.class)
public class MixinClientTelemetryManager {

    @Redirect(
        method = "createEventSender",
        at = @At(
            value = "FIELD",
            target = "Lnet/minecraft/SharedConstants;IS_RUNNING_IN_IDE:Z"
        )
    )
    private boolean noTelemetry$stopTelemetry() {
        return true;
    }
}
