package Listeners.Logs;

import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.GuildBanEvent;
import net.dv8tion.jda.core.events.guild.update.GuildUpdateNameEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.core.events.role.RoleCreateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class AuditLogListener extends ListenerAdapter {

    @Override
    public void onGuildMessageDelete(GuildMessageDeleteEvent event) {
        try {
            event.getGuild().getTextChannelsByName("kazuma-log", true).get(0).sendMessage(

                    new EmbedBuilder()
                            .setColor(STATIC.MAIN)
                            .setTitle("Message has been deleted")
                            .addField("Message ID", "``" + event.getMessageId() + "``", true)
                            .addField("Channel", "``" + event.getChannel().getName() + "``", true)
                            .build()

            ).queue();
        }catch (Exception e){

        }
    }

    @Override
    public void onGuildBan(GuildBanEvent event) {
        try {
            event.getGuild().getTextChannelsByName("kazuma-log", true).get(0).sendMessage(

                    new EmbedBuilder()
                            .setColor(STATIC.MAIN)
                            .setTitle("New Ban")
                            .addField("User", "``" + event.getUser().getAsTag() + "``", true)
                            .build()

            ).queue();
        }catch (Exception e){

        }
    }

    @Override
    public void onGuildUpdateName(GuildUpdateNameEvent event) {
        try {
            event.getGuild().getTextChannelsByName("kazuma-log", true).get(0).sendMessage(

                    new EmbedBuilder()
                            .setColor(STATIC.MAIN)
                            .setTitle("Guild Name Update")
                            .addField("Old Name", "``" + event.getOldValue() + "``", true)
                            .addField("New Name", "``" + event.getNewName()  + "``", true)
                            .build()

            ).queue();
        }catch (Exception e){

        }
    }

    @Override
    public void onRoleCreate(RoleCreateEvent event) {
        try {
            event.getGuild().getTextChannelsByName("kazuma-log", true).get(0).sendMessage(

                    new EmbedBuilder()
                            .setColor(STATIC.MAIN)
                            .setTitle("New Role Created")
                            .addField("Name", "``" + event.getRole().getName() + "``", true)
                            .addField("Mentionable", "``" + event.getRole().isMentionable() + "``", true)
                            .addField("Permissions", "``" + event.getRole().getPermissionsRaw() + "``", true)
                            .addField("Position", "``" + event.getRole().getPosition() + "``", true)
                            .build()

            ).queue();
        }catch (Exception e){

        }
    }
}
