package Listeners.Announcements;

import Util.STATIC;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class CountingChannelListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getMessage().getAuthor().isBot()) {


        }else {
            if (event.getJDA().getGuildById("519454815806554112").getTextChannelsByName(event.getGuild().getId(), true).size() == 0) {

            } else {
                try {
                    String cChannel = event.getJDA().getGuildById("519454815806554112").getTextChannelsByName(event.getGuild().getId(), true).get(0).getTopic().replace("#", "").replace("<", "").replace(">", "");
                    if (event.getMessage().getTextChannel().getId().contains(cChannel)) {

                        if (event.getMessage().getContentRaw().startsWith(event.getTextChannel().getTopic())) {
                            Integer newNUMBER = Integer.valueOf(event.getTextChannel().getTopic());
                            newNUMBER++;
                            event.getTextChannel().getManager().setTopic(String.valueOf(newNUMBER)).queue();
                        } else {
                            event.getMessage().delete().queue();
                            event.getTextChannel().sendMessage(event.getAuthor().getAsMention() + ", the next Message must start with " + event.getTextChannel().getTopic() + "!").queue(s -> s.delete().queueAfter(2, TimeUnit.SECONDS));
                        }

                    }
                }catch (Exception e) {
                    event.getTextChannel().sendMessage("You need to set a start number first! Try ``" + STATIC.PREFIX + "setcountstart``").queue();
                }
            }
        }

    }
}
