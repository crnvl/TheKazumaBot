package Commands.Moderation;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdSetGlobalChat implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(event.getGuild().getController().getGuild().getMember(event.getMember().getUser()).hasPermission(Permission.MANAGE_SERVER)) {

            if (event.getMessage().getMentionedChannels().size() == 0) {
                event.getTextChannel().sendMessage(

                        new EmbedBuilder()
                                .setColor(STATIC.MAIN)
                                .setTitle("Command Usage")
                                .setDescription("Use ``" + STATIC.PREFIX + "setglobalchat <#channel>`` to set a global chat for this server! (Don't include ``<`` or ``>``)")
                                .addField("Example", "``" + STATIC.PREFIX + "setglobalchat #global``", false)
                                .addField("Information", "The Content in your global chat will be available for a lot of servers, not just yours!", false)
                                .addField("Disable Global Chat", "``" + STATIC.PREFIX + "setglobalchat disable``", false)
                                .build()

                ).queue();


            }else if(args[0].contains("disable")) {

                try {

                    event.getJDA().getGuildById("523536808265383937").getTextChannelsByName(event.getGuild().getId(), true).get(0).delete().queue();

                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Global Chat disabled!")
                                    .setDescription("Your Global Chat has been disabled successfully!")
                                    .build()

                    ).queue();
                }catch (Exception e) {

                }
            }else {

                if(event.getJDA().getGuildById("523536808265383937").getTextChannelsByName(event.getGuild().getId(), true).size() == 0) {

                    event.getJDA().getGuildById("523536808265383937").getController().createTextChannel(event.getGuild().getId()).setName(event.getGuild().getId()).setTopic(event.getMessage().getMentionedChannels().get(0).getId()).complete();
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Global Chat set!")
                                    .setDescription("Your Global Chat has been set successfully!")
                                    .addField("Current Global Chat", event.getMessage().getMentionedChannels().get(0).getAsMention(), false)
                                    .build()

                    ).queue();

                }else {
                    event.getJDA().getGuildById("523536808265383937").getTextChannelsByName(event.getGuild().getId(), true).get(0).getManager().setTopic(event.getMessage().getMentionedChannels().get(0).getId()).complete();
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setColor(STATIC.MAIN)
                                    .setTitle("Global Chat set!")
                                    .setDescription("Your Global Chat has been set successfully!")
                                    .addField("Current Global Chat", event.getMessage().getMentionedChannels().get(0).getAsMention(), false)
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
