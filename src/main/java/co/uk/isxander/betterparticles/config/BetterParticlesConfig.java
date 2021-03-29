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
            name = "Minimum Particle Alpha",
            description = "What is the minimum transparency a particle can have.",
            category = "General",
            subcategory = "General",
            max = 100,
            min = 0
    )
    public int minParticleAlpha = 0;

    public BetterParticlesConfig() {
        super(new File("./config/betterparticles.toml"));
        initialize();
        preload();
    }

}
