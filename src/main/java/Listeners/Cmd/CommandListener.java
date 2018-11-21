package Listeners.Cmd;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import Core.Execute.CommandHandler;
import Util.STATIC;
import org.discordbots.api.client.DiscordBotListAPI;

import java.util.Objects;

public class CommandListener extends ListenerAdapter {
    DiscordBotListAPI api = new DiscordBotListAPI.Builder()
            .token(System.getenv("DB_TOKEN"))
            .botId("406097711603908621")
            .build();
    public void onMessageReceived(MessageReceivedEvent event) {

            if (event.getMessage().getContentRaw().startsWith(STATIC.PREFIX)
                    && !Objects.equals(event.getMessage().getAuthor().getId(), event.getJDA().getSelfUser().getId())
                    && !event.getMessage().getAuthor().isBot()) {
                CommandHandler.handleCommand(CommandHandler.parse.parser(event.getMessage().getContentRaw(), event,STATIC.PREFIX));

            } else {
                return;
            }

        String userId = event.getAuthor().getId(); // ID of the user you're checking
        api.hasVoted(userId).whenComplete((hasVoted, e) -> {
            if(hasVoted) {
                if(event.getJDA().getGuildById("514460308488716288").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0) {
                    event.getJDA().getGuildById("514460308488716288").getController().createTextChannel(event.getAuthor().getId()).setTopic("5").complete();
                }else {
                    int VALUE = Integer.parseInt(event.getJDA().getGuildById("514460308488716288").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getTopic());
                    VALUE++;
                    event.getJDA().getGuildById("514460308488716288").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getManager().setTopic(String.valueOf(VALUE)).queue();
                }
            }else {

            }

        });

    }
}
