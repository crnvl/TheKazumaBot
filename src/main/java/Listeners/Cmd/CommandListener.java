package Listeners.Cmd;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import Core.Execute.CommandHandler;
import Util.STATIC;
import java.util.Objects;

public class CommandListener extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {

            if (event.getMessage().getContentRaw().startsWith(STATIC.PREFIX)
                    && !Objects.equals(event.getMessage().getAuthor().getId(), event.getJDA().getSelfUser().getId())
                    && !event.getMessage().getAuthor().isBot()) {
                CommandHandler.handleCommand(CommandHandler.parse.parser(event.getMessage().getContentRaw(), event,STATIC.PREFIX));
            } else {
                return;
            }
    }
}
