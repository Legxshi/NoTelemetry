package com.legxshi.notelemetry.v1_8_9.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.profiler.PlayerUsageSnooper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerUsageSnooper.class)
public class MixinPlayerUsageSnooper {

    @Inject(
        method = "startSnooper",
        at = @At("HEAD"),
        cancellable = true
    )
    private void noTelemetry$stopSnooper(CallbackInfo ci) {
        Minecraft.getMinecraft().gameSettings.snooperEnabled = false; // always disable it
        ci.cancel();
    }
}
