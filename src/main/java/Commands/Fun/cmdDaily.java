package Commands.Fun;

import Commands.Command;
import Core.Main;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.discordbots.api.client.DiscordBotListAPI;

import java.util.Random;

public class cmdDaily implements Command {
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
        //517023751301234688
        //515083259957346304
        //int countdownSeconds = 86400;
        int countdownSeconds = 86400000;
        int keyValue = Integer.parseInt(event.getJDA().getGuildById("517023751301234688").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getTopic());
        long timestamp = System.currentTimeMillis();
        long userId = event.getAuthor().getIdLong();
        String userIdapi = event.getAuthor().getId(); // ID of the user you're checking
        api.hasVoted(userIdapi).whenComplete((hasVoted, e) -> {
            if (hasVoted) {
                if (event.getJDA().getGuildById("514460308488716288").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0) {
                    if (event.getJDA().getGuildById("517023751301234688").getTextChannelsByName(String.valueOf(userId), true).size() != 0 && timestamp - keyValue < countdownSeconds) {
                        event.getTextChannel().sendMessage(

                                new EmbedBuilder()
                                        .setTitle("Action denied!")
                                        .setDescription("You are just able to claim your daily every 24 hours!")
                                        .build()

                        ).queue();
                    } else {
                        try{
                            event.getJDA().getGuildById("517023751301234688").getController().getGuild().getTextChannelsByName(String.valueOf(userId), true).get(0).delete().queue();
                        }catch (Exception fuck) {

                        }
                        Random rate = new Random();
                        int r = rate.nextInt(30) + 120;
                        if (event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0) {
                            event.getJDA().getGuildById("515083259957346304").getController().createTextChannel(event.getAuthor().getId()).setTopic(String.valueOf(r)).complete();
                        } else {
                            event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getManager().setTopic(String.valueOf(r)).queue();
                        }
                        event.getTextChannel().sendMessage(

                                new EmbedBuilder()
                                        .setTitle("Daily claimed!")
                                        .setDescription("You recieved " + r + " credits")
                                        .build()

                        ).queue();
                        event.getJDA().getGuildById("517023751301234688").getTextChannelsByName(String.valueOf(userId), true).get(0).getManager().setTopic(String.valueOf(timestamp)).queue();
                    }


                } else {

                }

            } else {
                event.getTextChannel().sendMessage(

                        new EmbedBuilder()
                                .setTitle("Access denied!")
                                .setDescription("You need to vote for this bot to use this Command!\n" +
                                        "You can vote [here](https://discordbots.org/bot/406097711603908621/vote)")
                                .build()

                ).queue();
            }
        });
    }


    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
