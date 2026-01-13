package com.legxshi.notelemetry.v1_21_3.mixins;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Inject(
        method = "allowsTelemetry()Z",
        at = @At("HEAD"),
        cancellable = true
    )
    public void noTelemetry$stopTelemetry(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
