/*
 * Copyright (C) isXander [2020 - 2021]
 * This program comes with ABSOLUTELY NO WARRANTY
 * This is free software, and you are welcome to redistribute it
 * under the certain conditions that can be found here
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * If you would like to enquire about using this code,
 * contact isXander @ "business.isxander@gmail.com"
 */

package co.uk.isxander.betterparticles.mixin.impl;

import co.uk.isxander.betterparticles.BetterParticles;
import co.uk.isxander.betterparticles.config.BetterParticlesConfig;
import co.uk.isxander.betterparticles.utils.MathUtils;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityFX.class)
public abstract class MixinEntityFX {

    @Shadow public abstract void setAlphaF(float alpha);
    @Shadow public abstract float getAlpha();

    @Shadow protected int particleAge;
    @Shadow protected int particleMaxAge;

    @Inject(method = "renderParticle", at = @At("HEAD"))
    private void injectOpacity(WorldRenderer worldRendererIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ, CallbackInfo ci) {
        BetterParticlesConfig cfg = BetterParticles.getInstance().getConfig();
        if (!cfg.enabled) return;
        float alpha = 1 - MathUtils.getPercent(particleAge, particleMaxAge * (cfg.minParticleAlpha / 100f), particleMaxAge);

        if (getAlpha() != alpha)
            setAlphaF(alpha);
    }

}
