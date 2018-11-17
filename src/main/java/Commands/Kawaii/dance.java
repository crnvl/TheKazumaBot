package Commands.Kawaii;

import Commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class dance implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        List argsList = Arrays.asList(args);
        StringBuilder sb = new StringBuilder();
        argsList.forEach(s -> sb.append(s + " "));
        send(sb.toString(), event);

        //Links

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
    private void send(String msg, MessageReceivedEvent event) {
        if (msg.length() < 1) {
            event.getTextChannel().sendMessage(
                    new EmbedBuilder().setColor(Color.RED)
                            .setDescription("Please enter a word or mention an User").build()).queue();
        }else
            event.getTextChannel().sendMessage(
                    new EmbedBuilder().setColor(Color.PINK)
                            .setDescription("**" + event.getMessage().getAuthor().getName() + "** is dancing with **" + msg + "!**")
                            .setImage("https://cdn.discordapp.com/attachments/404334704804888577/409470024621883392/image.gif").build()).queue();
    }
}

