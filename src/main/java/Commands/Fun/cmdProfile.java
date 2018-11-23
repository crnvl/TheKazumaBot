package Commands.Fun;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.discordbots.api.client.DiscordBotListAPI;

import java.time.format.DateTimeFormatter;

public class cmdProfile implements Command {

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

        if(args.length == 0) {
            String SET, XP;
            if (event.getJDA().getGuildById("514431614210670592").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0){
                SET = "None";
            }else {
                SET = event.getJDA().getGuildById("514431614210670592").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getTopic();
            }
            if(event.getJDA().getGuildById("514460308488716288").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0) {
                XP = "0";
            }else {
                int VALUE = Integer.parseInt(event.getJDA().getGuildById("514460308488716288").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getTopic());
                XP = String.valueOf(VALUE);
            }
            String userId = event.getAuthor().getId(); // ID of the user you're checking
            api.hasVoted(userId).whenComplete((hasVoted, e) -> {
                if (hasVoted){
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setTitle(event.getMessage().getAuthor().getName() + "'s Profile Card")
                                    .addField(":star: Status", SET, true)
                                    .addField("Birthday", event.getAuthor().getCreationTime().format(DateTimeFormatter.RFC_1123_DATE_TIME), true)
                                    .addField("Server Join", event.getMember().getJoinDate().format(DateTimeFormatter.RFC_1123_DATE_TIME), true)
                                    .addField("Level", XP + " XP", true)
                                    .setThumbnail(event.getAuthor().getAvatarUrl())
                                    .build()

                    ).queue();
                }else {
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setTitle(event.getMessage().getAuthor().getName() + "'s Profile Card")
                                    .addField(":star: Status", SET, true)
                                    .addField("Birthday", event.getAuthor().getCreationTime().format(DateTimeFormatter.RFC_1123_DATE_TIME), true)
                                    .addField("Server Join", event.getMember().getJoinDate().format(DateTimeFormatter.RFC_1123_DATE_TIME), true)
                                    .addField("Level", XP + " XP", true)
                                    .addField("Vote", "[Click for extended features!](https://discordbots.org/bot/406097711603908621/vote)", true)
                                    .setThumbnail(event.getAuthor().getAvatarUrl())
                                    .setFooter("You need to vote to earn XP for 12h or to set your profile status!", null)
                                    .build()

                    ).queue();
                }});


        }else {
            switch (args[0]) {
                case "status":
                    if(args.length > 1) {
                        String userId = event.getMessage().getAuthor().getId(); // ID of the user you're checking
                        api.hasVoted(userId).whenComplete((hasVoted, e) -> {
                            if (hasVoted) {
                                String STATUS = event.getMessage().getContentRaw().replace(STATIC.PREFIX + "profile status", "");
                                if (event.getJDA().getGuildById("514431614210670592").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0) {

                                    event.getJDA().getGuildById("514431614210670592").getController().createTextChannel(event.getAuthor().getId()).setTopic(STATUS).complete();

                                    event.getTextChannel().sendMessage(

                                            new EmbedBuilder()
                                                    .setTitle("Status set!")
                                                    .setDescription("You are now able to view your Status on your Profile!")
                                                    .build()

                                    ).queue();

                                } else {

                                    event.getJDA().getGuildById("514431614210670592").getTextChannelsByName(event.getAuthor().getId(), true).get(0).getManager().setTopic(STATUS).queue();

                                    event.getTextChannel().sendMessage(

                                            new EmbedBuilder()
                                                    .setTitle("Status set!")
                                                    .setDescription("You are now able to view your Status on your Profile!")
                                                    .build()

                                    ).queue();

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
                    }else {
                        event.getTextChannel().sendMessage(

                                new EmbedBuilder()
                                        .setTitle("Error")

                                        .setDescription("You need to set something as your status!")

                                        .build()

                        ).queue();
                    }
                    break;

            }
        }if(event.getMessage().getMentionedMembers().size() == 1) {
            String SET, XP;
            if (event.getJDA().getGuildById("514431614210670592").getTextChannelsByName(event.getMessage().getMentionedMembers().get(0).getUser().getId(), true).size() == 0){
                SET = "None";
            }else {
                SET = event.getJDA().getGuildById("514431614210670592").getTextChannelsByName(event.getMessage().getMentionedMembers().get(0).getUser().getId(), true).get(0).getTopic();
            }
            if(event.getJDA().getGuildById("514460308488716288").getTextChannelsByName(event.getMessage().getMentionedMembers().get(0).getUser().getId(), true).size() == 0) {
                XP = "0";
            }else {
                int VALUE = Integer.parseInt(event.getJDA().getGuildById("514460308488716288").getTextChannelsByName(event.getMessage().getMentionedMembers().get(0).getUser().getId(), true).get(0).getTopic());
                XP = String.valueOf(VALUE);
            }
            event.getTextChannel().sendMessage(

                    new EmbedBuilder()
                            .setTitle(event.getMessage().getMentionedMembers().get(0).getEffectiveName() + "'s Profile Card")
                            .addField(":star: Status", SET, true)
                            .addField("Birthday", event.getMessage().getMentionedMembers().get(0).getUser().getCreationTime().format(DateTimeFormatter.RFC_1123_DATE_TIME), true)
                            .addField("Server Join", event.getMessage().getMentionedMembers().get(0).getJoinDate().format(DateTimeFormatter.RFC_1123_DATE_TIME), true)
                            .addField("Level", XP + " XP", true)
                            .setThumbnail(event.getMessage().getMentionedMembers().get(0).getUser().getAvatarUrl())
                            .build()

            ).queue();

        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
