package Commands.Fun;

import Commands.Command;
import Util.STATIC;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import pw.aru.api.nekos4j.Nekos4J;
import pw.aru.api.nekos4j.text.TextProvider;

import java.awt.*;

public class cmdOwofy implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        Nekos4J api = new Nekos4J.Builder().build();
        if(args.length != 0) {
            TextProvider textProvider = api.getTextProvider();
            String messageGet = event.getMessage().getContentRaw().replace("/k owofy", "");
            textProvider.owoifyText(messageGet).async(text -> {
                event.getTextChannel().sendMessage("**" + text + "**").queue();
            });
        }else {
            event.getTextChannel().sendMessage(
                    new EmbedBuilder()
                            .setTitle("Please specify your request!")
                            .setColor(Color.RED)
                            .setDescription("Please use this command like this: ``/k owofy <text>``")
                            .build()
            ).queue();
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
