/*
 * Copyright (C) isXander [2020 - 2021]
 * This program comes with ABSOLUTELY NO WARRANTY
 * This is free software, and you are welcome to redistribute it
 * under the certain conditions that can be found here
 * https://www.gnu.org/licenses/lgpl-3.0.en.html
 *
 * If you would like to enquire about using this code,
 * contact isXander @ "business.isxander@gmail.com"
 */

package co.uk.isxander.betterparticles;

import co.uk.isxander.betterparticles.command.BetterParticlesCommand;
import co.uk.isxander.betterparticles.config.BetterParticlesConfig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(name = BetterParticles.NAME, modid = BetterParticles.MOD_ID, version = BetterParticles.VERSION)
public class BetterParticles {

    public static final String NAME = "isXander's BetterParticles Mod";
    public static final String MOD_ID = "betterparticles";
    public static final String VERSION = "1.0";

    @Mod.Instance
    private static BetterParticles instance = new BetterParticles();

    private BetterParticlesConfig config;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModCoreInstaller.initializeModCore(Minecraft.getMinecraft().mcDataDir);
        config = new BetterParticlesConfig();
        config.preload();

        ClientCommandHandler.instance.registerCommand(new BetterParticlesCommand(this));
    }

    public static BetterParticles getInstance() {
        return instance;
    }

    public BetterParticlesConfig getConfig() {
        if (config == null) {
            config = new BetterParticlesConfig();
            config.preload();
        }
        return config;
    }

}
