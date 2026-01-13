package com.legxshi.notelemetry;

import net.labymod.api.Laby;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;
import java.lang.reflect.Field;
import java.util.Optional;

@AddonMain
public class NoTelemetry extends LabyAddon<NoTelemetryConfiguration> {

    @Override
    protected void enable() {
        this.registerSettingCategory();
        this.setupTelemetryBlock();

        this.logger().info("NoTelemetry enabled.");
    }

    private void setupTelemetryBlock() {
        if (!this.configuration().disableLabyTelemetry().get()) return;

        Optional<Object> labyConnectOpt = Optional.ofNullable(Laby.labyAPI().labyConnect());

        labyConnectOpt.ifPresent(connect -> {
            try {
                Field snooper = connect.getClass().getDeclaredField("snooper");
                snooper.setAccessible(true);
                snooper.set(connect, null);

                this.logger().info("Laby's snooper was disabled!");
            } catch (Throwable ignored) {}
        });
    }

    @Override
    protected Class<NoTelemetryConfiguration> configurationClass() {
        return NoTelemetryConfiguration.class;
    }
}
