package Commands.DiscordBotsOrg;

import Commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdStatistics implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(
                new EmbedBuilder()
                        .setTitle("My Statistics on discordbots.org", "https://discordbots.org")
                        .addField("Vote for me!", "[Vote on discordbots.org](https://discordbots.org/bot/406097711603908621)", false)
                        .setImage("https://discordbots.org/api/widget/406097711603908621.png?usernamecolor=FFFFFF&topcolor=000000").build()).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

}
