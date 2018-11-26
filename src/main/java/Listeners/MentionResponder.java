package Listeners;

import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MentionResponder extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContentDisplay().contains("@" + event.getGuild().getSelfMember().getEffectiveName())) {
            event.getTextChannel().sendMessage(

                    new EmbedBuilder()
                            .setTitle("Bot information")
                            .setDescription("Here is your requested Bot information!")
                            .addField("Prefix",  "``" + STATIC.PREFIX + "``", true)
                            .addField("Version", "``" + STATIC.VERSION + "``", true)
                            .addField("Help", "``" + STATIC.PREFIX + "help``", true)
                            .build()

            ).queue();
        }
    }
}
