package Commands.BotCmds;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdVote implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getTextChannel().sendMessage(

                new EmbedBuilder()
                        .setColor(STATIC.MAIN)
                        .setTitle("Get more features by voting!")
                        .setDescription("You can click [here](https://discordbots.org/bot/406097711603908621/vote) to vote!")
                        .build()

        ).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
