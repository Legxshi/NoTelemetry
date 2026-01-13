package com.legxshi.notelemetry.v1_12_2.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.profiler.Snooper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Snooper.class)
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
