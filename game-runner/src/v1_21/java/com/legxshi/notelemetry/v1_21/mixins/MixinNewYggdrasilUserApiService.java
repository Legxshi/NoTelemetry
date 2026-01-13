package com.legxshi.notelemetry.v1_21.mixins;

import com.mojang.authlib.yggdrasil.YggdrasilUserApiService;
import com.mojang.authlib.yggdrasil.response.UserAttributesResponse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(YggdrasilUserApiService.class)
public class MixinNewYggdrasilUserApiService {

    @Redirect(
        method = "fetchProperties",
        at = @At(
            value = "INVOKE",
            target = "Lcom/mojang/authlib/yggdrasil/response/UserAttributesResponse$Privileges;getTelemetry()Z",
            remap = false
        ),
        remap = false,
        require = 0
    )
    private boolean noTelemetry$stopTelemetry(UserAttributesResponse.Privileges privileges) {
        return false;
    }
}
