package Commands.Moderation;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdSetCountingChannel implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(event.getGuild().getController().getGuild().getMember(event.getMember().getUser()).hasPermission(Permission.MANAGE_SERVER)) {

            if(event.getMessage().getMentionedChannels().size() == 0) {

                event.getTextChannel().sendMessage(

                        new EmbedBuilder()
                                .setColor(STATIC.MAIN)
                                .setTitle("Command Usage")
                                .setDescription("Use ``" + STATIC.PREFIX + "setcountchannel <#channel>`` to set a counting channel for this Server")
                                .addField("Example", "``" + STATIC.PREFIX + "setcountchannel #counting``", true)
                                .addField("Deactivate Counting Channel", "Use ``" + STATIC.PREFIX + "setcountchannel disable``", false)
                                .build()

                ).queue();

            }else if(args[0].contains("disable")) {

                try {

                    event.getJDA().getGuildById("519454815806554112").getTextChannelsByName(event.getGuild().getId(), true).get(0).delete().queue();
                    event.getJDA().getGuildById("521278542063992832").getTextChannelsByName(event.getGuild().getId(), true).get(0).delete().queue();

                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Counting Channel disabled!")
                                    .setDescription("Your Counting Channel has been disabled successfully!")
                                    .build()

                    ).queue();

                }catch (Exception e) {
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Error")
                                    .setDescription("There was no Counting Channel that could have been disabled!")
                                    .build()

                    ).queue();
                }

            }else {

                if(event.getJDA().getGuildById("519454815806554112").getTextChannelsByName(event.getGuild().getId(), true).size() == 0) {

                    event.getJDA().getGuildById("519454815806554112").getController().createTextChannel(event.getGuild().getId()).setTopic(event.getMessage().getMentionedChannels().get(0).getAsMention()).queue();
                    event.getJDA().getGuildById("521278542063992832").getController().createTextChannel(event.getGuild().getId()).setTopic("1").queue();
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Counting Channel set!")
                                    .setDescription("Your Counting Channel has been set successfully!")
                                    .addField("Current Counting Channel", event.getMessage().getMentionedChannels().get(0).getAsMention(), false)
                                    .build()

                    ).queue();

                }else {

                    event.getJDA().getGuildById("519454815806554112").getTextChannelsByName(event.getGuild().getId(), true).get(0).getManager().setTopic(event.getMessage().getMentionedChannels().get(0).getAsMention()).queue();
                    if(event.getJDA().getGuildById("521278542063992832").getTextChannelsByName(event.getGuild().getId(), true).size() == 0) {
                        event.getJDA().getGuildById("521278542063992832").getController().createTextChannel(event.getGuild().getId()).setTopic("1").queue();
                    }else {
                        event.getJDA().getGuildById("521278542063992832").getTextChannelsByName(event.getGuild().getId(), true).get(0).getManager().setTopic("1").queue();
                    }
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Counting Channel set!")
                                    .setDescription("Your Counting Channel has been set successfully!")
                                    .addField("Current Counting Channel", event.getMessage().getMentionedChannels().get(0).getAsMention(), false)
                                    .build()

                    ).queue();

                }

            }

        }else {

            event.getTextChannel().sendMessage(

                    new EmbedBuilder()
                            .setColor(STATIC.MAIN)
                            .setTitle("Action denied")
                            .setDescription("You are not able to run this Command!")
                            .addField("Reason", "``Insufficient Permissions``", false)
                            .addField("Required", "``Manage Server Permission``", false)
                            .build()

            ).queue();

        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
