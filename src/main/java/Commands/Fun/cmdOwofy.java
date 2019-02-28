package Commands.Fun;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import pw.aru.api.nekos4j.Nekos4J;
import pw.aru.api.nekos4j.text.TextProvider;

public class cmdOwofy implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        Nekos4J api = new Nekos4J.Builder().build();

        TextProvider textProvider = api.getTextProvider();
        String message = event.getMessage().getContentRaw().replace(STATIC.PREFIX + " owofy", "");
        textProvider.owoifyText(message).async(text->{
            event.getTextChannel().sendMessage("**" + text + "**").queue();
        });

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
