package Commands.Fun;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdSay implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        String MESSAGE = event.getMessage().getContentRaw().replace(STATIC.PREFIX + "say ", "");

        event.getTextChannel().sendMessage(

                new EmbedBuilder()
                        .setDescription(MESSAGE)
                .build()

        ).queue();
        event.getMessage().delete().queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
