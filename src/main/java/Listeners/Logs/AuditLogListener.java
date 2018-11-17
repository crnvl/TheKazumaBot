package Listeners.Logs;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.guild.update.GenericGuildUpdateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class AuditLogListener extends ListenerAdapter {

    public void onGenericGuildUpdate(GenericGuildUpdateEvent event) {
        try {
            event.getGuild().getTextChannelsByName("kazuma-log", true).get(0).sendMessage(

                    new EmbedBuilder()
                            .setTitle("New Guild Change")
                            .addField("Old Value", "``" + event.getOldValue() + "``", false)
                            .addField("New Value", "``" + event.getNewValue() + "``", false)
                            .addField("Changed Value", "``" + event.getPropertyIdentifier() + "``", true)
                            .setDescription("Changes have been made on ``" + event.getEntity().getName() + "``")
                            .setFooter("Turn the Audit log off by renaming or deleting this channel", null)
                            .build()

            ).queue();
        }catch (Exception e){

        }
    }
}
