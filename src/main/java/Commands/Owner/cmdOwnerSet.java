package Commands.Owner;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.discordbots.api.client.DiscordBotListAPI;



public class cmdOwnerSet implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(event.getAuthor().getId().contains("265849018662387712")) {
            event.getJDA().getGuildById("552539681212989450").getController().createTextChannel(args[0]).queue();
            event.getTextChannel().sendMessage(event.getJDA().getUserById(args[0]) + " with the ID " + args[0] + " has been registered for the Global Chat!").queue();


        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
