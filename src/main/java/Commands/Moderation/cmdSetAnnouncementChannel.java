package Commands.Moderation;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdSetAnnouncementChannel implements Command {
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
                                .setTitle("Command Usage")
                                .setDescription("Use ``" + STATIC.PREFIX + "announcechannel <channel mention>`` to set the Announcement Channel for this Server")
                                .build()

                ).queue();
            }else {

                if(event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).size() == 1) {
                    event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).get(0).getManager().setTopic(event.getMessage().getMentionedChannels().get(0).getAsMention()).queue();
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setTitle("Announcements Channel set!")
                                    .setDescription("The new Announcement Channel is " + event.getMessage().getMentionedChannels().get(0).getAsMention() )
                                    .build()

                    ).queue();
                }else {
                    event.getJDA().getGuildById("513297363608272896").getController().createTextChannel(event.getGuild().getId()).setTopic(event.getMessage().getMentionedChannels().get(0).getAsMention()).queue();
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setTitle("Announcements Channel set!")
                                    .setDescription("The new Announcement Channel is " + event.getMessage().getMentionedChannels().get(0).getAsMention() )
                                    .build()

                    ).queue();
                }

            }

        }else {

            event.getTextChannel().sendMessage(

                    new EmbedBuilder()
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
