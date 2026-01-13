package com.legxshi.notelemetry.v1_21_11.mixins;

import com.mojang.authlib.minecraft.TelemetrySession;
import com.mojang.authlib.yggdrasil.YggdrasilUserApiService;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.Executor;

@Mixin(YggdrasilUserApiService.class)
public class MixinYggdrasilUserApiService {

    @Inject(
        method = "newTelemetrySession",
        at = @At("HEAD"),
        remap = false,
        cancellable = true
    )
    private void noTelemetry$stopTelemetry(Executor executor, CallbackInfoReturnable<TelemetrySession> cir) {
        cir.setReturnValue(TelemetrySession.DISABLED);
        cir.cancel();
    }
}
