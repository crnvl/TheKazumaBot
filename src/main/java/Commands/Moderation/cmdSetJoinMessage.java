package Commands.Moderation;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdSetJoinMessage implements Command {
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
                                .setDescription("Use ``" + STATIC.PREFIX + "setjoinmessage <your join meesage>`` to set a new Join Message for this Server")
                                .addField("Example", "``" + STATIC.PREFIX + "setjoinmessage Welcome on %SERVER%, %USER%! You are the %MEMBERCOUNT%th User here!``", true)
                                .addField("Attributes", "``%SERVER%`` shows the server name\n" +
                                        "``%USER%`` gets a mention of the joined user\n" +
                                        "``&MEMBERCOUNT%`` will show the current membercount of the server", true)
                                .build()

                ).queue();

            }else {

                String JOIN_MESSAGE;
                String JOIN_CHANNEL;
                JOIN_MESSAGE = event.getMessage().getContentRaw().replace(STATIC.PREFIX + "setjoinmessage ", "");

                if (event.getJDA().getGuildById("513296609623277599").getTextChannelsByName(event.getGuild().getId(), true).size() == 0) {

                    event.getJDA().getGuildById("513296609623277599").getController().createTextChannel(event.getGuild().getId()).setName(event.getGuild().getId()).setTopic(JOIN_MESSAGE).complete();
                    if(event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).size() == 0) {

                        event.getTextChannel().sendMessage(

                                new EmbedBuilder()
                                        .setTitle("Join Message set!")
                                        .setDescription("No Welcome Message Channel has been set! Please set one using ``" + STATIC.PREFIX + "announcechannel <channel mention>``")
                                        .addField("New Message", "``" + JOIN_MESSAGE + "``", true)
                                        .build()

                        ).queue();

                    }else {
                        JOIN_CHANNEL = event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).get(0).getTopic();
                        event.getTextChannel().sendMessage(

                                new EmbedBuilder()
                                        .setTitle("Join Message set!")
                                        .setDescription("Join Messages will appear in " + JOIN_CHANNEL)
                                        .addField("New Message", "``" + JOIN_MESSAGE + "``", true)
                                        .build()

                        ).queue();

                    }

                } else {

                    event.getJDA().getGuildById("513296609623277599").getTextChannelsByName(event.getGuild().getId(), true).get(0).getManager().setTopic(JOIN_MESSAGE).queue();
                    if(event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).size() == 0) {

                        event.getTextChannel().sendMessage(

                                new EmbedBuilder()
                                        .setTitle("Join Message set!")
                                        .setDescription("No Welcome Message Channel has been set! Please set one using ``" + STATIC.PREFIX + "announcechannel <channel mention>``")
                                        .addField("New Message", "``" + JOIN_MESSAGE + "``", true)
                                        .build()

                        ).queue();

                    }else {
                        JOIN_CHANNEL = event.getJDA().getGuildById("513297363608272896").getTextChannelsByName(event.getGuild().getId(), true).get(0).getTopic();
                        event.getTextChannel().sendMessage(

                                new EmbedBuilder()
                                        .setTitle("Join Message set!")
                                        .setDescription("Join Messages will appear in " + JOIN_CHANNEL)
                                        .addField("New Message", "``" + JOIN_MESSAGE + "``", true)
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
