package Commands.Fun;

import Commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class cmdLeaderboard implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        TextChannel x = null;
        int wieVieleTextChannels = 10;

        Map<String, Long> unsortMap = new HashMap<>();


        for (int i = 0; i < event.getJDA().getGuildById("519454815806554112").getTextChannels().size(); i++) {
            unsortMap.put(event.getJDA().getTextChannelById(event.getJDA().getGuildById("519454815806554112").getTextChannels().get(i).getTopic().replaceAll("[^0-9]", "")).getGuild().getName()
                    , Long.valueOf(event.getJDA().getTextChannelById(event.getJDA().getGuildById("519454815806554112").getTextChannels().get(i).getTopic().replaceAll("[^0-9]", "")).getTopic()));
        }



        Map<String, Long> result = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(z -> result.put(z.getKey(), z.getValue()));

        String[] set = result.keySet().toArray(new String[0]);
        ArrayList<Long> values = new ArrayList<>(result.values());
        EmbedBuilder builder = new EmbedBuilder();

        builder.appendDescription("``Counting Leaderboard``\n");

        for (int i = 0; i < event.getJDA().getGuildById("519454815806554112").getTextChannels().size(); i++) {
            builder.appendDescription(i + 1 + ". **" + set[i] + "** at ``" + values.get(i) + "``\n");
        }

        event.getTextChannel().sendMessage(builder.build()).queue();

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
