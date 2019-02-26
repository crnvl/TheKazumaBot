package Commands.Social;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import java.util.Random;

public class cmdRedeem implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
            if (event.getJDA().getGuildById("548636655456747521").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0) {
                Random credits = new Random();
                int y = credits.nextInt(14) + 240;

                if (event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0) {
                    event.getJDA().getGuildById("515083259957346304").getController().createTextChannel(event.getAuthor().getId()).setTopic(String.valueOf(y)).queue();
                    event.getTextChannel().sendMessage(
                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Success!")
                                    .setDescription("You successfully claimed " + y + " credits!\n" +
                                            "You can claim your daily every 24 hours!")
                                    .build()
                    ).queue();
                    event.getJDA().getGuildById("548636655456747521").getController().createTextChannel(event.getAuthor().getId()).setTopic(String.valueOf(event.getMessage().getCreationTime().getHour())).queue();
                } else {
                    int x, z;
                    x = Integer.parseInt(event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getTopic());
                    z = x + y;
                    event.getJDA().getGuildById("515083259957346304").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getManager().setTopic(String.valueOf(z)).queue();
                    event.getTextChannel().sendMessage(
                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Success!")
                                    .setDescription("You successfully claimed " + y + " credits!\n" +
                                            "You can claim your daily every 24 hours!")
                                    .build()
                    ).queue();
                    event.getJDA().getGuildById("548636655456747521").getController().createTextChannel(event.getAuthor().getId()).setTopic(String.valueOf(event.getMessage().getCreationTime().getHour())).queue();
                }
            } else {
                event.getTextChannel().sendMessage(
                        new EmbedBuilder()
                                .setColor(STATIC.MAIN)
                                .setTitle("Please try again later!")
                                .setDescription("You already claimed your daily today!")
                                .build()

                ).queue();
            }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
