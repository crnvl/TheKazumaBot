package Commands.Moderation;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdSetAutorole implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if(event.getGuild().getController().getGuild().getMember(event.getMember().getUser()).hasPermission(Permission.MANAGE_SERVER)) {

            if (event.getMessage().getMentionedRoles().size() == 0) {
                event.getTextChannel().sendMessage(

                        new EmbedBuilder()
                                .setTitle("Command Usage")
                                .setDescription("Use ``" + STATIC.PREFIX + "setautorole <@role>`` to set an autorole for this server! (Don't include ``<`` or ``>``)")
                                .addField("Example", "``" + STATIC.PREFIX + "setautorole @member``", false)
                                .addField("Information", "The Bot Role has to be higher as the autorole!", false)
                                .addField("Disable autorole", "``" + STATIC.PREFIX + "setautorole disable``", false)
                                .build()

                ).queue();
            }else {

                if(event.getJDA().getGuildById("513717910414295080").getTextChannelsByName(event.getGuild().getId(), true).size() == 0) {

                    event.getJDA().getGuildById("513717910414295080").getController().createTextChannel(event.getGuild().getId()).setName(event.getGuild().getId()).setTopic(event.getMessage().getMentionedRoles().get(0).getId()).complete();
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setTitle("Autorole set!")
                                    .setDescription("Your Autorole has been set successfully!")
                                    .addField("Current Autorole", event.getMessage().getMentionedRoles().get(0).getAsMention(), false)
                                    .build()

                    ).queue();

                }else {
                    event.getJDA().getGuildById("513717910414295080").getTextChannelsByName(event.getGuild().getId(), true).get(0).getManager().setTopic(event.getMessage().getMentionedRoles().get(0).getId()).complete();
                    event.getTextChannel().sendMessage(

                            new EmbedBuilder()
                                    .setTitle("Autorole set!")
                                    .setDescription("Your Autorole has been set successfully!")
                                    .addField("Current Autorole", event.getMessage().getMentionedRoles().get(0).getAsMention(), false)
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
