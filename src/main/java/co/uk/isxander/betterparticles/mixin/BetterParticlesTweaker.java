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

package co.uk.isxander.betterparticles.mixin;

import co.uk.isxander.betterparticles.ModCoreInstaller;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.io.File;
import java.util.List;

public class BetterParticlesTweaker implements ITweaker {

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
//        int init = ModCoreInstaller.initialize(Launch.minecraftHome, "1.8.9");
//        System.out.println(init);
//        if (ModCoreInstaller.isErrored() || init != 0 && init != -1) {
//            System.out.println("Failed to load Sk1er Modcore - " + init + " - " + ModCoreInstaller.getError());
//        }
//        if (ModCoreInstaller.isIsRunningModCore()) {
//            System.out.println("modcore installed");
//            classLoader.registerTransformer("club.sk1er.mods.core.forge.ClassTransformer");
//        }

        MixinBootstrap.init();

        MixinEnvironment env = MixinEnvironment.getDefaultEnvironment();
        Mixins.addConfiguration("mixins.betterparticles.json");

        if (env.getObfuscationContext() == null) {
            env.setObfuscationContext("notch");
        }

        env.setSide(MixinEnvironment.Side.CLIENT);
    }

    @Override
    public String getLaunchTarget() {
        return "net.minecraft.client.main.Main";
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }

}
