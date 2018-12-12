package Commands.BotCmds;

import Commands.Command;
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
                        .setTitle("Bot Invite")
                        .setDescription("You can invite me [here](https://bit.ly/kazumabot) or by visiting my [website](http://kazumabot.rf.gd)!")
                        .build()

        ).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
