package Commands.DiscordBotsOrg;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.discordbots.api.client.DiscordBotListAPI;

import java.util.Random;

public class cmdStatistics implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        Random linkNew = new Random();
        int y = linkNew.nextInt(121) + 1;

        event.getTextChannel().sendMessage(
                new EmbedBuilder()
                        .setColor(STATIC.MAIN)
                        .setTitle("My Statistics on discordbots.org", "https://discordbots.org")
                        .addField("Vote for me!", "[Vote on discordbots.org](https://discordbots.org/bot/406097711603908621)", false)
                        .setImage("https://discordbots.org/api/widget/406097711603908621.png?usernamecolor=FFFFFF&topcolor=000000&ran=" + y).build()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

}
