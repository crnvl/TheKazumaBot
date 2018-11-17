package Listeners.Private;

import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class PrivateResponder extends ListenerAdapter {
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {

        } else {
            event.getAuthor().openPrivateChannel().queue(channel -> channel.sendMessage(":x: Please do not send me messages in DM. My Commands can be used on a server!").queue());

        }
    }
}
