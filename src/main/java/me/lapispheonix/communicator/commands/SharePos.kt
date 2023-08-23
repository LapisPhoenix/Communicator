package me.lapispheonix.communicator.commands

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import kotlin.math.roundToInt

class SharePos: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        if (args.isEmpty()){
            sender.sendMessage(Component.text("You must specify a person to message.").color(TextColor.color(255, 75, 0)))
            return false
        }

        val target = Bukkit.getPlayer(args[0])

        if (target == null) {
            sender.sendMessage(Component.text("That player cannot be found!").color(TextColor.color(255, 75, 0)))
            return false
        }

        val distanceBetweenPlayers = sender.location.distance(target.location).roundToInt()

        val message = """Hey! ${sender.name} wants to send you their coordinates!
            | Coordinates: X: ${sender.location.x.roundToInt()}, Y: ${sender.location.y.roundToInt()}, Z: ${sender.location.z.roundToInt()} ($distanceBetweenPlayers Blocks Away.)
        """.trimMargin()

        target.sendMessage(Component.text(message).color(TextColor.color(0, 255, 75)))
        sender.sendMessage(Component.text("Message Sent!").color(TextColor.color(0, 255, 75)))
        return true
    }
}