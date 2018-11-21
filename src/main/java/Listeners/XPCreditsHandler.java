package Listeners;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.discordbots.api.client.DiscordBotListAPI;

public class XPCreditsHandler extends ListenerAdapter {
    DiscordBotListAPI api = new DiscordBotListAPI.Builder()
            .token(System.getenv("DB_TOKEN"))
            .botId("406097711603908621")
            .build();
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

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
