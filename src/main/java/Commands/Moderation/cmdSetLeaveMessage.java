package Commands.Moderation;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdSetLeaveMessage implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {


        if(event.getGuild().getController().getGuild().getMember(event.getMember().getUser()).hasPermission(Permission.MANAGE_SERVER)) {

            if(args.length == 0) {

                event.getTextChannel().sendMessage(

                        new EmbedBuilder()
                                .setTitle("Command Usage")
                                .setDescription("Use ``" + STATIC.PREFIX + "setleavemessage <your leave meesage>`` to set a new Leave Message for this Server")
                                .addField("Example", "``" + STATIC.PREFIX + "setleavemessage %USER% left %SERVER%! We are now %MEMBERCOUNT% Users here!``", true)
                                .addField("Attributes", "``%SERVER%`` shows the server name\n" +
                                        "``%USER%`` gets a mention of the user\n" +
                                        "``&MEMBERCOUNT%`` will show the current membercount of the server", true)
                                .build()

                ).queue();

            }else {

                String LEAVE_MESSAGE;
                String JOIN_CHANNEL;
                LEAVE_MESSAGE = event.getMessage().getContentRaw().replace(STATIC.PREFIX + "setleavemessage ", "");

                if (event.getJDA().getGuildById("513297201666064390").getTextChannelsByName(event.getGuild().getId(), true).size() == 0) {

                    event.getJDA().getGuildById("513297201666064390").getController().createTextChannel(event.getGuild().getId()).setName(event.getGuild().getId()).setTopic(LEAVE_MESSAGE).complete();
                    if(event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).size() == 0) {

                        event.getTextChannel().sendMessage(

                                new EmbedBuilder()
                                        .setTitle("Leave Message set!")
                                        .setDescription("No Welcome Message Channel has been set! Please set one using ``" + STATIC.PREFIX + "announcechannel <channel mention>``")
                                        .addField("New Message", "``" + LEAVE_MESSAGE + "``", true)
                                        .build()

                        ).queue();

                    }else {
                        JOIN_CHANNEL = event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).get(0).getTopic();
                        event.getTextChannel().sendMessage(

                                new EmbedBuilder()
                                        .setTitle("Leave Message set!")
                                        .setDescription("Leave Messages will appear in " + JOIN_CHANNEL)
                                        .addField("New Message", "``" + LEAVE_MESSAGE + "``", true)
                                        .build()

                        ).queue();

                    }

                } else {

                    event.getJDA().getGuildById("513297201666064390").getTextChannelsByName(event.getGuild().getId(), true).get(0).getManager().setTopic(LEAVE_MESSAGE).queue();
                    if(event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).size() == 0) {

                        event.getTextChannel().sendMessage(

                                new EmbedBuilder()
                                        .setTitle("Leave Message set!")
                                        .setDescription("No Welcome Message Channel has been set! Please set one using ``" + STATIC.PREFIX + "announcechannel <channel mention>``")
                                        .addField("New Message", "``" + LEAVE_MESSAGE + "``", true)
                                        .build()

                        ).queue();

                    }else {
                        JOIN_CHANNEL = event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).get(0).getTopic();
                        event.getTextChannel().sendMessage(

                                new EmbedBuilder()
                                        .setTitle("Leave Message set!")
                                        .setDescription("Leave Messages will appear in " + JOIN_CHANNEL)
                                        .addField("New Message", "``" + LEAVE_MESSAGE + "``", true)
                                        .build()

                        ).queue();
                    }

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
