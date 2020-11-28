package co.uk.isxander.betterparticles;

import co.uk.isxander.betterparticles.command.BetterParticlesCommand;
import co.uk.isxander.betterparticles.config.BetterParticlesConfig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(name = BetterParticles.NAME, modid = BetterParticles.MODID, version = BetterParticles.VERSION, clientSideOnly = true, acceptedMinecraftVersions = "[1.8.9]")
public class BetterParticles {

    public static final String NAME = "isXander's BetterParticles Mod";
    public static final String MODID = "betterparticles";
    public static final String VERSION = "1.0";

    @Mod.Instance
    private static final BetterParticles instance = new BetterParticles();

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
        return config;
    }

}
