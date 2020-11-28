package co.uk.isxander.betterparticles.mixins.impl;

import co.uk.isxander.betterparticles.BetterParticles;
import co.uk.isxander.betterparticles.config.BetterParticlesConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP {

    @Shadow protected Minecraft mc;

    /**
     * @author isXander
     * @reason Multiply critical particles
     */
    @Overwrite
    public void onCriticalHit(Entity entityHit) {
        BetterParticlesConfig cfg = BetterParticles.getInstance().getConfig();
        int multiplier = cfg.critMultiplier;
        if (cfg.alwaysCrit || !cfg.enabled) multiplier = 1;
        for (int i = 0; i < multiplier; i++) {
            this.mc.effectRenderer.emitParticleAtEntity(entityHit, EnumParticleTypes.CRIT);
        }
    }

    /**
     * @author isXander
     * @reason Multiply sharp particles
     */
    @Overwrite
    public void onEnchantmentCritical(Entity entityHit) {
        BetterParticlesConfig cfg = BetterParticles.getInstance().getConfig();
        int multiplier = cfg.sharpMultiplier;
        if (cfg.alwaysSharp || !cfg.enabled) multiplier = 1;
        for (int i = 0; i < multiplier; i++) {
            this.mc.effectRenderer.emitParticleAtEntity(entityHit, EnumParticleTypes.CRIT_MAGIC);
        }
    }

}
