package Commands.Owner;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.discordbots.api.client.DiscordBotListAPI;



public class cmdOwnerSet implements Command {



    DiscordBotListAPI api = new DiscordBotListAPI.Builder()
            .token(System.getenv("DB_TOKEN"))
            .botId("406097711603908621")
            .build();

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(event.getAuthor().getId().contains("265849018662387712")) {
            int serverCount = event.getJDA().getGuilds().size();

            api.setStats(serverCount);



        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
