package Commands.Moderation;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class setCountStarter implements Command {
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
                                .setDescription("Use ``" + STATIC.PREFIX + "setcountstart <number>`` to set the number where to start counting from")
                                .addField("Example", "``" + STATIC.PREFIX + "setcountstart 2513``", true)
                                .build()

                ).queue();

            }else {

                if(event.getJDA().getGuildById("519454815806554112").getTextChannelsByName(event.getGuild().getId(), true).size() == 0) {

                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setTitle("Error")
                                    .setDescription("Please set a counting channel first!\nUse " +
                                            "``" + STATIC.PREFIX + "setcountchannel <#channel>``")
                                    .build()

                    ).queue();

                }else {
                    try {
                        Integer startNumber = Integer.valueOf(args[0]);
                        String countCHANNEL = event.getJDA().getGuildById("519454815806554112").getTextChannelsByName(event.getGuild().getId(), true).get(0).getTopic().replace("#", "").replace("<", "").replace(">", "");

                        event.getGuild().getController().getGuild().getTextChannelById(countCHANNEL).getManager().setTopic(String.valueOf(startNumber)).queue();

                        event.getTextChannel().sendMessage(

                                new EmbedBuilder()
                                        .setTitle("Start Number set!")
                                        .setDescription("The Start Number for this Server has been set successfully!")
                                        .addField("Current Starting Number", "``" + startNumber + "``", false)
                                        .build()

                        ).queue();
                    }catch (Exception fck) {

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
