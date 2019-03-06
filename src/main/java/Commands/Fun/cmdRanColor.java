package Commands.Fun;

import Commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Random;

public class cmdRanColor implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        Random NumGen = new Random();
        int r = NumGen.nextInt(256);
        int g = NumGen.nextInt(256);
        int b = NumGen.nextInt(256);
        Color GenColor = new Color(r,g,b);
        String hex = Integer.toHexString(GenColor.getRGB() & 0xffffff);
        if (hex.length() < 6) {
            hex = "0" + hex;
        }
        hex = "#" + hex;
        event.getMessage().getTextChannel().sendMessage(
                new EmbedBuilder()
                        .setTitle("Color Generator")
                        .setDescription("Your Color has been created!")
                        .addField("RGB", r + ", " + g + ", " + b, false)
                        .addField("Hex-Code", hex, false)
                        .setColor(GenColor)
                        .build()).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
