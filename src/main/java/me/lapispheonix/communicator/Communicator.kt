package me.lapispheonix.communicator

import org.bukkit.plugin.java.JavaPlugin

import me.lapispheonix.communicator.commands.SharePos

class Communicator : JavaPlugin() {
    override fun onEnable() {
        logger.info("Loading")
        registerCommands()
        logger.info("Loaded")
        logger.info("Support My Creator! https://www.youtube.com/channel/UC0JbuZxOU1b0lC6N_Js7_sg")
    }

    private fun registerCommands() {
        getCommand("sendpos")?.setExecutor(SharePos())
    }

    override fun onDisable() {
        // Plugin shutdown logic
        logger.info("Shutting Down")
    }
}
