package co.uk.isxander.betterparticles.config;

import club.sk1er.vigilance.Vigilant;
import club.sk1er.vigilance.data.Property;
import club.sk1er.vigilance.data.PropertyType;

import java.io.File;

public class BetterParticlesConfig extends Vigilant {

    @Property(
            type = PropertyType.SWITCH,
            name = "BetterParticles",
            description = "Master switch for the mod, if this is off, everything is off.",
            category = "General",
            subcategory = "General"
    )
    public boolean enabled = true;

    @Property(
            type = PropertyType.SLIDER,
            name = "Particle opacity speed",
            description = "Changes how fast the opacity of particles change.\n§8If you set it to 0, it will be disabled.",
            category = "General",
            subcategory = "General",
            max = 5
    )
    public int opacitySpeed = 3;

    public BetterParticlesConfig() {
        super(new File("./config/betterparticles.toml"));
        initialize();
        preload();
    }

}
