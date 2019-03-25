package Listeners.Cmd;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import Core.Execute.CommandHandler;
import Util.STATIC;
import org.discordbots.api.client.DiscordBotListAPI;

import java.util.Objects;

public class CommandListener extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

            if (event.getMessage().getContentRaw().startsWith(STATIC.PREFIX)
                    && !Objects.equals(event.getMessage().getAuthor().getId(), event.getJDA().getSelfUser().getId())
                    && !event.getMessage().getAuthor().isBot()) {


                if (event.getJDA().getGuildById("559488253376462878").getTextChannelsByName(event.getAuthor().getId(), true).size() == 0) {


                    CommandHandler.handleCommand(CommandHandler.parse.parser(event.getMessage().getContentRaw(), event, STATIC.PREFIX));

                } else {
                    event.getTextChannel().sendMessage(
                            new EmbedBuilder()
                                    .setTitle(event.getAuthor().getName() + " you are banned from Kazuma")
                                    .setDescription("Due to inappropriate Actions in our Globalchat, you're temporarily banned from acting as a participant. If you want to get your access back, apply on the official discord server")
                                    .addField("Support", "If this is an error please contact us. [join our support server](https://discord.gg/fyJ6PFj)", false).build()



                    ).queue();
                }

            } else {
                return;
            }

    }
}
