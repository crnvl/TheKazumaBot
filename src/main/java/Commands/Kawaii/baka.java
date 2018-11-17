package Commands.Kawaii;

import Commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class baka implements Command {
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
                            .setDescription("B-BAKA! **" + msg + "**")
                            .setImage("https://pa1.narvii.com/6347/f98c95f495ba2e5f4c5a62617942c86bbae4fe0a_hq.gif").build()).queue();
    }
}
