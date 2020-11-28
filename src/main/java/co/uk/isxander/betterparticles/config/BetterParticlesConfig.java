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
            description = "Changes how fast the opacity of particles change.\n§7If you set it to 0, it will be disabled.",
            category = "Looks",
            subcategory = "General",
            max = 5
    )
    public int opacitySpeed = 3;

    @Property(
            type = PropertyType.SWITCH,
            name = "Always Sharpness",
            description = "Always spawns sharpness particles, even if you don't have sharpness.",
            category = "Multiplier",
            subcategory = "Sharpness"
    )
    public boolean alwaysSharp = false;

    @Property(
            type = PropertyType.SLIDER,
            name = "Sharpness Multiplier",
            description = "Determines how many sharpness particles spawn.",
            category = "Multiplier",
            subcategory = "Sharpness",
            min = 1,
            max = 20
    )
    public int sharpMultiplier = 2;

    @Property(
            type = PropertyType.SWITCH,
            name = "Always Critical",
            description = "Always spawns critical particles, even if you don't have a crit hit.",
            category = "Multiplier",
            subcategory = "Criticals"
    )
    public boolean alwaysCrit = false;

    @Property(
            type = PropertyType.SLIDER,
            name = "Critical Multiplier",
            description = "Determines how many critical particles spawn.",
            category = "Multiplier",
            subcategory = "Criticals",
            min = 1,
            max = 20
    )
    public int critMultiplier = 2;

    public BetterParticlesConfig() {
        super(new File("./config/betterparticles.toml"));
        initialize();
    }

}
