package co.uk.isxander.betterparticles.mixins.impl;

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

    @Inject(method = "renderParticle", at = @At("HEAD"))
    private void injectOpacity(WorldRenderer worldRendererIn, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ, CallbackInfo ci) {
        BetterParticlesConfig cfg = BetterParticles.getInstance().getConfig();
        if (!cfg.enabled || cfg.opacitySpeed == 0) return;

        setAlphaF(MathUtils.lerp(getAlpha(), 0, partialTicks * (cfg.opacitySpeed / 100f)));
    }

}
