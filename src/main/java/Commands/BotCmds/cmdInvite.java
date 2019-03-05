package Commands.BotCmds;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;


public class cmdInvite implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        event.getTextChannel().sendMessage(

                new EmbedBuilder()
                        .setColor(STATIC.MAIN)
                        .setTitle("Bot Invite")
                        .setDescription("You can invite me [here](https://bit.ly/kazumabot)!")
                        .build()

        ).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
