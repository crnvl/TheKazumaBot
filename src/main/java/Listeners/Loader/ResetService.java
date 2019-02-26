package Listeners.Loader;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class ResetService extends ListenerAdapter{
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getCreationTime().getHour() == 0) {
            for (int i = 0; i < event.getJDA().getGuildById("548636655456747521").getTextChannels().size(); i++) {
                event.getJDA().getGuildById("548636655456747521").getTextChannels().get(i).delete().complete();
            }
        }
    }
}
