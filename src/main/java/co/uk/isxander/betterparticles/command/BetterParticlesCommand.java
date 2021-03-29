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

package co.uk.isxander.betterparticles.command;

import club.sk1er.mods.core.ModCore;
import co.uk.isxander.betterparticles.BetterParticles;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class BetterParticlesCommand extends CommandBase {

    private final BetterParticles mod;

    public BetterParticlesCommand(BetterParticles mod) {
        this.mod = mod;
    }

    @Override
    public String getCommandName() {
        return "betterparticles";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return -1;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        ModCore.getInstance().getGuiHandler().open(mod.getConfig().gui());
    }

}
