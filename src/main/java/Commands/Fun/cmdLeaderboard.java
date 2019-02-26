package Commands.Fun;

import Commands.Command;
import net.dv8tion.jda.core.EmbedBuilder;
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
        if(args.length < 1) {
            event.getTextChannel().sendMessage(

                    new EmbedBuilder()
                            .setTitle("Command Usage")
                            .setDescription("What kind of Leaderboard do you want to see? Use ``/k leaderboard [xp/counting/credits]``!")
                            .build()

            ).queue();
        }
//515083259957346304
        switch (args[0]) {
            case "counting":
                Map<String, Long> unsortMap = new HashMap<>();


                for (int i = 0; i < event.getJDA().getGuildById("519454815806554112").getTextChannels().size(); i++) {
                    try {
                        //unsortMap.put(event.getJDA().getTextChannelsByName(String.valueOf(event.getJDA().getTextChannelById(event.getJDA().getGuildById("519454815806554112").getTextChannels().get(i).getTopic())), true).get(0).getGuild().getName()
                        unsortMap.put(event.getJDA().getTextChannelById(event.getJDA().getGuildById("519454815806554112").getTextChannels().get(i).getTopic().replace("<#", "").replace(">", "")).getGuild().getName()
                                , Long.valueOf(String.valueOf(event.getJDA().getGuildById("521278542063992832").getTextChannelsByName(event.getJDA().getGuildById("519454815806554112").getTextChannels().get(i).getName(), true).get(0).getTopic())));
                    }catch (Exception e) {

                    }
                }



                Map<String, Long> result = new LinkedHashMap<>();
                unsortMap.entrySet().stream()
                        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                        .forEachOrdered(z -> result.put(z.getKey(), z.getValue()));

                String[] set = result.keySet().toArray(new String[0]);
                ArrayList<Long> values = new ArrayList<>(result.values());
                EmbedBuilder builder = new EmbedBuilder();

                builder.appendDescription("``Counting Leaderboard``\n");

                for (int i = 0; i < values.size(); i++) {
                    if (i <= 4)
                        builder.appendDescription(i + 1 + ". **" + set[i] + "** at ``" + values.get(i) + "``\n");
                }

                event.getTextChannel().sendMessage(builder.build()).queue();
                break;

            case "credits":
                Map<String, Long> unsortMapCredits = new HashMap<>();


                for (int i = 0; i < event.getJDA().getGuildById("515083259957346304").getTextChannels().size(); i++) {
                    try {
                        //unsortMap.put(event.getJDA().getTextChannelsByName(String.valueOf(event.getJDA().getTextChannelById(event.getJDA().getGuildById("519454815806554112").getTextChannels().get(i).getTopic())), true).get(0).getGuild().getName()
                        unsortMapCredits.put(event.getJDA().getUserById(event.getJDA().getGuildById("515083259957346304").getTextChannels().get(i).getName()).getName()
                                , Long.valueOf(event.getJDA().getGuildById("515083259957346304").getTextChannels().get(i).getTopic()));
                    }catch (Exception e) {

                    }
                }



                Map<String, Long> resultCredits = new LinkedHashMap<>();
                unsortMapCredits.entrySet().stream()
                        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                        .forEachOrdered(z -> resultCredits.put(z.getKey(), z.getValue()));

                String[] setCredits = resultCredits.keySet().toArray(new String[0]);
                ArrayList<Long> valuesCredits = new ArrayList<>(resultCredits.values());
                EmbedBuilder builderCredits = new EmbedBuilder();

                builderCredits.appendDescription("``Credits Leaderboard``\n");

                for (int i = 0; i < valuesCredits.size(); i++) {
                    if (i <= 4)
                        builderCredits.appendDescription(i + 1 + ". **" + setCredits[i] + "** owns ``" + valuesCredits.get(i) + " Credits``\n");
                }

                event.getTextChannel().sendMessage(builderCredits.build()).queue();
                break;

            case "xp":
                Map<String, Long> unsortMapXP = new HashMap<>();


                for (int i = 0; i < event.getJDA().getGuildById("514460308488716288").getTextChannels().size(); i++) {
                    try {
                        //unsortMap.put(event.getJDA().getTextChannelsByName(String.valueOf(event.getJDA().getTextChannelById(event.getJDA().getGuildById("519454815806554112").getTextChannels().get(i).getTopic())), true).get(0).getGuild().getName()
                        unsortMapXP.put(event.getJDA().getUserById(event.getJDA().getGuildById("514460308488716288").getTextChannels().get(i).getName()).getName()
                                , Long.valueOf(event.getJDA().getGuildById("514460308488716288").getTextChannels().get(i).getTopic()));
                    }catch (Exception e) {

                    }
                }



                Map<String, Long> resultXP = new LinkedHashMap<>();
                unsortMapXP.entrySet().stream()
                        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                        .forEachOrdered(z -> resultXP.put(z.getKey(), z.getValue()));

                String[] setXP = resultXP.keySet().toArray(new String[0]);
                ArrayList<Long> valuesXP = new ArrayList<>(resultXP.values());
                EmbedBuilder builderXP = new EmbedBuilder();

                builderXP.appendDescription("``Experience Points Leaderboard``\n");
                builderXP.setFooter("You earn experience points by writing messages while using a 12h XP Boost. You will receive those boosts by voting (/k vote)", null);

                for (int i = 0; i < valuesXP.size(); i++) {
                    if (i <= 4)
                        builderXP.appendDescription(i + 1 + ". **" + setXP[i] + "** has ``" + valuesXP.get(i) + " XP``\n");
                }

                event.getTextChannel().sendMessage(builderXP.build()).queue();
                break;
        }


    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
