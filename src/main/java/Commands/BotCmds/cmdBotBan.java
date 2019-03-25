package Commands.BotCmds;

import Commands.Command;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdBotBan implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(event.getAuthor().getId().contains("265849018662387712") || event.getAuthor().getId().contains("414755070161453076")) {

            event.getTextChannel().sendMessage("User " + args[0] + " got banned from Kazuma").queue();


            event.getJDA().getGuildById("559488253376462878").getController().createTextChannel(args[0]).queue();
        }


    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
